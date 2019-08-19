package com.vadim.server.utility;

import com.vadim.server.exception.BadRequestException;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@UtilityClass
public class ImageUtils {

    private static final String[] contentTypes = {
            "image/png",
            "image/jpg",
            "image/jpeg",
            "image/bmp",
            "image/gif",
            "image/ief",
            "image/pipeg",
            "image/svg+xml",
            "image/tiff"
    };

    public boolean isValid(final MultipartFile value) {
        if (!isSupportedContentType(value.getContentType())) {
            throw new BadRequestException("Invalid image format");
        }
        return true;
    }

    private boolean isSupportedContentType(final String contentType) {
        return Arrays.stream(contentTypes)
                .anyMatch(type -> type.equals(contentType));
    }
}
