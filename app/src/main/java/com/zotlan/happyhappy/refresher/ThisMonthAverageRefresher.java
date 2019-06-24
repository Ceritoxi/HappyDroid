package com.zotlan.happyhappy.refresher;

import com.zotlan.happyhappy.controller.RecordStatisticsController;

public class ThisMonthAverageRefresher implements Refresher{

    private RecordStatisticsController recordStatisticsController;

    public ThisMonthAverageRefresher(final RecordStatisticsController recordStatisticsController) {
        this.recordStatisticsController = recordStatisticsController;
    }

    @Override public String labelRefresh() {
        return recordStatisticsController.getThisMonthAverage();
    }

    @Override public int progressRefresh() {
        return recordStatisticsController.getThisMonthAverageInSeconds();
    }

}
