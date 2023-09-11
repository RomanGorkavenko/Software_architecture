package ru.gb.software_architecture.homework.sem3.car;

import ru.gb.software_architecture.homework.sem3.car.abstraction.Car;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Cleaning;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Refueling;
import ru.gb.software_architecture.homework.sem3.car.enums.CleanType;
import ru.gb.software_architecture.homework.sem3.car.enums.FuelType;
import ru.gb.software_architecture.homework.sem3.car.enums.RoadType;
import ru.gb.software_architecture.homework.sem3.car.impl.CarWashing;
import ru.gb.software_architecture.homework.sem3.car.impl.RefuelingStation;
import ru.gb.software_architecture.homework.sem3.car.impl.RefuelingStationV2;

import java.util.ArrayList;
import java.util.List;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     *  быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     *  топлива, тип коробки передач, объём двигателя; методы:
     *  движение, обслуживание, переключение передач, включение
     *  фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     *  «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {

        Car harvester = CarSelector.getINSTANCE().getCar(RoadType.CLEANING);
        harvester.setFuelType(FuelType.Gasoline);
        harvester.setCleanType(CleanType.Windshield, CleanType.All, CleanType.Engine);

        Car soprtCar = CarSelector.getINSTANCE().getCar(RoadType.CITY);;
        soprtCar.setFuelType(FuelType.Gasoline);
        soprtCar.setCleanType(CleanType.Mirrors, CleanType.Engine, CleanType.Headlights);

        Car jeep = CarSelector.getINSTANCE().getCar(RoadType.OFF_ROAD);
        jeep.setFuelType(FuelType.Diesel);
        jeep.setCleanType(CleanType.Body, CleanType.Trunk, CleanType.Mirrors);


        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();
        RefuelingStation refuelingStation = new RefuelingStation();
        CarWashing carWashing = new CarWashing();

        List<Refueling> refuelingList = new ArrayList<>(List.of(refuelingStation, refuelingStation2));
        List<Cleaning> cleaningList = new ArrayList<>(List.of(carWashing, refuelingStation2));

        List<Car> carList = new ArrayList<>(List.of(harvester, soprtCar, jeep));



        for (Car car: carList) {
            int count = 1;
            for (Refueling refueling: refuelingList) {
                System.out.println("Машина " + car.getMake() + " заехала на заправку №" + count++);
                car.setRefuelingStation(refueling);
                car.fuel();
            }
            count = 1;
            for (Cleaning cleaning: cleaningList) {
                System.out.println("Машина " + car.getMake() + " заехала на мойку №" + count++);
                car.setClean(cleaning);
                car.clean();
            }
            System.out.println();
        }

    }

    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 1500*6;
        }
        else {
            return 1000*4;
        }
    }

}
