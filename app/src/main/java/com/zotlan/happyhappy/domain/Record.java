package com.zotlan.happyhappy.domain;

import java.util.Calendar;
import java.util.Objects;

public class Record {

    private Calendar date;
    private State state;
    private long epoch;

    public Record() {
    }

    public Record(final Calendar date, final State state) {
        this.date = date;
        this.state = state;
        this.epoch = date.getTimeInMillis() / 1000;
    }

    public void setDate(final Calendar date) {
        this.date = date;
        this.epoch = date.getTimeInMillis() / 1000;
    }

    public void setDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);
        setDate(calendar);
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public long getEpoch() {
        return epoch;
    }

    @Override public String toString() {
        return date + " " + state;
    }

    public boolean onSameDay(Record record) {
        return date.get(Calendar.YEAR) == record.date.get(Calendar.YEAR) &&
            date.get(Calendar.MONTH) == record.date.get(Calendar.MONTH) &&
            date.get(Calendar.DAY_OF_MONTH) == record.date.get(Calendar.DAY_OF_MONTH);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Record record = (Record) o;
        return epoch == record.epoch &&
            Objects.equals(date, record.date) &&
            state == record.state;
    }

    @Override public int hashCode() {
        return Objects.hash(date, state, epoch);
    }

    public Month getMonth() {
        return Month.values()[date.get(Calendar.MONTH)];
    }

    public int getMonthValue() {
        return date.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        return date.get(Calendar.YEAR);
    }

    public int getDay() {
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return date.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return date.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return date.get(Calendar.SECOND);
    }

}
