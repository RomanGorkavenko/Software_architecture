package ru.gb.software_architecture.homework.sem2.prototype;

/**
 * Класс расширяющий {@link PrototypeCapableTask}
 */
public class Task extends PrototypeCapableTask {

    @Override
    public PrototypeCapableTask cloneTask() throws CloneNotSupportedException {

        Task newTask = (Task) super.clone();

        Employee cloneRecipient = newTask.getRecipient().clone();
        newTask.setRecipient(cloneRecipient);

        Employee cloneExecutor = newTask.getExecutor().clone();
        newTask.setExecutor(cloneExecutor);

        return newTask;
    }

    @Override
    public String toString() {
        return "TaskName: " + this.getNameTask() + ", Recipient: " + this.getRecipient() + ", Executor: " + this.getExecutor();
    }
}
