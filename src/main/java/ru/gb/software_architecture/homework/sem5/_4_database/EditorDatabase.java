package ru.gb.software_architecture.homework.sem5._4_database;

import ru.gb.software_architecture.homework.sem5.data.entity.Entity;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.ProjectFile;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Database
 */
public class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    private static EditorDatabase instance;

    private EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    public static EditorDatabase getInstance(ProjectFile projectFile) {
        if (instance == null) {
            instance = new EditorDatabase(projectFile);
        }

        return instance;
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save() {
        //TODO: Сохранение текущего состояния всех сущностей проекта
    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

}
