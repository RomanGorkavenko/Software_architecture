package ru.gb.software_architecture.homework.sem3.car.impl;

import ru.gb.software_architecture.homework.sem3.car.abstraction.Car;

import java.awt.*;

public class SoprtCar extends Car {
    public SoprtCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(3);
    }
}
