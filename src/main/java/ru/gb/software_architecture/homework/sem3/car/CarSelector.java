package ru.gb.software_architecture.homework.sem3.car;

import ru.gb.software_architecture.homework.sem3.car.abstraction.Car;
import ru.gb.software_architecture.homework.sem3.car.enums.RoadType;
import ru.gb.software_architecture.homework.sem3.car.impl.Harvester;
import ru.gb.software_architecture.homework.sem3.car.impl.Jeep;
import ru.gb.software_architecture.homework.sem3.car.impl.SoprtCar;

import java.awt.*;

public class CarSelector {

    /**
     * Singleton
     */
    private static CarSelector INSTANCE;

    private CarSelector() {

    }

    public static CarSelector getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new CarSelector();
        }
        return INSTANCE;
    }

    /**
     * Factory method
     * @param roadType тип дороги
     * @return {@link Car} и наследников
     */
    public Car getCar(RoadType roadType) {

        return switch (roadType) {
            case CITY -> new SoprtCar("Порше", "Спорт", Color.BLUE);
            case OFF_ROAD -> new Jeep("Внедорожник", "Jeep", Color.DARK_GRAY);
            case CLEANING -> new Harvester("Уборочная машина", "B", Color.BLACK);
        };
    }

}
