package ru.gb.software_architecture.homework.sem1.store3D;

import ru.gb.software_architecture.homework.sem1.store3D.inmemory.ModelStore;
import ru.gb.software_architecture.homework.sem1.store3D.inmemory.Observer1;
import ru.gb.software_architecture.homework.sem1.store3D.models.*;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();

        List<Poligon> poligons = new ArrayList<>(List.of(new Poligon()));
        List<PoligonalModel> poligonalModels = new ArrayList<>(List.of(new PoligonalModel(poligons)));

        List<Flash> flashes = new ArrayList<>(List.of(new Flash()));

        List<Camera> cameras = new ArrayList<>(List.of(new Camera()));

        List<Scene> scenes = new ArrayList<>(List.of(new Scene(poligonalModels, cameras)));

        ModelStore store = new ModelStore(poligonalModels, flashes, scenes, cameras);
        store.RegisterModelChanger(observer1);
        store.add(new PoligonalModel(new ArrayList<>(List.of(new Poligon()))));

        System.out.println(store.getScenes(1).getId());

    }

}
