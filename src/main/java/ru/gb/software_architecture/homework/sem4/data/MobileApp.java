package ru.gb.software_architecture.homework.sem4.data;

import ru.gb.software_architecture.homework.sem4.exceptions.impl.*;

import java.util.Collection;
import java.util.Date;

/**
 * Мобильное приложение
 */
public class MobileApp {

    private final Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;


    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer("<login>", "<password>");

    }

    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public void searchTicket(Date date)
            throws SearchTicketException, NotCorrectClientIdException, NullDateException,
            NullUserCollectionException, NullTicketException {
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), date, customer.getTickets()));
    }

    public boolean buyTicket(String cardNo, Date date) throws NotCorrectClientIdException, NullDateException {
        return ticketProvider.buyTicket(customer.getId(), cardNo, date);
    }

}
