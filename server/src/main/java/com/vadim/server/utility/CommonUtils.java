package com.vadim.server.utility;

public class CommonUtils {

    public static <T> String nullSafeToString(final T from) {
        return from == null ? "" : from.toString();

    }

}
