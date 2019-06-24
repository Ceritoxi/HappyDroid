package com.zotlan.happyhappy.dal;

import android.content.Context;

import java.io.IOException;
import java.io.OutputStreamWriter;


public class RecordsFileWriter {

    private final Context context;

    public RecordsFileWriter(Context context) {
        this.context = context;
    }

    /**
     * Appends a raw record to the default datafile.
     * Validity check is not enforced here.
     * @param record
     */
    void addRecord(final String record) {
        try {
            doAddRecord(record);
        } catch (IOException e) {
            System.err.println("Can't write the file for some reason");
        }
    }

    private void doAddRecord(final String record) throws IOException {
        final OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput("datafile",Context.MODE_APPEND));
        writer.append(record).append("\n");
        writer.flush();
        writer.close();
    }
}
