package com.kk.service.util;

import java.text.SimpleDateFormat;


public class ThreadLocalDateFormat {

    private static final ThreadLocal<SimpleDateFormat> localDateFormat =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS"));

    public static SimpleDateFormat current() {
        return localDateFormat.get();
    }
}
