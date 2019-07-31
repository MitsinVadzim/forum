package com.vadim.server.utility;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import static com.vadim.server.dto.enums.HttpHeader.X_TOTAL_COUNT;
import static org.springframework.http.HttpHeaders.LINK;

@UtilityClass
public class HeaderUtility {

    public static <T> HttpHeaders createPaginationHeaders(final Page<T> page, final String methodPath) {

        return buildHeaders(page, UriComponentsBuilder.fromUriString(methodPath).toUriString());
    }

    private static <T> HttpHeaders buildHeaders(final Page<T> page, final String baseUri) {

        String link = "<" + buildPageUri(baseUri, 1, page.getSize()) + ">; rel=\"first\", ";
        if (page.hasPrevious()) {
            link += "<" + buildPageUri(baseUri, page.getNumber(), page.getSize()) + ">; rel=\"prev\", ";
        }
        if (page.hasNext()) {
            link += "<" + buildPageUri(baseUri, page.getNumber() + 2, page.getSize()) + ">; rel=\"next\", ";
        }
        int lastPage = page.getTotalPages() == 0 ? 1 : page.getTotalPages();
        link += "<" + buildPageUri(baseUri, lastPage, page.getSize()) + ">; rel=\"last\"";

        HttpHeaders headers = new HttpHeaders();
        headers.add(LINK, link);
        headers.add(X_TOTAL_COUNT.toString(), Long.toString(page.getTotalElements()));
        return headers;
    }

    private static String buildPageUri(final String baseUri, final int page, final int size) {

        return UriComponentsBuilder.fromUriString(baseUri)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();
    }
}
