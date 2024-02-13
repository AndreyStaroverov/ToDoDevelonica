package todo.list.managers;

import todo.list.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryTaskManager implements TaskManager {

    private Integer id = 1;
    private final HashMap<Integer, Task> taskMap = new HashMap<>();

    @Override
    public void createTask(String description) {
        int taskId = id;
        taskMap.put(id, new Task(id, description, false));
        id++;
    }

    @Override
    public List<Task> getTasks() {
        ArrayList<Task> allTasks = new ArrayList<>();
        for (int k : taskMap.keySet()) {
            allTasks.add(taskMap.get(k));
        }
        return allTasks;
    }

    @Override
    public void deleteTask(int id) {
        taskMap.remove(id);
    }

    @Override
    public void deleteAllTasks() {
        taskMap.clear();
    }

    @Override
    public Task getTaskById(int id) {
        return taskMap.get(id);
    }

    @Override
    public void markTaskAsCompleted(int id) {
        taskMap.get(id).setCompleted(true);
    }

    @Override
    public String checkCompleted(int id) {
        if (taskMap.get(id).getCompleted()) {
            return "X";
        } else {
            return "";
        }
    }
}
