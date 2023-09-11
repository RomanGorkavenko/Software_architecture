package ru.gb.software_architecture.homework.sem3.car.impl;

import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Cleaning;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Washing;
import ru.gb.software_architecture.homework.sem3.car.abstraction.interfaces.Wiping;
import ru.gb.software_architecture.homework.sem3.car.enums.CleanType;

import java.util.Arrays;

/**
 * Класс автомойка.
 */
public class CarWashing implements Cleaning, Washing, Wiping {

    @Override
    public void clean(CleanType... cleanType) {
        if (Arrays.asList(cleanType).contains(CleanType.All)) {
            washAll(CleanType.All.getTitle());
            return;
        }
        for (CleanType type : cleanType) {
            switch (type) {
                case Windshield -> {
                    if (Arrays.asList(cleanType).contains(CleanType.Body)) {
                        break;
                    }
                    wipWindshield(type.getTitle());
                }
                case Headlights -> {
                    if (Arrays.asList(cleanType).contains(CleanType.Body)) {
                        break;
                    }
                    wipHeadlights(type.getTitle());
                }
                case Mirrors -> {
                    if (Arrays.asList(cleanType).contains(CleanType.Body)) {
                        break;
                    }
                    wipMirrors(type.getTitle());
                }
                case Engine -> washEngine(type.getTitle());
                case Body -> washBody(type.getTitle());
                case Interior -> washInterior(type.getTitle());
                case Trunk -> washTrunk(type.getTitle());
            }
        }

    }

    @Override
    public void washBody(String cleanTitle) {
        System.out.println("Помыли " + cleanTitle);
    }

    @Override
    public void washInterior(String cleanTitle) {
        System.out.println("Помыли " + cleanTitle);
    }

    @Override
    public void washEngine(String cleanTitle) {
        System.out.println("Помыли " + cleanTitle);
    }

    @Override
    public void washTrunk(String cleanTitle) {
        System.out.println("Помыли " + cleanTitle);
    }

    @Override
    public void washAll(String cleanTitle) {
        System.out.println("Помыли " + cleanTitle);
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
}
