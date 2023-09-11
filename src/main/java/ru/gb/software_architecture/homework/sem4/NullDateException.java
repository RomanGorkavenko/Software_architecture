package ru.gb.software_architecture.homework.sem4;

import java.util.Date;

public class NullDateException extends MyByTicketException {

    public NullDateException(String message, Date date) {
        super(message, date);
    }
}
