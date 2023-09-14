package ru.gb.software_architecture.homework.sem5;

/**
 * Интерфейс UI
 */
interface UILayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

}
