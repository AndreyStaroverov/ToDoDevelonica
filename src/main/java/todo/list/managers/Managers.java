package todo.list.managers;

import java.io.File;
import java.net.URI;

public class Managers {
    static TaskManager InMemoryTaskManager;

    public static TaskManager getDefault() {
        return new MemoryTaskManager();
    }
}
