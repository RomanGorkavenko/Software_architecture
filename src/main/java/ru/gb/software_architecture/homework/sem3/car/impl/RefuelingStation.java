package ru.gb.software_architecture.homework.sem3.car.impl;


import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Refueling;
import ru.gb.software_architecture.homework.sem3.car.enums.FuelType;

public class RefuelingStation implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

}
