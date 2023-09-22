package ru.gb.software_architecture.homework.sem8;

import ru.gb.software_architecture.homework.sem8.models.TableModel;
import ru.gb.software_architecture.homework.sem8.presenters.BookingPresenter;
import ru.gb.software_architecture.homework.sem8.presenters.Model;
import ru.gb.software_architecture.homework.sem8.presenters.View;
import ru.gb.software_architecture.homework.sem8.views.BookingView;

import java.util.Date;

public class Main {

    /**
     * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");

        //view.changeReservationTable(1001, new Date, 3, "Станислав");
    }

}
