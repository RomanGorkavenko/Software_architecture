package ru.gb.software_architecture.homework.sem4.exceptions.impl;

import ru.gb.software_architecture.homework.sem4.exceptions.MyByTicketException;

import java.util.Date;

public class SearchTicketException extends MyByTicketException {

    public SearchTicketException(String message, int customerId, Date date) {
        super(message, customerId, date);
    }
}
