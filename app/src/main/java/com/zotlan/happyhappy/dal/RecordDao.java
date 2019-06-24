package com.zotlan.happyhappy.dal;

import java.util.ArrayList;
import java.util.List;

import com.zotlan.happyhappy.domain.Month;
import com.zotlan.happyhappy.domain.Record;
import com.zotlan.happyhappy.domain.State;
import com.zotlan.happyhappy.exception.InvalidRecordException;
import com.zotlan.happyhappy.supplier.CalendarSupplier;
import com.zotlan.happyhappy.transform.RecordTransformer;
import com.zotlan.happyhappy.validation.RecordValidator;

public class RecordDao {

    private RecordsFileReader recordsFileReader;
    private RecordsFileWriter recordsFileWriter;
    private RecordValidator recordValidator;
    private RecordTransformer recordTransformer;
    private CalendarSupplier dateSupplier;
    private List<Record> recordCache;
    private boolean recordCacheIsValid;

    public RecordDao(final RecordsFileReader recordsFileReader, final RecordsFileWriter recordsFileWriter, final RecordValidator recordValidator,
        final RecordTransformer recordTransformer, final CalendarSupplier dateSupplier) {
        this.recordsFileReader = recordsFileReader;
        this.recordsFileWriter = recordsFileWriter;
        this.recordValidator = recordValidator;
        this.recordTransformer = recordTransformer;
        this.dateSupplier = dateSupplier;
        this.recordCache = new ArrayList<>();
        this.recordCacheIsValid = false;
    }

    public void addRecordOfCurrentDate() {
        addRecord(new Record(dateSupplier.get(), nextState()));
    }

    private State nextState() {
        if (lastRecordedState().equals(State.END)) {
            return State.START;
        } else {
            return State.END;
        }
    }

    /**
     * Adds a new record to the database.
     *
     * @param record
     */
    public void addRecord(final Record record) {
        if (record.getState().equals(nextState())) {
            recordsFileWriter.addRecord(recordTransformer.convertToRawRecord(record));
            recordCacheIsValid = false;
        } else {
            throw new InvalidRecordException("Record is invalid, previous status is the same as this one");
        }
    }

    /**
     * Adds a raw record to the database.
     * Invalid records cause an {@link InvalidRecordException} to occur.
     *
     * @param rawRecord
     */
    private void addRecord(final String rawRecord) {
        if (recordValidator.isValid(rawRecord)) {
            recordsFileWriter.addRecord(rawRecord);
            recordCacheIsValid = false;
        } else {
            throw new InvalidRecordException("Record is invalid, can't write it");
        }
    }

    /**
     * Get all the records from the database.
     * Records are cached, so consequent calling of the method will likely not cause performance issues.
     *
     * @return every {@link Record} stored in the database.
     */
    public List<Record> getRecords() {
        if (recordCacheIsValid) {
            return recordCache;
        } else {
            recordCache = recordTransformer.convertToRecords(recordsFileReader.readInRecords());
            recordCacheIsValid = true;
            return recordCache;
        }
    }

    public List<Record> getRecordsForMonth(final Month month) {
        List<Record> result = new ArrayList<>();
        for (Record record : getRecords()) {
            if (record.getMonth().equals(month)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<Record> getRecordsForYear(final int year) {
        List<Record> result = new ArrayList<>();
        for (Record record : getRecords()) {
            if (record.getYear() == year) {
                result.add(record);
            }
        }
        return result;
    }

    public List<Record> getRecordsForMonthInYear(final int year, final Month month) {
        List<Record> result = new ArrayList<>();
        for (Record record : getRecords()) {
            if (record.getYear() == year && record.getMonth().equals(month)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<Record> getRecordsForCurrentMonth() {
        List<Record> result = new ArrayList<>();
        for (Record record : getRecords()) {
            if (record.getYear() == dateSupplier.getCurrentYear() && record.getMonth().equals(dateSupplier.getCurrentMonth())) {
                result.add(record);
            }
        }
        return result;
    }

    public List<Record> getRecordsForCurrentDay() {
        List<Record> result = new ArrayList<>();
        for (Record record : getRecords()) {
            if (record.getYear() == dateSupplier.getCurrentYear() &&
                record.getMonth().equals(dateSupplier.getCurrentMonth()) &&
                record.getDay() == dateSupplier.getCurrentDay()) {
                result.add(record);
            }
        }
        return result;
    }

    private State lastRecordedState() {
        if (getRecords().isEmpty()) {
            return State.END;
        } else {
            return getRecords().get(getRecords().size() - 1).getState();
        }
    }

}
