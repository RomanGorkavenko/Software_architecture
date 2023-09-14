package ru.gb.software_architecture.homework.sem5;

import java.util.Collection;

/**
 * Интерфейс БД
 */
interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}
