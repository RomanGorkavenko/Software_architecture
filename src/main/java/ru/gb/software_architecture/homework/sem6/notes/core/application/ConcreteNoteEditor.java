package ru.gb.software_architecture.homework.sem6.notes.core.application;

import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NoteEditor;
import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces.NotesPresenter;
import ru.gb.software_architecture.homework.sem6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    /**
     * Добавление заметки.
     * Вызываем {@link NotesDatabaseContext#add(Note)} для добавления в БД
     * @param item новая заметка.
     * @return результат COMMIT transaction.
     */
    @Override
    public boolean add(Note item) {
        dbContext.add(item);
        return dbContext.saveChanges();
    }

    /**
     * Метод редактирования заметки.
     * @param item заметка которую нужно отредактировать.
     * @param title новое название заметки.
     * @param details новое содержимое заметки.
     * @return заметку с внесенными изменениями.
     */
    @Override
    public Note edit(Note item, String title, String details) {
        Note note = new Note(title, details);
        note.setId(item.getId());
        note.setCreationDate(note.getCreationDate());
        note.setEditDate(new Date());
        return note;
    }

    /**
     * Удаление заметки.
     * @param item заметка, которую хотим удалить.
     * @return результат COMMIT transaction.
     */
    @Override
    public boolean remove(Note item) {
        dbContext.remove(item);
        return dbContext.saveChanges();
    }

    /**
     * Создание заметки.
     * @param title название заметки.
     * @param details содержимое заметки.
     * @return новую заметку.
     */
    @Override
    public Note create(String title, String details) {
        return new Note(title, details);
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }

    /**
     * Обновление заметки.
     * Сначала находим заметку по id, если заметка не найдена,
     * бросаем исключение {@link RuntimeException}.
     * С помощью {@link NoteEditor#remove(Object)}.
     * Затем удаляем заметку из базы и добавляем обновленную.
     * @param id идентификатор заметки которую хотим обновить.
     * @param title название заметки.
     * @param details содержимое заметки.
     * @return результат COMMIT transaction.
     */
    @Override
    public boolean update(int id, String title, String details) {
        Note note = getById(id).orElseThrow(() -> new RuntimeException("Заметка не найдена."));
        remove(note);
        dbContext.update(edit(note, title, details));
        return dbContext.saveChanges();
    }


}
