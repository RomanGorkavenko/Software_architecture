package ru.gb.software_architecture.homework.sem4.exceptions.impl;

import ru.gb.software_architecture.homework.sem4.exceptions.MyByTicketException;

public class NullTicketException extends MyByTicketException {

    public NullTicketException(String message) {
        super(message);
    }
}
