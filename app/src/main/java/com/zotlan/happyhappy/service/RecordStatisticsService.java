package com.zotlan.happyhappy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zotlan.happyhappy.dal.RecordDao;
import com.zotlan.happyhappy.domain.Month;
import com.zotlan.happyhappy.domain.Record;
import com.zotlan.happyhappy.format.TimeFormatter;

public class RecordStatisticsService {

    private RecordDao recordDao;
    private TimeFormatter timeFormatter;
    private RecordStatisticsCalculationUtility recordStatisticsCalculationUtility;

    public RecordStatisticsService(final RecordDao recordDao, final TimeFormatter timeFormatter,
        final RecordStatisticsCalculationUtility recordStatisticsCalculationUtility) {
        this.recordDao = recordDao;
        this.timeFormatter = timeFormatter;
        this.recordStatisticsCalculationUtility = recordStatisticsCalculationUtility;
    }

    public String currentMonthTotalFormatted() {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecordsForCurrentMonth()));
    }

    public long currentMonthTotalInSeconds() {
        return recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecordsForCurrentMonth());
    }

    public String currentDayTotalFormatted() {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecordsForCurrentDay()));
    }

    public long currentDayTotalInSeconds() {
        return recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecordsForCurrentDay());
    }

    public String allTimeTotalFormatted() {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecords()));
    }

    public long allTimeTotalInSeconds() {
        return recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecords());
    }

    public String averageOfCurrentMonthFormatted() {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecordsForCurrentMonth()));
    }

    public long averageOfCurrentMonthInSeconds() {
        return recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecordsForCurrentMonth());
    }

    public String allTimeAverageFormatted() {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecords()));
    }

    public long allTimeAverageInSeconds() {
        return recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecords());
    }

    public List<String> getRecordedYears() {
        List<String> mappedDistinctResult = new ArrayList<>();
        for (Record record : recordDao.getRecords()) {
            if (!mappedDistinctResult.contains(record.getYear() + "")) {
                mappedDistinctResult.add(record.getYear() + "");
            }
        }
        return mappedDistinctResult;
    }

    public List<Month> getRecordedMonthsOfYear(int year) {
        List<Month> mappedResult = new ArrayList<>();
        for (Record record : recordDao.getRecords()) {
            if (record.getYear() == year) {
                if (!mappedResult.contains(record.getMonth())) {
                    mappedResult.add(record.getMonth());
                }
            }
        }
        Collections.sort(mappedResult);
        return mappedResult;
    }

    public String monthOfYearAverage(int year, Month month) {
        return timeFormatter
            .formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecordsForMonthInYear(year, month)));
    }

    public String monthOfYearTotal(int year, Month month) {
        return timeFormatter.formatTimeFromSeconds(recordStatisticsCalculationUtility.calculateTotalInSecond(recordDao.getRecordsForMonthInYear(year, month)));
    }

    public long monthOfYearAverageInSec(int year, Month month) {
        return recordStatisticsCalculationUtility.calculateAverageInSeconds(recordDao.getRecordsForMonthInYear(year, month));
    }

    public Month getLatestMonth() {
        return Collections.max(getRecordedMonthsOfYear(Integer.valueOf(getLatestYear())));
    }

    public String getLatestYear() {
        List<Integer> recordedYears = new ArrayList<>();
        for (String recordedYear : getRecordedYears()) {
            recordedYears.add(Integer.valueOf(recordedYear));
        }
        return Collections.max(recordedYears).toString();
    }
}
