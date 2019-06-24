package com.zotlan.happyhappy.refresher;

import com.zotlan.happyhappy.controller.RecordStatisticsController;
import com.zotlan.happyhappy.domain.Month;

public class MonthTotalRefresher implements Refresher{

    private static final int FULL = 1;

    private RecordStatisticsController recordStatisticsController;
    private Month month;
    private String year;

    public MonthTotalRefresher(RecordStatisticsController recordStatisticsController, Month month, String year) {
        this.recordStatisticsController = recordStatisticsController;
        this.month = month;
        this.year = year;
    }

    @Override
    public String labelRefresh() {
        return recordStatisticsController.getMonthOfYearTotal(year, month);
    }

    @Override
    public int progressRefresh() {
        return FULL;
    }
}
