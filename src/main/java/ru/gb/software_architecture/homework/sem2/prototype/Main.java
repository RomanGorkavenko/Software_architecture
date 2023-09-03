package ru.gb.software_architecture.homework.sem2.prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employee recipient = new Employee();
        recipient.setName("John");
        recipient.setCurrentPosition("Manager");

        Employee executor = new Employee();
        executor.setName("Bob");
        executor.setCurrentPosition("Typographer");

        System.out.println(TaskPrototypeManager.getClonedTask("CinemaSchedule"));

        PrototypeCapableTask clonedTask = TaskPrototypeManager.getClonedTask("CinemaSchedule");
        clonedTask.setRecipient(recipient);
        clonedTask.setExecutor(executor);
        System.out.println("clonedTask = " + clonedTask);

        System.out.println(TaskPrototypeManager.getClonedTask("CinemaSchedule"));

    }

}
