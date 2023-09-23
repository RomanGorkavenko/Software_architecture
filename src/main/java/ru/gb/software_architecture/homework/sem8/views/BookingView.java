package ru.gb.software_architecture.homework.sem8.views;

import ru.gb.software_architecture.homework.sem8.models.Reservation;
import ru.gb.software_architecture.homework.sem8.models.Table;
import ru.gb.software_architecture.homework.sem8.presenters.View;
import ru.gb.software_architecture.homework.sem8.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
            for (Reservation reservation: table.getReservations()) {
                System.out.printf("     reservation = %d\n", reservation.getId());
            }
        }
    }

    @Override
    public void showReservationTableResult(String message, int reservationNo) {
        if (reservationNo > 0){
            System.out.printf(message + ". Номер вашей брони: #%d\n", reservationNo);
        }
        else {
            System.out.println(message + ", попробуйте повторить попытку позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку изменения резерва)
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if (observer != null)
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }


}
