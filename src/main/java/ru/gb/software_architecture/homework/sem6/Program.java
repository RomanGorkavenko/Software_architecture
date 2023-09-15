package ru.gb.software_architecture.homework.sem6;

import ru.gb.software_architecture.homework.sem6.database.NotesDatabase;
import ru.gb.software_architecture.homework.sem6.notes.core.application.ConcreteNoteEditor;
import ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance.NotesDbContext;
import ru.gb.software_architecture.homework.sem6.notes.presentation.queries.controllers.NotesController;
import ru.gb.software_architecture.homework.sem6.notes.presentation.queries.views.NotesConsolePresenter;

public class Program {

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));
        controller.routeGetAll();
    }

}
