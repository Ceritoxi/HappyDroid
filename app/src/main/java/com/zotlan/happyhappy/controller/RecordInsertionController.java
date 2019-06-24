package com.zotlan.happyhappy.controller;

import com.zotlan.happyhappy.service.RecordInsertionService;

public class RecordInsertionController {

    private RecordInsertionService recordInsertionService;

    public RecordInsertionController(final RecordInsertionService recordInsertionService) {
        this.recordInsertionService = recordInsertionService;
    }

    public void logADay() {
        recordInsertionService.addCurrentTimestamp();
    }
}
