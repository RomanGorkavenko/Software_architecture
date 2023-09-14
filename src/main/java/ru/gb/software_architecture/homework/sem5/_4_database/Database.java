package ru.gb.software_architecture.homework.sem5._4_database;

import ru.gb.software_architecture.homework.sem5.data.entity.Entity;

import java.util.Collection;

/**
 * Интерфейс БД
 */
public interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}
