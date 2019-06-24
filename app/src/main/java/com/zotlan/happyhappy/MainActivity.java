package com.zotlan.happyhappy;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.zotlan.happyhappy.controller.RecordInsertionController;
import com.zotlan.happyhappy.controller.RecordStatisticsController;
import com.zotlan.happyhappy.dal.RecordDao;
import com.zotlan.happyhappy.dal.RecordsFileReader;
import com.zotlan.happyhappy.dal.RecordsFileWriter;
import com.zotlan.happyhappy.domain.Month;
import com.zotlan.happyhappy.format.TimeFormatter;
import com.zotlan.happyhappy.format.TimeFormatterUtil;
import com.zotlan.happyhappy.service.RecordInsertionService;
import com.zotlan.happyhappy.service.RecordStatisticsCalculationUtility;
import com.zotlan.happyhappy.service.RecordStatisticsService;
import com.zotlan.happyhappy.supplier.CalendarSupplier;
import com.zotlan.happyhappy.transform.RecordTransformer;
import com.zotlan.happyhappy.validation.RecordValidator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MainActivity mainActivity = this;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        final Context context = getApplicationContext();

        final CalendarSupplier dateSupplier = new CalendarSupplier();
        final RecordsFileReader recordsFileReader = new RecordsFileReader(context);
        final RecordsFileWriter recordsFileWriter = new RecordsFileWriter(context);
        final RecordValidator recordValidator = new RecordValidator();
        final RecordTransformer recordTransformer = new RecordTransformer(recordValidator);
        final RecordDao recordDao = new RecordDao(recordsFileReader, recordsFileWriter, recordValidator, recordTransformer, dateSupplier);
        final TimeFormatterUtil timeFormatterUtil = new TimeFormatterUtil();
        final TimeFormatter timeFormatter = new TimeFormatter(timeFormatterUtil);
        final RecordStatisticsCalculationUtility recordStatisticsCalculationUtility = new RecordStatisticsCalculationUtility(dateSupplier);
        final RecordStatisticsService recordStatisticsService = new RecordStatisticsService(recordDao, timeFormatter, recordStatisticsCalculationUtility);
        final RecordInsertionService recordInsertionService = new RecordInsertionService(recordDao);
        final RecordInsertionController recordInsertionController = new RecordInsertionController(recordInsertionService);
        final RecordStatisticsController recordStatisticsController = new RecordStatisticsController(recordStatisticsService);

        final Button logButton = findViewById(R.id.logButton);


        final ProgressBar monthTotalBar = findViewById(R.id.monthTotalBar);
        final ProgressBar allTimeTotalBar = findViewById(R.id.allTimeTotalBar);
        final ProgressBar allTimeAvgBar = findViewById(R.id.allTimeAvgBar);
        monthTotalBar.setMax(1);
        allTimeTotalBar.setMax(1);
        allTimeAvgBar.setMax(1);
        monthTotalBar.setProgress(1);
        allTimeTotalBar.setProgress(1);
        allTimeAvgBar.setProgress(1);

        setUpLogButtonActionListener(recordInsertionController, logButton);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final Spinner yearSpinner = findViewById(R.id.yearSpinner);
                final Spinner monthSpinner = findViewById(R.id.monthSpinner);

                refreshYearSpinner(yearSpinner);
                refreshMonthSpinner(yearSpinner, monthSpinner);
                refreshViews((String) yearSpinner.getSelectedItem(), (Month) monthSpinner.getSelectedItem());
                refreshProgressBars(Integer.valueOf((String) yearSpinner.getSelectedItem()), (Month) monthSpinner.getSelectedItem());

                handler.postDelayed(this, 200);
            }

            private void refreshYearSpinner(Spinner yearSpinner) {
                List<String> years = recordStatisticsController.getRecordedYears();
                ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(mainActivity, R.layout.support_simple_spinner_dropdown_item, years);
                yearAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                if (!yearAdapter.equals(yearSpinner.getAdapter())) {
                    yearSpinner.setAdapter(yearAdapter);
                }
            }

            private void refreshMonthSpinner(Spinner yearSpinner, Spinner monthSpinner) {
                List<Month> months = recordStatisticsController.getRecordedMonths((String) yearSpinner.getSelectedItem());
                ArrayAdapter<Month> monthAdapter = new ArrayAdapter<>(mainActivity, R.layout.support_simple_spinner_dropdown_item, months);
                monthAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                if (!monthAdapter.equals(monthSpinner.getAdapter())) {
                    monthSpinner.setAdapter(monthAdapter);
                }
            }

            private void refreshViews(String year, Month month) {
                final TextView todayView = findViewById(R.id.todayView);
                final TextView monthTotalView = findViewById(R.id.monthTotalView);
                final TextView monthAvgView = findViewById(R.id.monthAvgView);
                final TextView allTimeTotalView = findViewById(R.id.allTimeTotalView);
                final TextView allTimeAvgView = findViewById(R.id.allTimeAvgView);

                todayView.setText(recordStatisticsController.getToday());
                monthTotalView.setText(recordStatisticsController.getMonthOfYearTotal(year, month));
                monthAvgView.setText(recordStatisticsController.getMonthOfYearAverage(year, month));
                allTimeTotalView.setText(recordStatisticsController.getAllTimeTotal());
                allTimeAvgView.setText(recordStatisticsController.getAllTimeAverage());
            }

            private void refreshProgressBars(int year, Month month) {
                final ProgressBar todayBar = findViewById(R.id.todayBar);
                final ProgressBar monthAvgBar = findViewById(R.id.monthAvgBar);
                todayBar.setProgress(Long.valueOf(recordStatisticsService.currentDayTotalInSeconds()).intValue());
                monthAvgBar.setProgress(Long.valueOf(recordStatisticsService.monthOfYearAverageInSec(year, month)).intValue());
            }
        };
        handler.post(runnable);
    }

    private void setUpLogButtonActionListener(final RecordInsertionController recordInsertionController, Button logButton) {
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordInsertionController.logADay();
            }
        });
    }
}
