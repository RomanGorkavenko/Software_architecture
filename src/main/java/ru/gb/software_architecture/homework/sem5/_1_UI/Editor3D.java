package ru.gb.software_architecture.homework.sem5._1_UI;

import ru.gb.software_architecture.homework.sem5._2_buisness_logical.BusinessLogicalLayer;
import ru.gb.software_architecture.homework.sem5._2_buisness_logical.EditorBusinessLogicalLayer;
import ru.gb.software_architecture.homework.sem5._3_database_access.EditorDatabaseAccess;
import ru.gb.software_architecture.homework.sem5._4_database.EditorDatabase;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.ProjectFile;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.ArrayList;

/**
 * UI (User Interface)
 */
public class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;

    /**
     * Использовал Singleton для инициализации.
     * Чтобы данный слой зависел только от предыдущего.
     */
    private void initialize() {
        businessLogicalLayer = EditorBusinessLogicalLayer.getInstance(
                EditorDatabaseAccess.getInstance(
                        EditorDatabase.getInstance(projectFile)
                ));
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }

    /**
     * Протянул вертикальный срез, чтобы данный слой зависел только от предыдущего.
     */
    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        businessLogicalLayer.saveDatabase();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {

        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    /**
     * Метод удаления модели.
     * Взаимодействует с {@link EditorBusinessLogicalLayer} через интерфейс {@link BusinessLogicalLayer}.
     * С помощью предусловия проверяет открыт ли проект (создан файл).
     * Принимает на вход номер модели и проверяет его корректность.
     * Если номер не корректен выбрасывает исключение {@link RuntimeException}.
     * Передает модель для удаления из списка моделей в {@link EditorBusinessLogicalLayer}.
     * @param i номер модели.
     */
    @Override
    public void removeModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1) {
            throw new RuntimeException("Номер модели указан некорректно.");
        }

        businessLogicalLayer.removeModel(models.get(i));
    }

    /**
     * Метод добавления модели.
     * Взаимодействует с {@link EditorBusinessLogicalLayer} через интерфейс {@link BusinessLogicalLayer}.
     * Создает новую модель и передает ее для добавления в список моделей в {@link EditorBusinessLogicalLayer}.
     */
    @Override
    public void addModel() {

        // Предусловие
        checkProjectFile();

        Model3D model = new Model3D();
        businessLogicalLayer.addModel(model);
    }

    /**
     * Метод удаления текстуры.
     * Взаимодействует с {@link EditorBusinessLogicalLayer} через интерфейс {@link BusinessLogicalLayer}.
     * С помощью предусловия проверяет открыт ли проект (создан файл).
     * Принимает на вход номер текстуры и проверяет его корректность.
     * Если номер не корректен выбрасывает исключение {@link RuntimeException}.
     * Передает модель для удаления из списка моделей в {@link EditorBusinessLogicalLayer}.
     * @param i номер текстуры.
     */
    @Override
    public void removeTexture(int i) {
        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        if (i < 0 || i > textures.size() - 1) {
            throw new RuntimeException("Номер текстуры указан некорректно.");
        }
        businessLogicalLayer.removeTexture(textures.get(i));
    }

    /**
     * Метод добавления текстуры.
     * Взаимодействует с {@link EditorBusinessLogicalLayer} через интерфейс {@link BusinessLogicalLayer}.
     * Создает новую текстуру и передает ее для добавления в список текстур в {@link EditorBusinessLogicalLayer}.
     */
    @Override
    public void addTexture() {

        // Предусловие
        checkProjectFile();

        Texture texture = new Texture();
        businessLogicalLayer.addTexture(texture);
    }

}
