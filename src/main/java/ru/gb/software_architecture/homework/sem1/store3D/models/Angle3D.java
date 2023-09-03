package ru.gb.software_architecture.homework.sem1.store3D.models;

public class Angle3D {

    /**
     * <a href="https://habr.com/ru/companies/unigine/articles/672930/">Углы Тейта— Брайана (или yaw,pitch,roll)</a>
     */
    private double yaw, pitch, roll;

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public Angle3D(double yaw, double pitch, double roll) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }
}
