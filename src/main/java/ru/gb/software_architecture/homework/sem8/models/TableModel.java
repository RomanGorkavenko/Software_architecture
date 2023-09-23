package ru.gb.software_architecture.homework.sem8.models;

import ru.gb.software_architecture.homework.sem8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика");
    }

    /**
     * Изменение бронирования
     * @param oldReservation Номер прошлого бронирования
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     * @return Номер бронирования
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        for (Table table: tables) {
            for (Reservation reservation: table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    int reservationId = reservationTable(reservationDate, tableNo, name);
                    table.getReservations().remove(reservation);
                    return reservationId;
                }
            }
        }
        throw new RuntimeException("Не корректный номер бронирования");
    }

}
