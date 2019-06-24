package com.zotlan.happyhappy.controller;

import java.util.ArrayList;
import java.util.List;

import com.zotlan.happyhappy.domain.Month;
import com.zotlan.happyhappy.service.RecordStatisticsService;

public class RecordStatisticsController {

    private RecordStatisticsService recordStatisticsService;

    public RecordStatisticsController(final RecordStatisticsService recordStatisticsService) {
        this.recordStatisticsService = recordStatisticsService;
    }

    public String getAllTimeAverage() {
        return recordStatisticsService.allTimeAverageFormatted();
    }

    public String getAllTimeTotal() {
        return recordStatisticsService.allTimeTotalFormatted();
    }

    public String getThisMonthAverage() {
        return recordStatisticsService.averageOfCurrentMonthFormatted();
    }

    public String getThisMonthTotal() {
        return recordStatisticsService.currentMonthTotalFormatted();
    }

    public String getToday() {
        return recordStatisticsService.currentDayTotalFormatted();
    }

    public String getMonthOfYearAverage(String year, Month month) {
        if (year != null || month != null) {
            return recordStatisticsService.monthOfYearAverage(Integer.valueOf(year), month);
        } else {
            return "0";
        }
    }

    public int getMonthOfYearAverageInSec(String year, Month month) {
        if (year != null || month != null) {
            return (int) recordStatisticsService.monthOfYearAverageInSec(Integer.valueOf(year), month);
        } else {
            return 0;
        }

    }

    public String getMonthOfYearTotal(String year, Month month) {
        if (year != null || month != null) {
            return recordStatisticsService.monthOfYearTotal(Integer.valueOf(year), month);
        } else {
            return "0";
        }

    }

    public int getAllTimeAverageInSeconds() {
        return (int) recordStatisticsService.allTimeAverageInSeconds();
    }

    public int getThisMonthAverageInSeconds() {
        return (int) recordStatisticsService.averageOfCurrentMonthInSeconds();
    }

    public int getTodaySeconds() {
        return (int) recordStatisticsService.currentDayTotalInSeconds();
    }

    public List<String> getRecordedYears() {
        return recordStatisticsService.getRecordedYears();
    }

    public List<Month> getRecordedMonths(int year) {
        return recordStatisticsService.getRecordedMonthsOfYear(year);
    }

    public Month getLatestMonth() {
        return recordStatisticsService.getLatestMonth();
    }

    public String getLatestYear() {
        return recordStatisticsService.getLatestYear();
    }

    public List<Month> getRecordedMonths(String year) {
        if (year != null) {
            return recordStatisticsService.getRecordedMonthsOfYear(Integer.valueOf(year));
        } else {
            return new ArrayList<>();
        }
    }

}
