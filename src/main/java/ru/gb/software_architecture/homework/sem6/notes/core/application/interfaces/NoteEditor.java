package ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces;

import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

    boolean update(int id, String title, String details);
}
