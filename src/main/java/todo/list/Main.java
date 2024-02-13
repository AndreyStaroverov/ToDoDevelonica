package todo.list;

import todo.list.managers.Managers;
import todo.list.managers.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = Managers.getDefault();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        outofwhile:
        while (scanner.hasNextInt()) {
            int typing = scanner.nextInt();
            switch (typing) {
                case 0:
                    System.out.println("До свидания!");
                    break outofwhile;
                case 1:
                    System.out.println("Добавьте описание задачи");
                    String message = scanner.next();
                    manager.createTask(message);
                    System.out.println(String.format("Задача %s", message));
                    printMenu();
                    break;
                case 2:
                    if (manager.getTasks().isEmpty()) {
                        System.out.println("Список задач: (пусто)");
                    } else {
                        System.out.println("Список задач:");
                        for (int i = 0; i < manager.getTasks().size(); i++) {
                            System.out.println(String.format((i + 1) + "." + "[%s]" +
                                    manager.getTasks().get(i).getDescription(), manager.checkCompleted(i + 1)));
                        }
                    }
                    printMenu();
                    break;
                case 3:
                    System.out.println("Введите номер задачи для отметки как выполненной");
                    int taskId = scanner.nextInt();
                    manager.markTaskAsCompleted(taskId);
                    System.out.println(String.format("Задача %s выполнена%n",
                            manager.getTaskById(taskId).getDescription()));
                    printMenu();
                    break;
                case 4:
                    System.out.println("Введите номер задачи для удаления");
                    int delTask = scanner.nextInt();
                    String desc = manager.getTaskById(delTask).getDescription();
                    manager.deleteTask(delTask);
                    System.out.println(String.format("Задача %s удалена%n", desc));
                    printMenu();
                    break;
                default:
                    System.out.println("Такого варианта не существует, попробуйте еще раз.");
            }
        }
    }


    public static void printMenu() {
        System.out.println("Добро пожаловать в приложение To-Do List!");
        System.out.println("1 - Добавить новую задачу");
        System.out.println("2 - Просмотр списка задач");
        System.out.println("3 - Отметить задачу выполненной");
        System.out.println("4 - Удалить задачу");
        System.out.println("0 - выход");
        System.out.println("Выберите действие(Выберите номер):");
    }
}
