package ru.gb.software_architecture.homework.sem1.store3D.models;

import java.awt.*;

public class Flash {

    private Point3D location;
    private Angle3D angle;

    /**
     * package java.awt.{@link Color},
     * The default color space for the Java 2D(tm) API is sRGB, a proposed
     * standard RGB color space.  For further information on sRGB,
     * see <A href="http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html">
     * http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html
     * </A>.
     */
    private Color color;
    private Float power;

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Flash() {
    }

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void move(Point3D location) {
        this.location = location;
    }

}
