package com.zotlan.happyhappy.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecordValidator {

    public boolean isValid(final String record) {
        return record.matches("[0-9]{4} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} (START|END)");
    }

    public List<String> filterOutIllegalRecords(final List<String> records) {
        List<String> result = new ArrayList<>();
        for (String record : records) {
            if (this.isValid(record)) {
                result.add(record);
            }
        }
        return result;
    }
}
