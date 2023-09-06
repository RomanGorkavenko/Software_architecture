package ru.gb.software_architecture.homework.sem3.car.impl;

import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Cleaning;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Refueling;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Wiping;
import ru.gb.software_architecture.homework.sem3.car.enums.CleanType;
import ru.gb.software_architecture.homework.sem3.car.enums.FuelType;

public class RefuelingStationV2 implements Refueling, Cleaning, Wiping {

    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public void wipMirrors(String cleanTitle) {
        System.out.println("Протерли " + cleanTitle);
    }

    @Override
    public void wipWindshield(String cleanTitle) {
        System.out.println("Протерли " + cleanTitle);
    }

    @Override
    public void wipHeadlights(String cleanTitle) {
        System.out.println("Протерли " + cleanTitle);
    }

    /**
     * Реализация доп услуг по чистки авто на заправке.
     * С помощью {@link Cleaning} и {@link Wiping}
     *
     * @param cleanType что почистить
     */
    @Override
    public void clean(CleanType... cleanType) {
        for (CleanType type : cleanType) {
            switch (type) {
                case Mirrors -> wipMirrors(type.getTitle());
                case Headlights -> wipHeadlights(type.getTitle());
                case Windshield -> wipWindshield(type.getTitle());
                default -> System.out.println("Услуги протереть " + type.getTitle() + " нет.");
            }
        }
    }
}