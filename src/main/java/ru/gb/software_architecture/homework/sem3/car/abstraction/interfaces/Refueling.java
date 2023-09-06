package ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces;

import ru.gb.software_architecture.homework.sem3.car.enums.FuelType;

/**
 * Заправочная станция
 */
public interface Refueling {

    /**
     * Заправка
     */
    void fuel(FuelType fuelType);

}
