package com.zotlan.happyhappy.supplier;

import java.util.Calendar;

import com.zotlan.happyhappy.domain.Month;

public class CalendarSupplier {

    public Calendar get() {
        return Calendar.getInstance();
    }

    public Month getCurrentMonth() {
        return Month.values()[get().get(Calendar.MONTH)];
    }

    public int getCurrentYear() {
        return get().get(Calendar.YEAR);
    }

    public int getCurrentDay() {
        return get().get(Calendar.DAY_OF_MONTH);
    }
}
