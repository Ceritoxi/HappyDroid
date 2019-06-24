package com.zotlan.happyhappy.transform;

import com.zotlan.happyhappy.domain.Record;
import com.zotlan.happyhappy.domain.State;
import com.zotlan.happyhappy.validation.RecordValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordTransformer {

    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int DAY_INDEX = 2;
    private static final int HOUR_INDEX = 3;
    private static final int MINUTE_INDEX = 4;
    private static final int SECOND_INDEX = 5;
    private static final int STATE_INDEX = 6;

    private RecordValidator recordValidator;

    public RecordTransformer(final RecordValidator recordValidator) {
        this.recordValidator = recordValidator;
    }

    public List<Record> convertToRecords(final List<String> rawRecords) {
        List<Record> mappedResult = new ArrayList<>();
        for (String rawRecord : rawRecords) {
            if (recordValidator.isValid(rawRecord)) {
                mappedResult.add(convertToRecord(rawRecord));
            }
        }
        return mappedResult;
    }

    private Record convertToRecord(final String rawRecord) {
        final Record result = new Record();
        final String[] recordPieces = rawRecord.split(" ");
        result.setDate(Integer.parseInt(recordPieces[YEAR_INDEX]), Integer.parseInt(recordPieces[MONTH_INDEX]) - 1, Integer.parseInt(recordPieces[DAY_INDEX]),
                Integer.parseInt(recordPieces[HOUR_INDEX]), Integer.parseInt(recordPieces[MINUTE_INDEX]), Integer.parseInt(recordPieces[SECOND_INDEX]));
        result.setState(State.valueOf(recordPieces[STATE_INDEX]));
        return result;
    }

    public String convertToRawRecord(final Record record) {
        return record.getYear() + " "
            + record.getMonthValue() + " "
            + record.getDay() + " "
            + record.getHour() + " "
            + record.getMinute() + " "
            + record.getSecond() + " "
            + record.getState();
    }
}
