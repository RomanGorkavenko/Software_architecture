package ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces;

import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    void add(Note note);

    void remove(Note note);

    void update(Note note);

    boolean saveChanges();

}
