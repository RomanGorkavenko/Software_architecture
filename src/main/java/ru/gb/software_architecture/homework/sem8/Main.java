package ru.gb.software_architecture.homework.sem8;

import ru.gb.software_architecture.homework.sem8.models.TableModel;
import ru.gb.software_architecture.homework.sem8.presenters.BookingPresenter;
import ru.gb.software_architecture.homework.sem8.presenters.Model;
import ru.gb.software_architecture.homework.sem8.presenters.View;
import ru.gb.software_architecture.homework.sem8.views.BookingView;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        System.out.println();
        view.reservationTable(new Date(), 2, "Станислав");

        System.out.println();
        view.changeReservationTable(1001, new Date(),2, "Станислав");

        System.out.println();
        view.reservationTable(new Date(), 2, "Bob");

        //Exception номер бронирования указан неверно.
        System.out.println();
        view.changeReservationTable(1005, new Date(),2, "Станислав");

        //Exception номер столика указан неверно.
        System.out.println();
        view.changeReservationTable(1002, new Date(),8, "Станислав");

        System.out.println();
        presenter.updateUIShowTables();
    }

}
