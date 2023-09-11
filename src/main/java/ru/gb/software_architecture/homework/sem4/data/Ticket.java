package ru.gb.software_architecture.homework.sem4.data;

import java.util.Date;

/**
 * Билет
 */
public class Ticket {

    private static int counter;

    private int id;

    private int customerId;

    private Date date;

    private String qrcode;

    private boolean enable = true;

    {
        id = ++counter;
    }

    public Ticket(int customerId, String qrcode, Date date) {
        this.customerId = customerId;
        this.qrcode = qrcode;
        this.date = date;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }
}
