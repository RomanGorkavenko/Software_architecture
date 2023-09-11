package ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces;

public interface ICarCapabilities {

    // Движение
    void movement();
    // Обслуживание
    void maintenance();
    // Переключение передач
    boolean gearShifting();
    // Включение фар
    boolean switchHeadlights();
    // Включение дворников
    boolean switchWipers();

    // Подметать
    //public abstract void sweeping();

}
