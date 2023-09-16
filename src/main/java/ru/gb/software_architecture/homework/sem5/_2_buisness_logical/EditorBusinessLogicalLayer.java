package ru.gb.software_architecture.homework.sem5._2_buisness_logical;

import ru.gb.software_architecture.homework.sem5._3_database_access.DatabaseAccess;
import ru.gb.software_architecture.homework.sem5._3_database_access.EditorDatabaseAccess;
import ru.gb.software_architecture.homework.sem5.data.entity.Entity;
import ru.gb.software_architecture.homework.sem5.data.entity.impl.Model3D;
import ru.gb.software_architecture.homework.sem5.data.Texture;

import java.util.Collection;
import java.util.Random;

/**
 * Реализация Business Logical Layer
 * Использовал Singleton.
 */
public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    private static EditorBusinessLogicalLayer instance;

    private EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public static EditorBusinessLogicalLayer getInstance(DatabaseAccess databaseAccess) {
        if (instance == null) {
            instance = new EditorBusinessLogicalLayer(databaseAccess);
        }

        return instance;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    /**
     * Метод удаления модели.
     * Взаимодействует с {@link EditorDatabaseAccess} через интерфейс {@link DatabaseAccess}.
     * Принимает на вход модель и передает ее для удаления из списка моделей в {@link EditorDatabaseAccess}.
     * Проверяет прошло ли удаление модели корректно,
     * получая значение типа boolean от метода {@link DatabaseAccess#removeEntity(Entity)}.
     * В случае успешного завершения выдает сообщение об успешной операции.
     * @param model модель.
     */
    @Override
    public void removeModel(Model3D model) {
        if (databaseAccess.removeEntity(model)) {
            System.out.printf("3DModel #%s успешно удалена\n", model.getId());
        }
    }

    /**
     * Метод добавления модели.
     * Взаимодействует с {@link EditorDatabaseAccess} через интерфейс {@link DatabaseAccess}.
     * Принимает на вход модель и передает ее для добавления в список моделей в {@link EditorDatabaseAccess}.
     * Проверяет прошло ли удаление модели корректно,
     * получая значение типа boolean от метода {@link DatabaseAccess#removeEntity(Entity)}.
     * В случае успешного завершения выдает сообщение об успешной операции и добавляет в модель
     * новые текстуры рандомно.
     * Затем вызывает метод добавления текстуры {@link EditorBusinessLogicalLayer#addTexture(Texture)}.
     * @param model модель.
     */
    @Override
    public void addModel(Model3D model) {
        if (databaseAccess.addEntity(model)) {
            System.out.printf("3DModel #%s успешно добавлена\n", model.getId());
            int txCount = random.nextInt(3);
            for (int i = 0; i < txCount; i++) {
                Texture texture = new Texture();
                model.getTextures().add(texture);
                addTexture(texture);
            }
        }
    }

    /**
     * Метод удаления текстуры.
     * Взаимодействует с {@link EditorDatabaseAccess} через интерфейс {@link DatabaseAccess}.
     * Принимает на вход текстуру и передает ее для удаления из списка текстур в {@link EditorDatabaseAccess}.
     * Проверяет прошло ли удаление текстуры корректно,
     * получая значение типа boolean от метода {@link DatabaseAccess#removeEntity(Entity)}.
     * В случае успешного завершения, проходится по списку моделей и проверяет,
     * содержит ли какая-нибудь модель, данную текстуру.
     * Если есть модель с такой текстурой, то удаляет эту текстуру у модели.
     * Выдает сообщение об успешной операции.
     * @param texture текстура.
     */
    @Override
    public void removeTexture(Texture texture) {
        if (databaseAccess.removeEntity(texture)) {
            for (Model3D model: databaseAccess.getAllModels()) {
                if (model.getTextures().contains(texture)) {
                    model.getTextures().remove(texture);
                    break;
                }
            }
            System.out.printf("Texture #%s успешно удалена\n", texture.getId());
        }
    }

    /**
     * Метод добавления текстуры.
     * Взаимодействует с {@link EditorDatabaseAccess} через интерфейс {@link DatabaseAccess}.
     * Принимает на вход текстуру и передает ее для добавления в список текстур в {@link EditorDatabaseAccess}.
     * Проверяет прошло ли удаление модели корректно,
     * получая значение типа boolean от метода {@link DatabaseAccess#addEntity(Entity)}.
     * В случае успешного завершения выдает сообщение об успешной операции.
     * @param texture текстура.
     */
    @Override
    public void addTexture(Texture texture) {
        if (databaseAccess.addEntity(texture)) {
            System.out.printf("Texture #%s успешно добавлена\n", texture.getId());
        }
    }

    @Override
    public void saveDatabase() {
        databaseAccess.saveDatabase();
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
