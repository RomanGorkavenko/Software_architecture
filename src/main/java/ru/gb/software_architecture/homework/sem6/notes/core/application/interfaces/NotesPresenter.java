package ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces;

import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);
}
