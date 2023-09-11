package ru.gb.software_architecture.homework.sem4;

public class NullUserCollectionException extends MyByTicketException {

    public NullUserCollectionException(String message, int customerId) {
        super(message, customerId);
    }
}
