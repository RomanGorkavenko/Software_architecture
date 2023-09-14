package ru.gb.software_architecture.homework.sem5;

import java.util.Collection;

/**
 * Интерфейс DAC
 */
interface DatabaseAccess {
    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}
