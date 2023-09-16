package ru.gb.software_architecture.homework.sem6.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class NotesTable {

    private Random random = new Random();

    private Collection<NotesRecord> records;

    private static NotesTable INSTANCE;

    public static NotesTable getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new NotesTable();
        }
        return INSTANCE;
    }

    private NotesTable() {
    }

    public Collection<NotesRecord> getRecords() {
        if (records == null)
        {
            records = new ArrayList<>();
            int recordsCount =  5  + random.nextInt(10);
            for (int i = 0; i < recordsCount; i++){
                records.add(new NotesRecord("title #" + i, "details #" + i));
            }
        }
        return records;
    }


}
