package ru.gb.software_architecture.homework.sem1.store3D.models;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private static int counter = 0;

    private int id;
    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    public int getId() {
        return id;
    }

    public List<PoligonalModel> getModels() {
        return models;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public Scene(List<PoligonalModel> models, List<Camera> cameras) {
        this.models = models;
        this.cameras = cameras;
    }

    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    {
        id = ++counter;
    }



}
