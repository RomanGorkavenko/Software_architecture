package ru.gb.software_architecture.homework.sem5.data;

import ru.gb.software_architecture.homework.sem5.data.entity.Entity;

/**
 * Текстура
 */
public class Texture implements Entity {

    private static int counter = 50000;

    private int id;

    {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}
