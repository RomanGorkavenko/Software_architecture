package ru.gb.software_architecture.homework.sem6.database;

import ru.gb.software_architecture.homework.sem6.Program;
import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;
import ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance.Database;

/**
 * Так ка на каждый запрос из {@link Program} (внешнего слоя),
 * создается отдельный контроллер который создает новый экземпляр БД, а БД у нас одна.
 * Решил использовать Singleton для {@link NotesDatabase} и {@link NotesTable}.
 * Чтобы запросы в рамках {@link Note} были к одной сущности.
 */
public class NotesDatabase implements Database {

    private NotesTable notesTable;

    private static NotesDatabase INSTANCE;

    public static NotesDatabase getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new NotesDatabase();
        }
        return INSTANCE;
    }

    private NotesDatabase() {
    }

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = NotesTable.getINSTANCE();
        return notesTable;
    }
}
