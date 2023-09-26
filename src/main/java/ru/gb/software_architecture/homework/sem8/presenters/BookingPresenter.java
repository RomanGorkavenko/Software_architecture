package ru.gb.software_architecture.homework.sem8.presenters;

import ru.gb.software_architecture.homework.sem8.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(String message, int reservationNo){
        view.showReservationTableResult(message, reservationNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult("Столик успешно забронирован", reservationNo);

        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(e.getMessage(), -1);
        }
    }

    /**
     * Произошло событие, пользователь нажал на кнопку изменения резерва
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIShowReservationTableResult("Бронь #" + oldReservation + " успешно отменена. " +
                            "Столик успешно забронирован", reservationNo);
        } catch (RuntimeException e) {
            updateUIShowReservationTableResult(e.getMessage(), -1);
        }
    }
}
