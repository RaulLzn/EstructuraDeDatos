package raul.Model.TaskManager;

/**
 * Cada tarea debe tener las siguientes propiedades:
 * •Task name (string)
 * •Priority (integer, 1 es la máxima prioridad)
 * •Completion status (boolean)
 */

 // Clase que representa una tarea:

public class Task {

    private String taskName;
    private int priority;
    private boolean completionStatus;

    public Task (String taskName, int priority, boolean completionStatus) {
        this.taskName = taskName;
        this.priority = priority;
        this.completionStatus = completionStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", completionStatus=" + completionStatus +
                '}';
    }
    
}
