package ru.gb.software_architecture.homework.sem6.notes.presentation.queries.controllers;

import ru.gb.software_architecture.homework.sem6.Program;
import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NoteEditor;
import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    /**
     * Добавление заметки.
     * Если я правильно понял, {@link NotesController} ничего не знает о нашей заметке {@link Note}
     * и в классе {@link Program} мы не можем ее создать, поэтому и передать ее сюда не можем.
     * Но мы можем при создании новой заметки, указать ее название и содержимое.
     * Также перед тем как добавить заметку мы ее создаем.
     * @param title название новой заметки.
     * @param details ее содержимое.
     */
    public void routeCreateNote(String title, String details){
        this.notesEditor.add(this.notesEditor.create(title, details));
    }

    /**
     * Обновление заметки.
     * При обновлении заметки мы указываем ее id и новый заголовок, новое содержимое.
     * @param id идентификатор заметки которую хотим обновить.
     * @param newTitle новое название заметки.
     * @param newDetails новое содержимое заметки.
     */
    public void routeUpdate(int id, String newTitle, String newDetails) {
        this.notesEditor.update(id, newTitle, newDetails);
    }

    /**
     * Удаление заметки.
     * Получаем заметку с помощью {@link NoteEditor#getById(Object)},
     * Если заметки нет бросаем исключение {@link RuntimeException}
     * @param id идентификатор заметки которую хотим удалить.
     */
    public void routeRemoveNote(int id){
        this.notesEditor.remove(this.notesEditor.getById(id)
                .orElseThrow(() -> new RuntimeException("Заметка не найдена.")));
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

}
