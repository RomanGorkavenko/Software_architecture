package ru.gb.software_architecture.homework.sem6.notes.core.application.interfaces;


import java.util.Collection;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    T edit(T item, String title, String details);

    boolean remove(T item);

    T create(String title, String details);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}
