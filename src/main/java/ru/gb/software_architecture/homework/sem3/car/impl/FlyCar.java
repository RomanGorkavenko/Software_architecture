package ru.gb.software_architecture.homework.sem3.car.impl;

import ru.gb.software_architecture.homework.sem3.car.abstraction.Car;

import java.awt.*;

public class FlyCar extends Car {
    public FlyCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
    }

    public void fly(){
        System.out.println("Автомобиль летит!");
    }

    @Override
    public void movement() {
        fly();
    }
}
