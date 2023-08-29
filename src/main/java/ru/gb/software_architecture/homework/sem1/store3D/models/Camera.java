package ru.gb.software_architecture.homework.sem1.store3D.models;

public class Camera {

    private Point3D location;
    private Angle3D angle;

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Camera() {
    }

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void move(Point3D location) {
        this.location = location;
    }
}
