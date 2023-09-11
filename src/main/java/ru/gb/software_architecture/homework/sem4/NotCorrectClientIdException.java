package ru.gb.software_architecture.homework.sem4;

public class NotCorrectClientIdException extends MyByTicketException{
    public NotCorrectClientIdException(String message, int customerId) {
        super(message, customerId);
    }
}
