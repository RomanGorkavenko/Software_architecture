package ru.gb.software_architecture.homework.sem2.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс управляет шаблонами (прототипами)
 */
public class TaskPrototypeManager {

    /**
     * Коллекция prototypes, хранит ключ значение шаблонов задач
     */
    private static final Map<String, PrototypeCapableTask> prototypes = new HashMap<>();

    //Блок статической инициализации для создания и добавления прототипов
    static {
        Employee recipient = new Employee();

        Employee executor = new Employee();

        Task taskCinemaSchedule = new Task();
        taskCinemaSchedule.setNameTask("Cinema schedule");
        taskCinemaSchedule.setDescription("Printing, lamination");
        taskCinemaSchedule.setRecipient(recipient);
        taskCinemaSchedule.setExecutor(executor);

        prototypes.put("CinemaSchedule", taskCinemaSchedule);

    }

    /**
     * Метод получения клонированной задачи
     * @param type ключ для получения шаблона задачи из коллекции.
     * @return {@link PrototypeCapableTask}
     * @throws CloneNotSupportedException
     */
    public static PrototypeCapableTask getClonedTask(final String type) throws CloneNotSupportedException {
        PrototypeCapableTask task = prototypes.get(type);
        return task.cloneTask();
    }

}
