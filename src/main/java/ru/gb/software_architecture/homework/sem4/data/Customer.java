package ru.gb.software_architecture.homework.sem4.data;

import ru.gb.software_architecture.homework.sem4.exceptions.impl.NullTicketException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Покупатель
 */
class Customer {

    private static int counter;

    private final int id;

    private Collection<Ticket> tickets = new ArrayList<>();

    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }


    /**
     * Обновление коллекции билетов у пользователя.
     * @param tickets коллекция билетов.
     * @throws NullTicketException исключение при проверке билетов у пользователя.
     */
    public void setTickets(Collection<Ticket> tickets) throws NullTicketException {
        //Предусловие
        for (Ticket ticket: tickets) {
            if (ticket == null) {
                throw new NullTicketException(
                        String.format("Проверка в методе setTickets класса %s", Customer.class.getName()));
            }
        }

        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}
