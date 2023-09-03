package ru.gb.software_architecture.homework.sem1.store3D.inmemory;

public class Observer2 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Была добавлена новая полигональная модель - observer#2");
    }
}
