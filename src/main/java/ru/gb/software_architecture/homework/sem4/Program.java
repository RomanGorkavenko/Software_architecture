package ru.gb.software_architecture.homework.sem4;

import java.util.Collection;
import java.util.Date;

public class Program {

/**
 * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
 *
 * 1.  Предусловия.
 * 2.  Постусловия.
 * 3.  Инвариант.
 * 4.  Определить абстрактные и конкретные классы.
 * 5.  Определить интерфейсы.
 * 6.  Реализовать наследование.
 * 7.  Выявить компоненты.
 * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
 */
    public static void main(String[] args) {

        Date date = new Date();


        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        Date dateTest = new Date();
        try {
            if (mobileApp.buyTicket("11000000221", date)) {
                System.out.println("Клиент успешно купил билет.");
                mobileApp.searchTicket(date);
                Collection<Ticket> tickets = mobileApp.getTickets();
                if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                    System.out.println("Клиент успешно прошел в автобус.");
                }
            }
        } catch (SearchTicketException exception) {
            System.out.printf("У пользователя <<%d>> , билета с датой %s не найден\n%s\n",
                    exception.getCustomerId(),
                    exception.getDate(),
                    exception.getMessage());
        } catch (NotCorrectClientIdException exception) {
            System.out.printf("Не корректный идентификатор пользователя <<%d>>\n%s\n",
                    exception.getCustomerId(),
                    exception.getMessage());
        } catch (NullDateException exception) {
            System.out.printf("Не корректная дата покупки билета %s\n%s\n",
                    exception.getDate(),
                    exception.getMessage());
        } catch (NullUserCollectionException exception) {
            System.out.printf("Коллекция билетов пользователя <<%d>> не проинициализированная\n%s\n",
                    exception.getCustomerId(),
                    exception.getMessage());
        } catch (NullTicketException exception) {
            System.out.printf("У пользователя <<%d>> в коллекции есть некорректные билеты\n%s\n",
                    exception.getCustomerId(),
                    exception.getMessage());
        }


    }

}


