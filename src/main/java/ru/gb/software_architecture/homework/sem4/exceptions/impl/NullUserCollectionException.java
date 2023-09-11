package ru.gb.software_architecture.homework.sem4.exceptions.impl;

import ru.gb.software_architecture.homework.sem4.exceptions.MyByTicketException;

public class NullUserCollectionException extends MyByTicketException {

    public NullUserCollectionException(String message, int customerId) {
        super(message, customerId);
    }
}
