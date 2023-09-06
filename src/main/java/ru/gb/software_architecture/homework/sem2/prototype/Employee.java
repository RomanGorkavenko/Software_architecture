package ru.gb.software_architecture.homework.sem2.prototype;

/**
 * Класс Сотрудник
 */
public class Employee implements Cloneable {

    /**
     * Имя сотрудника
     */
    private String name;

    /**
     * Занимаемая должность
     */
    private String currentPosition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", currentPosition='" + currentPosition + '\'' +
                '}';
    }
}
