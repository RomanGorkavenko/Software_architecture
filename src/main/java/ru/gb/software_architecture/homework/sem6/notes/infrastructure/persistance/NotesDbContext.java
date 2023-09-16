package ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance;

import ru.gb.software_architecture.homework.sem6.database.NotesDatabase;
import ru.gb.software_architecture.homework.sem6.database.NotesRecord;
import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;
import ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    /**
     * Получение заметок из базы. В виде класса {@link Note}.
     * @return коллекцию типа {@link Note}.
     */
    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            Note note = new Note(record.getTitle(), record.getDetails());
            note.setId(record.getId());
            note.setCreationDate(record.getCreationDate());
            note.setEditDate(record.getEditDate());
            notesList.add(note);
        }
        return notesList;
    }

    /**
     * Добавление заметки в базу в виде класса {@link NotesRecord}
     * @param note {@link Note}
     */
    @Override
    public void add(Note note) {
        NotesRecord notesRecord = new NotesRecord(note.getTitle(), note.getDetails());
        ((NotesDatabase)database).getNotesTable().getRecords().add(notesRecord);
    }

    /**
     * Удаление заметки из базы.
     * @param note {@link Note}
     */
    @Override
    public void remove(Note note) {
        NotesRecord notesRecord = ((NotesDatabase)database).getNotesTable().getRecords()
                .stream()
                .filter(n -> n.getId() == note.getId())
                .toList()
                .get(0);
        ((NotesDatabase)database).getNotesTable().getRecords().remove(notesRecord);
    }

    /**
     * Обновление заметки в базе.
     * @param note {@link Note}
     */
    @Override
    public void update(Note note) {
        NotesRecord notesRecord = new NotesRecord(note.getTitle(), note.getDetails());
        notesRecord.setId(note.getId());
        notesRecord.setEditDate(note.getEditDate());
        notesRecord.setCreationDate(note.getCreationDate());
        ((NotesDatabase)database).getNotesTable().getRecords().add(notesRecord);
    }


    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
