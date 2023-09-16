package ru.gb.software_architecture.homework.sem5._3_database_access;

import ru.gb.software_architecture.homework.sem5.data.entity.Entity;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.Collection;

/**
 * Интерфейс DAC
 */
public interface DatabaseAccess {
    boolean addEntity(Entity entity);

    boolean removeEntity(Entity entity);

    void saveDatabase();

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}
