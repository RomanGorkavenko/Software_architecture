package ru.gb.software_architecture.homework.sem4.exceptions.impl;

import ru.gb.software_architecture.homework.sem4.exceptions.MyByTicketException;

import java.util.Date;

public class NullDateException extends MyByTicketException {

    public NullDateException(String message, Date date) {
        super(message, date);
    }
}
