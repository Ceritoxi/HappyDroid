package com.zotlan.happyhappy.service;

import com.zotlan.happyhappy.dal.RecordDao;

public class RecordInsertionService {

    private RecordDao recordDao;

    public RecordInsertionService(final RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public void addCurrentTimestamp() {
        recordDao.addRecordOfCurrentDate();
    }
}
