package ru.gb.software_architecture.homework.sem4.exceptions;

import java.util.Date;

public abstract class MyByTicketException extends Exception{

    private int ticketId;

    private int customerId;

    private Date date;

    public MyByTicketException(String message) {
        super(message);
    }

    public MyByTicketException(String message, int ticketId, int customerId, Date date) {
        super(message);
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.date = date;
    }

    public MyByTicketException(String message, Date date) {
        super(message);
        this.date = date;
    }

    public MyByTicketException(String message, int customerId, Date date) {
        super(message);
        this.customerId = customerId;
        this.date = date;
    }

    public MyByTicketException(String message, int customerId) {
        super(message);
        this.customerId = customerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }
}
