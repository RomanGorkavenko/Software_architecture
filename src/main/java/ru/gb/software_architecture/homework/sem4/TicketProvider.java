package ru.gb.software_architecture.homework.sem4;

import java.util.Collection;
import java.util.Date;

class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    /**
     * Поиск билета и добавление билета в коллекцию клиенту
     * @param clientId уникальный идентификатор клиента
     * @param date дата покупки билета
     * @param userTickets коллекция билетов пользователя
     * @return коллекцию билетов с добавленным новым билетом
     * @throws SearchTicketException исключение при обработке поиска билета
     * @throws NotCorrectClientIdException исключение при некорректном идентификаторе пользователя
     * @throws NullDateException исключение при обработке даты покупки билета
     * @throws NullUserCollectionException исключение при обработке коллекции билетов пользователя
     */
    public Collection<Ticket> searchTicket(int clientId, Date date, Collection<Ticket> userTickets)
            throws SearchTicketException, NotCorrectClientIdException, NullDateException, NullUserCollectionException {

        //region Предусловие

        if (clientId <= 0) {
            throw new NotCorrectClientIdException(
                    String.format("Проверка в методе searchTicket класса %s", TicketProvider.class.getName()), clientId);
        }

        if (date == null) {
            throw new NullDateException(
                    String.format("Проверка в методе searchTicket класса %s", TicketProvider.class.getName()),
                    date);
        }

        if (userTickets == null) {
            throw new NullUserCollectionException(
                    String.format("Проверка в методе searchTicket класса %s", TicketProvider.class.getName()),
                    clientId);
        }

        //endregion

        Ticket ticket = null;

        for (Ticket ticketFind : database.getTickets()) {
            if (ticketFind.getCustomerId() == clientId && ticketFind.getDate().equals(date)) {
                ticket = ticketFind;
                userTickets.add(ticket);
            }
        }

        //Постусловие
        if (ticket == null) {
            throw new SearchTicketException(
                    String.format("Проверка в методе searchTicket класса %s", TicketProvider.class.getName()),
                    clientId, date);
        }

        return userTickets;

    }

    /**
     * Покупка билетов пользователем
     * @param clientId уникальный идентификатор клиента
     * @param cardNo номер карты
     * @param date дата покупки билета
     * @return значение типа boolean
     * @throws NotCorrectClientIdException исключение при обработке коллекции билетов пользователя
     * @throws NullDateException исключение при обработке даты покупки билета
     */
    public boolean buyTicket(int clientId, String cardNo, Date date) throws NotCorrectClientIdException, NullDateException {

        //region Предусловие

        if (clientId <= 0) {
            throw new NotCorrectClientIdException(
                    String.format("Проверка в методе buyTicket класса %s", TicketProvider.class.getName()),
                    clientId);
        }

        if (date == null) {
            throw new NullDateException(
                    String.format("Проверка в методе buyTicket класса %s", TicketProvider.class.getName()),
                    date);
        }


        //endregion

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        if (paymentProvider.buyTicket(orderId, cardNo, amount)) {
            Ticket ticket = new Ticket(clientId, "<QR>", date);
            database.addTicket(ticket);
            return true;
        }
        return false;

    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }


}
