package ru.gb.software_architecture.homework.sem5;

import ru.gb.software_architecture.homework.sem5._1_UI.Editor3D;

import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация .., в файловой системе компьютера).
     * <p>
     * Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере…
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        int entityNo;
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Выполнить удаление модели");
            System.out.println("9. Выполнить удаление текстуры");
            System.out.println("10. Выполнить добавление модели");
            System.out.println("11. Выполнить добавление текстуры");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 2:
                            editor3D.saveProject();
                            System.out.println("Проект успешно сохранен.");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            entityNo = selection("Укажите номер модели: ");
                            if (entityNo != -1) {
                                editor3D.renderModel(entityNo);
                            }
                            break;
                        case 8:
                            editor3D.printAllModels();
                            entityNo = selection("Укажите номер модели: ");
                            if (entityNo != -1) {
                                editor3D.removeModel(entityNo);
                            }
                            break;
                        case 9:
                            editor3D.printAllTextures();
                            entityNo = selection("Укажите номер текстуры : ");
                            if (entityNo != -1) {
                                editor3D.removeTexture(entityNo);
                            }
                            break;
                        case 10:
                            editor3D.addModel();
                            break;
                        case 11:
                            editor3D.addTexture();
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Выделил код обработки входного значения в отдельный метод,
     * чтобы было меньше однотипного кода.
     * @param message сообщение о том, что необходимо выбрать.
     *                Текстуру или модель.
     * @return возвращает номер сущности или -1 для последующей проверки.
     */
    private static int selection(String message) {
        System.out.print(message);
        if (scanner.hasNextInt()) {
            int no = scanner.nextInt();
            scanner.nextLine();
            return no;
        } else {
            System.out.println("Номер указан некорректно.");
            return -1;
        }
    }
}

