package todo.list.models;

public class Task {

    protected int taskId;
    protected String description;
    protected boolean completed;

    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Task(int taskId, String description, boolean completed) {
        this.taskId = taskId;
        this.description = description;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
