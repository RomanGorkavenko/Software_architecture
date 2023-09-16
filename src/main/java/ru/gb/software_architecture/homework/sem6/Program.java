package ru.gb.software_architecture.homework.sem6;

import ru.gb.software_architecture.homework.sem6.database.NotesDatabase;
import ru.gb.software_architecture.homework.sem6.notes.core.application.ConcreteNoteEditor;
import ru.gb.software_architecture.homework.sem6.notes.infrastructure.persistance.NotesDbContext;
import ru.gb.software_architecture.homework.sem6.notes.presentation.queries.controllers.NotesController;
import ru.gb.software_architecture.homework.sem6.notes.presentation.queries.views.NotesConsolePresenter;

public class Program {

    public static void main(String[] args) {
        // Просмотр всех заметок
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller.routeGetAll();

        System.out.println();

        // Добавление новой заметки
        NotesController controller2 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller2.routeCreateNote("new", "test");

        NotesController controller3 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller3.routeGetAll();

        System.out.println();

        // Обновление заметки
        NotesController controller4 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller4.routeUpdate(1003, "Update Test", "Update Successfully");

        NotesController controller5 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller5.routeGetAll();

        System.out.println();

        // Удаление заметки
        NotesController controller6 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller6.routeRemoveNote(1003);

        NotesController controller7 = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(NotesDatabase.getINSTANCE()), new NotesConsolePresenter()));
        controller7.routeGetAll();

    }

}
