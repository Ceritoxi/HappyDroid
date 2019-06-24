package com.zotlan.happyhappy.refresher;

import com.zotlan.happyhappy.controller.RecordStatisticsController;

public class ThisMonthTotalRefresher  implements Refresher{

    private static final int FULL = 1;
    private RecordStatisticsController recordStatisticsController;

    public ThisMonthTotalRefresher(final RecordStatisticsController recordStatisticsController) {
        this.recordStatisticsController = recordStatisticsController;
    }

    @Override public String labelRefresh() {
        return recordStatisticsController.getThisMonthTotal();
    }

    @Override public int progressRefresh() {
        return FULL;
    }

}
