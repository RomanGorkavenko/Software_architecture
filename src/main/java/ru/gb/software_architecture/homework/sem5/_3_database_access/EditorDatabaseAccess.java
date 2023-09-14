package ru.gb.software_architecture.homework.sem5._3_database_access;

import ru.gb.software_architecture.homework.sem5._4_database.Database;
import ru.gb.software_architecture.homework.sem5.data.entity.Entity;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Реализация DAC
 * Использовал Singleton.
 */
public class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    private static EditorDatabaseAccess instance;

    private EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    public static EditorDatabaseAccess getInstance(Database editorDatabase) {
        if (instance==null){
            instance = new EditorDatabaseAccess(editorDatabase);
        }

        return instance;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    /**
     * Добавил в качестве предусловия проверку на то, что Entity не равно null.
     * В случае выполнения предусловия выбрасывается исключение {@link RuntimeException}.
     * Изменил сигнатуру метода с void на boolean, для реализации своей логики.
     * @param entity {@link Entity} и классы его реализующие.
     * @return тип boolean/
     */
    @Override
    public boolean addEntity(Entity entity) {

        // Предусловие
        if (entity == null) {
            throw new RuntimeException("Ошибка выполнения добавления");
        }

        editorDatabase.getAll().add(entity);
        return true;
    }

    /**
     * Добавил в качестве предусловия проверку на то, что Entity содержится в коллекции
     * из которой мы хотим ее удалить.
     * В случае выполнения предусловия выбрасывается исключение {@link RuntimeException}.
     * Изменил сигнатуру метода с void на boolean, для реализации своей логики.
     * @param entity {@link Entity} и классы его реализующие.
     * @return тип boolean/
     */
    @Override
    public boolean removeEntity(Entity entity) {

        // Предусловие
        if (!editorDatabase.getAll().contains(entity)) {
            throw new RuntimeException("Ошибка выполнения удаления");
        }

        editorDatabase.getAll().remove(entity);
        return true;
    }

    @Override
    public void saveDatabase() {
        editorDatabase.save();
    }


}
