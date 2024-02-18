package raul.Model.TaskManager.TaskManager;

import raul.Model.TaskManager.Task;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class TaskManager implements TaskManagerInterface{

    private LinkedList<Task> taskList;

    public TaskManager() {
        this.taskList = new LinkedList<>();
    }

    @Override
    public boolean addTask(Task taskName, int priority) {

    taskName.setPriority(priority);

        if (taskList.isEmpty()) {
            taskList.add(taskName);
            return true;
        }

        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskName().equals(taskName.getTaskName())) {
                return false;
            }
        }

        taskList.add(taskName);
        taskList.sort(Task::getPriority);
        return true;
    }

    @Override
    public boolean removeTask(String taskName) {
        Task taskToRemove = null;
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskName().equals(taskName)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            return taskList.remove(taskToRemove);
        } else {
            return false;
        }
    }

    @Override
    public boolean markCompleted(String taskName) {
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskName().equals(taskName)) {
                task.setCompletionStatus(true);
                return true;
            }
        }
        return false;
    }

    //????
    @Override
    public Task[] displayTasks() {
        Task[] tasks = new Task[taskList.size()];
        Iterator<Task> iterator = taskList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            tasks[i] = iterator.next();
            i++;
        }
        return tasks;

    }

    @Override
    public boolean removeCompletedTasks() {
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isCompletionStatus()) {
                taskList.remove(task);
            }
        }
        return true;
    }
    
    @Override
    public Task[] sortTasksByName() {
        Task[] tasks = displayTasks();
        for (int i = 0; i < tasks.length; i++) {
            for (int j = 0; j < tasks.length - 1; j++) {
                if (tasks[j].getTaskName().compareTo(tasks[j + 1].getTaskName()) > 0) {
                    Task temp = tasks[j];
                    tasks[j] = tasks[j + 1];
                    tasks[j + 1] = temp;
                }
            }
        }
        return tasks;
    }

}
