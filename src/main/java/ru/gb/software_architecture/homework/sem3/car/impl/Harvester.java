package ru.gb.software_architecture.homework.sem3.car.impl;

import ru.gb.software_architecture.homework.sem3.car.abstraction.Car;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.CarCleaning;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Fueling;

import java.awt.*;

public class Harvester extends Car implements Fueling, CarCleaning {

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }

}
