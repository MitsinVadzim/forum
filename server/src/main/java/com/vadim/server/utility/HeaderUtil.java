package com.vadim.server.utility;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import static com.vadim.server.utility.PathUtils.generatePath;
import static org.springframework.http.HttpHeaders.LINK;
import static org.springframework.http.HttpHeaders.LOCATION;


@UtilityClass
public final class HeaderUtil {

    private static final String xTotalCount = "X-Total-Count";

    @SneakyThrows
    public static HttpHeaders generateLocationHeader(final String baseUrl, final Object... pathVariables) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(LOCATION, generatePath(baseUrl, pathVariables));
        return headers;
    }


    public HttpHeaders generatePaginationHeaders(final String baseUrl, final Page page, final Object... pathVariables) {
        final String methodPath = generatePath(baseUrl, pathVariables);
        final StringBuilder link = new StringBuilder();

        // first link
        link.append(generatePaginationLink(methodPath, 1, page.getSize(), "first", true));

        // previous link
        if (page.getNumber() > 0) {
            link.append(generatePaginationLink(methodPath, page.getNumber(), page.getSize(), "prev", true));
        }

        // next link
        if (page.getNumber() + 1 < page.getTotalPages()) {
            link.append(generatePaginationLink(methodPath, 1, page.getSize(), "next", true));
        }

        // last link
        final int lastPage = page.getTotalPages() > 0 ? page.getTotalPages() : 1;
        link.append(generatePaginationLink(methodPath, lastPage, page.getSize(), "last", false));

        final HttpHeaders headers = new HttpHeaders();
        headers.add(LINK, link.toString());
        headers.add(xTotalCount, Long.toString(page.getTotalElements()));
        return headers;
    }

    private String generatePaginationLink(
            final String methodPath,
            final int page,
            final int size,
            final String rel,
            final boolean next
    ) {
        return "<" + generatePaginationUri(methodPath, page, size) + ">; rel=\"" + rel + "\"" + (next ? ", " : "");
    }

    private String generatePaginationUri(final String methodPath, final int page, final int size) {
        return UriComponentsBuilder.fromUriString(methodPath)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();
    }
}
