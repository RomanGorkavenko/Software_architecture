package ru.gb.software_architecture.homework.sem4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных
 */
class Database {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {

        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

}
