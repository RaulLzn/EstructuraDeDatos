package raul.Model.TaskManager.TaskManager;

import raul.Model.TaskManager.Task;

public interface TaskManagerInterface {
    
    /**
     * Agrega  una  nueva  tarea  a  la  lista,  ordenada por  prioridad  (la prioridad más alta primero).
     * @param taskName
     * @param priority
     * @return true si la tarea fue agregada, false si ya existe.
     */
    public boolean addTask(Task taskName, int priority); 

    /**
     * Elimina una tarea por su nombre.
     * @param taskName
     * @return true si la tarea fue eliminada, false si no existe.
     */
    public boolean removeTask(String taskName);

    /**
     * Marca una tarea como completada.
     * @param taskName
     * @return true si la tarea fue marcada, false si no existe.
     */
    public boolean markCompleted(String taskName);

    /**
     * Retorna un Arreeglo de tareas.
     * @return Arreglo de tareas.
     */
    public Task[] displayTasks();

    /**
     * Elimina todas las tareas completadas de la lista.
     * @return true si las tareas fueron eliminadas, false si no hay tareas completadas.
     */
    public boolean removeCompletedTasks();

    /**
     * Ordena las  tareas alfabéticamente por nombre y  retorna un arreglo  con ellas.
     * @return Arreglo de tareas ordenadas alfabéticamente.
     */
    public Task[] sortTasksByName();

}
