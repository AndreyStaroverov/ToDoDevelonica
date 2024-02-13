package todo.list.managers;

import todo.list.models.Task;

import java.util.List;

public interface TaskManager {

    void createTask(String description);

    List<Task> getTasks();

    void deleteTask(int id);

    void deleteAllTasks();

    Task getTaskById(int id);

    void isCompleted(int id);
    public String checkCompleted(int id);
}
