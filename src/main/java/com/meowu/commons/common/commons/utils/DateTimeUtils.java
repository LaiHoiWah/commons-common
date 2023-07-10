package com.meowu.commons.common.commons.utils;

import com.meowu.commons.common.commons.security.exception.FieldNotSupportException;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils{

    private static final String FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String format(Date date){
        return format(date, FULL_TIME_PATTERN);
    }

    public static String format(Date date, String pattern){
        AssertUtils.isNotNull(date, "Date must not be null");
        AssertUtils.isNotBlank(pattern, "Format pattern must not be null");

        return new LocalDateTime(date).toString(pattern);
    }

    public static Date parse(String date, String pattern){
        AssertUtils.isNotBlank(date, "Date string must not be null");
        AssertUtils.isNotBlank(pattern, "Format pattern must not be null");

        return LocalDateTime.parse(date, DateTimeFormat.forPattern(pattern)).toDate();
    }

    public static Date toDate(Date date, String timeZone){
        AssertUtils.isNotNull(date, "Date must not be null");
        AssertUtils.isNotBlank(timeZone, "Time zone name must not be null");

        return new LocalDateTime(date).toDate(TimeZone.getTimeZone(timeZone));
    }

    public static Date toDate(Date date, String locale, String to){
        AssertUtils.isNotNull(date, "Date must not be null");
        AssertUtils.isNotBlank(locale, "Local time zone name must not be null");
        AssertUtils.isNotBlank(to, "To time zone name must not be null");

        return new LocalDateTime(date, DateTimeZone.forID(locale)).toDate(TimeZone.getTimeZone(to));
    }

    public static TimeZone localTimeZone(){
        return DateTimeZone.getDefault().toTimeZone();
    }

    public static String localTimeZoneID(){
        return localTimeZone().getID();
    }

    public static Date plus(Date date, DateTimeField field, int amount){
        AssertUtils.isNotNull(date, "Date must not be null");
        AssertUtils.isNotNull(field, "Date field must not be null");

        // convert datetime
        LocalDateTime dateTime = new LocalDateTime(date);

        switch(field){
            case MILLI:
                return dateTime.plusMillis(amount).toDate();
            case SECOND:
                return dateTime.plusSeconds(amount).toDate();
            case MINUTE:
                return dateTime.plusMinutes(amount).toDate();
            case HOURS:
                return dateTime.plusHours(amount).toDate();
            case DAY:
                return dateTime.plusDays(amount).toDate();
            case WEEK:
                return dateTime.plusWeeks(amount).toDate();
            case MONTH:
                return dateTime.plusMonths(amount).toDate();
            case YEAR:
                return dateTime.plusYears(amount).toDate();
            default:
                throw new FieldNotSupportException("Field[{0}] is not support", field);
        }
    }

    public static Date plusMillis(Date date, int amount){
        return plus(date, DateTimeField.MILLI, amount);
    }

    public static Date plusSeconds(Date date, int amount){
        return plus(date, DateTimeField.SECOND, amount);
    }

    public static Date plusMinutes(Date date, int amount){
        return plus(date, DateTimeField.MINUTE, amount);
    }

    public static Date plusHours(Date date, int amount){
        return plus(date, DateTimeField.HOURS, amount);
    }

    public static Date plusDays(Date date, int amount){
        return plus(date, DateTimeField.DAY, amount);
    }

    public static Date plusWeeks(Date date, int amount){
        return plus(date, DateTimeField.WEEK, amount);
    }

    public static Date plusMonths(Date date, int amount){
        return plus(date, DateTimeField.MONTH, amount);
    }

    public static Date plusYears(Date date, int amount){
        return plus(date, DateTimeField.YEAR, amount);
    }

    public enum DateTimeField{

        MILLI,

        SECOND,

        MINUTE,

        HOURS,

        DAY,

        WEEK,

        MONTH,

        YEAR,

        ;
    }
}
