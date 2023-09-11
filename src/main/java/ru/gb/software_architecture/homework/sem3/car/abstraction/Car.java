package ru.gb.software_architecture.homework.sem3.car.abstraction;

import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.*;
import ru.gb.software_architecture.homework.sem3.car.enums.CarType;
import ru.gb.software_architecture.homework.sem3.car.enums.CleanType;
import ru.gb.software_architecture.homework.sem3.car.enums.FuelType;
import ru.gb.software_architecture.homework.sem3.car.enums.GearboxType;

import java.awt.*;

/**
 * Базовый класс машины.
 * Вынес методы управления(взаимодействия) с машиной в отдельный интерфейс {@link ICarCapabilities}
 * Чтобы не смешивать уровень реализацию и абстракции.
 * Также реализовал интерфейсы {@link Fueling}, {@link CarCleaning}
 * в базовом классе, чтобы не дублировать код и для удобства реализации своего решения.
 */
public abstract class Car implements Fueling, CarCleaning, ICarCapabilities {

    //region Constructors

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Public Methods


    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public boolean switchFogLights(){
        fogLights = !fogLights;
        return fogLights;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    /**
     * Почистить автомобиль
     */
    @Override
    public void clean() {
        if (cleaning != null) {

            cleaning.clean(cleanType);
        } else {
            throw new NullPointerException("");
        }
    }

    //endregion

    //region Private Fields

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    protected CleanType[] cleanType;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    private Refueling refueling;

    private Cleaning cleaning;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;


    //endregion

    //region Setter and Getter


    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    public void setClean(Cleaning cleaning) {
        this.cleaning = cleaning;
    }

    public CleanType[] getCleanType() {
        return cleanType;
    }

    public void setCleanType(CleanType... cleanType) {
        this.cleanType = cleanType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean isFogLights() {
        return fogLights;
    }

    public void setFogLights(boolean fogLights) {
        this.fogLights = fogLights;
    }

    protected void setWheelsCount(int wheelsCount){
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    //endregion



}
