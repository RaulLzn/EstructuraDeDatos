package raul.Model.TaskManager.TaskManager;

import raul.Model.TaskManager.Task;
import raul.Model.array.Array;
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
        Array<Task> tasksArray = new Array<>(taskList.size());
        Iterator<Task> iterator = taskList.iterator();
        int ii = 0;
        while (iterator.hasNext()) {
            tasksArray.add(iterator.next());
            ii++;
        }
        Task[] tasks = new Task[tasksArray.size()];
        for (int jj = 0; jj < tasksArray.size(); jj++) {
            tasks[jj] = tasksArray.get(jj);
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
        for (int ii = 0; ii < tasks.length; ii++) {
            for (int jj = 0; jj < tasks.length - 1; jj++) {
                if (tasks[jj].getTaskName().compareTo(tasks[jj + 1].getTaskName()) > 0) {
                    Task temp = tasks[jj];
                    tasks[jj] = tasks[jj + 1];
                    tasks[jj + 1] = temp;
                }
            }
        }
        return tasks;
    }

}
