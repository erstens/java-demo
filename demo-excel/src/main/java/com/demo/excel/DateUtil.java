package com.demo.excel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String formatNow() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now().plusDays(-1));
    }
}
