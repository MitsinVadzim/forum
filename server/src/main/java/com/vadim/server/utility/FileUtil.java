package com.vadim.server.utility;

import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@UtilityClass
public class FileUtil {

    public String generateUniqueName(final MultipartFile file) {
        return UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
    }

}
