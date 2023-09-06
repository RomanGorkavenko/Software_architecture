package ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces;

public interface Washing {

    void washBody(String cleanTitle);
    void washInterior(String cleanTitle);
    void washEngine(String cleanTitle);
    void washTrunk(String cleanTitle);
    void washAll(String cleanTitle);

}
