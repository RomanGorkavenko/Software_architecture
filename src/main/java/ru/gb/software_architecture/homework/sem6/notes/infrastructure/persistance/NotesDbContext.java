package ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance;

import ru.gb.software_architecture.homework.sem6.database.NotesDatabase;
import ru.gb.software_architecture.homework.sem6.database.NotesRecord;
import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;
import ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {


    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
