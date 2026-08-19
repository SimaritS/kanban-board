import java.util.List;

public class TaskHistory {
    //this class is basicaly for the undo stack as we
    //need a way to track the oglist at the time of deletion
    private final Task task;
    private final List<Task> ogList;

    public TaskHistory(Task task, List<Task> originalList) {
        this.task = task;
        this.ogList = originalList;
    }

    public Task getTask() {
        return task;
    }

    public List<Task> getOgList() {
        return ogList;
    }
}
