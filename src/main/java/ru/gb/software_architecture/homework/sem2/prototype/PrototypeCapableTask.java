package ru.gb.software_architecture.homework.sem2.prototype;

/**
 * Абстрактный класс (шаблон), реализует интерфейс {@link Cloneable}
 */
public abstract class PrototypeCapableTask implements Cloneable {

    /**
     * Кому направляется задача
     */
    private Employee recipient;

    /**
     * Кто назначен исполнителем задачи
     */
    private Employee executor;

    /**
     * Название задачи
     */
    private String nameTask;

    /**
     * Описание задачи
     */
    private String description;

    public Employee getRecipient() {
        return recipient;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public Employee getExecutor() {
        return executor;
    }

    public void setExecutor(Employee executor) {
        this.executor = executor;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Абстрактный метод для реализации алгоритма клонирования классами наследниками
     * @return {@link PrototypeCapableTask}
     * @throws CloneNotSupportedException
     */
    public abstract PrototypeCapableTask cloneTask() throws CloneNotSupportedException;

    @Override
    public String toString() {
        return "PrototypeCapableTask{" +
                "recipient=" + recipient +
                ", executor=" + executor +
                ", nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
