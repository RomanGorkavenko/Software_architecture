package ru.gb.software_architecture.homework.sem3.car.enums;

public enum CleanType {

    Mirrors("Зеркала"),
    Windshield("Лобовое стекло"),
    Headlights("Фары"),
    Body("Кузов"),
    Interior("Салон"),
    Engine("Двигатель"),
    Trunk("Багажник"),
    All("Всю машину");

    private final String title;

    CleanType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
