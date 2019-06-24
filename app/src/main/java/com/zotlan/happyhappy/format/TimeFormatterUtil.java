package com.zotlan.happyhappy.format;

public class TimeFormatterUtil {

    private static final int DAYS_REMAINDER = 365;
    private static final int HOURS_REMAINDER = 24;
    private static final int MINUTES_REMAINDER = 60;
    private static final int SECOND_REMAINDER = 60;

    private static final int YEARS = 365;
    private static final int DAYS = 24;
    private static final int HOURS = 60;
    private static final int MINUTES = 60;

    private static final int TWO_DIGITS = 10;
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public boolean isAtLeastAYear(final long seconds) {
        return years(seconds) > 0;
    }

    public boolean isAtLeastOneDay(final long seconds) {
        return days(seconds) > ZERO;
    }

    public boolean isMoreThanOneYear(final long seconds) {
        return years(seconds) > ONE;
    }

    public boolean isMoreThanOneDay(final long seconds) {
        return days(seconds) > ONE;
    }

    public boolean isLessThanTwoHoursDigits(final long seconds) {
        return shownHours(seconds) < TWO_DIGITS;
    }

    public boolean isLessThanTwoMinuteDigits(final long seconds) {
        return shownMinutes(seconds) < TWO_DIGITS;
    }

    public boolean isLessThanTwoSecondDigits(final long seconds) {
        return shownSeconds(seconds) < TWO_DIGITS;
    }

    public long years(final long seconds) {
        return seconds / MINUTES / HOURS / DAYS / YEARS;
    }

    public long days(final long seconds) {
        return seconds / MINUTES / HOURS / DAYS;
    }

    public long shownDays(final long seconds) {
        return days(seconds) % DAYS_REMAINDER;
    }

    public long shownHours(final long seconds) {
        return seconds / MINUTES / HOURS % HOURS_REMAINDER;
    }

    public long shownMinutes(final long seconds) {
        return seconds / MINUTES % MINUTES_REMAINDER;
    }

    public long shownSeconds(final long seconds) {
        return seconds % SECOND_REMAINDER;
    }
}
