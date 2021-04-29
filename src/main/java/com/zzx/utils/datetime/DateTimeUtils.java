package com.zzx.utils.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期、时间工具类
 */
public class DateTimeUtils implements TimeFormatter {

    /**
     * 获取当前系统的时间戳
     *
     * @return 时间戳
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前日期（yyyy-MM-dd）
     *
     * @return 当前日期
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间（HH:mm:ss.SSS)
     *
     * @return 当前时间
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期时间（yyyy-MM-dd'T'HH:mm:ss）
     *
     * @return 当前日期时间
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前日期（yyyy-MM-dd）字符串
     *
     * @return 当前日期字符串
     */
    public static String getCurrentDateString() {
        return DateTimeFormatter.ofPattern(DATE_FORMATTER).format(getCurrentLocalDate());
    }

    /**
     * 获取当前时间（HH:mm:ss）字符串
     *
     * @return 当前日期字符串
     */
    public static String getCurrentLocalTimeString() {
        return DateTimeFormatter.ofPattern(TIME_FORMATTER).format(getCurrentLocalTime());
    }

    /**
     * 获取当前时间（HH:mm:ss.SSS）字符串
     *
     * @return 当前日期字符串
     */
    public static String getCurrentLocalTimeSssString() {
        return DateTimeFormatter.ofPattern(TIME_FORMATTER_SSS).format(getCurrentLocalTime());
    }

    /**
     * 获取当前日期时间（yyyy-MM-dd HH:mm:ss）字符串
     *
     * @return 当前日期时间字符串
     */
    public static String getCurrentLocalDateTimeString() {
        return DateTimeFormatter.ofPattern(DATETIME_FORMATTER).format(getCurrentLocalDateTime());
    }

    /**
     * 获取当前日期时间（yyyy-MM-dd'T'HH:mm:ss）字符串
     *
     * @return 当前日期时间字符串
     */
    public static String getCurrentLocalDateTimeTString() {
        return DateTimeFormatter.ofPattern(DATETIME_T_FORMATTER).format(getCurrentLocalDateTime());
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTimeMillis());
        System.out.println(getCurrentLocalDate());
        System.out.println(getCurrentLocalTime());
        System.out.println(getCurrentLocalDateTime());
        System.out.println(getCurrentDateString());
        System.out.println(getCurrentLocalTimeString());
        System.out.println(getCurrentLocalTimeSssString());
        System.out.println(getCurrentLocalDateTimeString());
        System.out.println(getCurrentLocalDateTimeTString());
    }
}
