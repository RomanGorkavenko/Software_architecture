package ru.gb.software_architecture.homework.sem5._2_buisness_logical;

import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.Collection;

/**
 * Интерфейс BLL (Business Logical Layer)
 */
public interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();
    void renderModel(Model3D model);
    void renderAllModels();
    void removeModel(Model3D model);
    void addModel(Model3D model);
    void removeTexture(Texture texture);
    void addTexture(Texture texture);
    void saveDatabase();
}
