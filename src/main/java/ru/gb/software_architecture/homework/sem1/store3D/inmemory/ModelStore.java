package ru.gb.software_architecture.homework.sem1.store3D.inmemory;

import ru.gb.software_architecture.homework.sem1.store3D.models.Camera;
import ru.gb.software_architecture.homework.sem1.store3D.models.Flash;
import ru.gb.software_architecture.homework.sem1.store3D.models.PoligonalModel;
import ru.gb.software_architecture.homework.sem1.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {

    private List<ModelChangedObserver> observers = new ArrayList<>();
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Scene> scenes;
    private List<Camera> cameras;

    public ModelStore(List<PoligonalModel> models, List<Flash> flashes, List<Scene> scenes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.scenes = scenes;
        this.cameras = cameras;
    }

    public void add(PoligonalModel model){
        models.add(model);
        notifyChange();
    }

    public void add(Flash flash){
        flashes.add(flash);
        notifyChange();
    }

    public void add(Camera camera){
        cameras.add(camera);
        notifyChange();
    }

    public void add(Scene scene){
        scenes.add(scene);
        notifyChange();
    }

    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }

    public Scene getScenes(int numberScene) {
        if (scenes.size() < numberScene) {
            throw new RuntimeException("Сцены с таким номером не существует");
        }else {
            return scenes.get(numberScene - 1);
        }
    }
}
