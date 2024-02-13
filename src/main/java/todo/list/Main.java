package todo.list;

import todo.list.managers.Managers;
import todo.list.managers.TaskManager;
import todo.list.models.Task;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final TaskManager manager = Managers.getDefault();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();
        while (scanner.hasNextInt()) {
            int typing = scanner.nextInt();
            switch (typing) {
                case 0 -> exit();
                case 1 -> addTask();
                case 2 -> viewAllTasks();
                case 3 -> markTaskAsCompleted();
                case 4 -> deleteTask();
                default -> badInput();
            }
        }
    }

    public static void printMenu() {
        System.out.println("Добро пожаловать в приложение To-Do List!");
        System.out.println("1 - Добавить новую задачу");
        System.out.println("2 - Просмотр списка задач");
        System.out.println("3 - Отметить задачу выполненной");
        System.out.println("4 - Удалить задачу");
        System.out.println("0 - Выход");
        System.out.println("Выберите действие (введите номер):");
    }

    public static void exit() {
        System.out.println("До свидания!");
        System.exit(0);
    }

    public static void addTask() {
        System.out.println("Добавьте описание задачи");
        String message = scanner.next();
        manager.createTask(message);
        System.out.println(String.format("Задача %s", message));
        printMenu();
    }

    public static void viewAllTasks() {
        if (manager.getTasks().isEmpty()) {
            System.out.println("Список задач: (пусто)");
        } else {
            System.out.println("Список задач:");
            List<Task> tasks = manager.getTasks();
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(String.format(tasks.get(i).getTaskId() + "." + "[%s]" +
                        tasks.get(i).getDescription(), manager.checkCompleted(tasks.get(i).getTaskId())));
            }
        }
        printMenu();
    }

    public static void markTaskAsCompleted() {
        boolean isValid = false;
        int taskId;
        do {
            try {
                System.out.println("Введите номер задачи для отметки как выполненной");
                taskId = scanner.nextInt();
                manager.markTaskAsCompleted(taskId);
                System.out.println(String.format("Задача %s выполнена", manager.getTaskById(taskId).getDescription()));
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            } catch (NullPointerException e) {
                System.out.println("Задачи с таким номером не существует");
            }
        } while (!isValid);
        printMenu();
    }

    public static void deleteTask() {
        boolean isValid = false;
        int delTask = 0;
        String desc = null;
        do {
            try {
                System.out.println("Введите номер задачи для удаления");
                delTask = scanner.nextInt();
                desc = manager.getTaskById(delTask).getDescription();
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            } catch (NullPointerException e) {
                System.out.println("Задачи с таким номером не существует");
            }
        } while (!isValid);
        manager.deleteTask(delTask);
        System.out.println(String.format("Задача %s удалена", desc));
        printMenu();
    }

    public static void badInput() {
        System.out.println("Такого варианта не существует, попробуйте еще раз.");
        printMenu();
    }
}
