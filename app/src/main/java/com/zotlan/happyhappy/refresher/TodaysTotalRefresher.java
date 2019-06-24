package com.zotlan.happyhappy.refresher;

import com.zotlan.happyhappy.controller.RecordStatisticsController;

public class TodaysTotalRefresher implements Refresher {

    private RecordStatisticsController recordStatisticsController;

    public TodaysTotalRefresher(final RecordStatisticsController recordStatisticsController) {
        this.recordStatisticsController = recordStatisticsController;
    }

    @Override
    public String labelRefresh() {
        return recordStatisticsController.getToday();
    }

    @Override
    public int progressRefresh() {
        return recordStatisticsController.getTodaySeconds();
    }

}
