package raul.Model.TaskManager.TaskManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raul.Model.TaskManager.Task;
import raul.Model.array.Array;

import static org.junit.jupiter.api.Assertions.*;

//El test de esta clase se encuentra en src.test.java.raul.Model.TaskManager.TaskManagerTest


class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void testAddTask() {
        assertTrue(taskManager.addTask(new Task("Tarea 1", 3, false), 3));
        assertTrue(taskManager.addTask(new Task("Tarea 2", 1, false), 1));
        assertTrue(taskManager.addTask(new Task("Tarea 3", 2, false), 2));

        Task[] tasks = taskManager.displayTasks();
        assertEquals(3, tasks.length);
        assertEquals("Tarea 2", tasks[0].getTaskName());
        assertEquals("Tarea 3", tasks[1].getTaskName());
        assertEquals("Tarea 1", tasks[2].getTaskName());

        // Agregar una tarea con el mismo nombre de una tarea existente
        assertFalse(taskManager.addTask(new Task("Tarea 1", 4, false), 4));
        tasks = taskManager.displayTasks();
        assertEquals(3, tasks.length);
    }

    @Test
    void testRemoveTask() {
        taskManager.addTask(new Task("Tarea 1", 3, false), 3);
        taskManager.addTask(new Task("Tarea 2", 1, false), 1);
        taskManager.addTask(new Task("Tarea 3", 2, false), 2);

        assertTrue(taskManager.removeTask("Tarea 1"));

        Task[] tasks = taskManager.displayTasks();
        assertEquals(2, tasks.length);
        assertEquals("Tarea 2", tasks[0].getTaskName());
        assertEquals("Tarea 3", tasks[1].getTaskName());
    }

    @Test
    void testMarkCompleted() {
        //Acordarse que el metodo Add ordena las tareas por prioridad al momento de agregarlas, terminar el test con las tareas ordenadas.
        assertTrue(taskManager.addTask(new Task("Tarea 1", 3, false), 3));
        assertTrue(taskManager.addTask(new Task("Tarea 2", 1, false), 1));
        assertTrue(taskManager.addTask(new Task("Tarea 3", 2, false), 2));

        assertTrue(taskManager.markCompleted("Tarea 2"));

        Task[] tasks = taskManager.displayTasks();
        assertTrue(tasks[0].isCompletionStatus());
        assertFalse(tasks[1].isCompletionStatus());
        assertFalse(tasks[2].isCompletionStatus());
    }

    @Test
    void testDisplayTasks() {
        Task task1 = new Task("Tarea 1", 3, false);
        Task task2 = new Task("Tarea 2", 1, false);
        Task task3 = new Task("Tarea 3", 2, false);

        taskManager.addTask(task1, 3);
        taskManager.addTask(task2, 1);
        taskManager.addTask(task3, 2);

        Task[] displayedTasks = taskManager.displayTasks();

        Task[] expectedTasks = {task2, task3, task1};

        assertArrayEquals(expectedTasks, displayedTasks);
    }

    @Test
    void testRemoveCompletedTasks() {
        assertTrue(taskManager.addTask(new Task("Tarea 1", 3, true), 3));
        assertTrue(taskManager.addTask(new Task("Tarea 2", 1, false), 1));
        assertTrue(taskManager.addTask(new Task("Tarea 3", 2, true), 2));

        Task[] tasksBefore = taskManager.displayTasks();
        assertEquals(3, tasksBefore.length);

        assertTrue(taskManager.removeCompletedTasks());

        Task[] tasksAfter = taskManager.displayTasks();
        assertEquals(1, tasksAfter.length);
        assertEquals("Tarea 2", tasksAfter[0].getTaskName());
    }

    @Test
    void testSortTasksByName() {
        taskManager.addTask(new Task("Tarea 2", 3, false), 3);
        taskManager.addTask(new Task("Tarea 1", 1, false), 1);
        taskManager.addTask(new Task("Tarea 3", 2, false), 2);

        Task[] sortedTasks = taskManager.sortTasksByName();

        assertEquals("Tarea 1", sortedTasks[0].getTaskName());
        assertEquals("Tarea 2", sortedTasks[1].getTaskName());
        assertEquals("Tarea 3", sortedTasks[2].getTaskName());
    }




}