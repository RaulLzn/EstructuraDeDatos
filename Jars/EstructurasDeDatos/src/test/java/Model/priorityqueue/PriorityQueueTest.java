package Model.priorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raul.Model.priorityqueue.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    public void setUp() {
        priorityQueue = new PriorityQueue<>(3); // Crear una cola de prioridad con 3 prioridades
    }

    @Test
    public void testInsert() {
        assertTrue(priorityQueue.Insert(0, 10)); // Insertar en la prioridad 0
        assertTrue(priorityQueue.Insert(1, 20)); // Insertar en la prioridad 1
        assertTrue(priorityQueue.Insert(2, 30)); // Insertar en la prioridad 2
        assertFalse(priorityQueue.Insert(3, 40)); // Intentar insertar en una prioridad fuera de rango
    }

    @Test
    public void testPeek() {
        priorityQueue.Insert(0, 10);
        priorityQueue.Insert(1, 20);
        priorityQueue.Insert(2, 30);
        priorityQueue.Insert(0, 40);
        priorityQueue.Insert(1, 50);
        assertEquals(10, (int) priorityQueue.peek()); // Comprobar el elemento en la cabeza de la cola de prioridad
        assertEquals(10, (int) priorityQueue.peek()); // Comprobar que el elemento en la cabeza de la cola de prioridad no cambia
    }

    @Test
    public void testExtract() {
        assertNull(priorityQueue.extract());
        priorityQueue.Insert(0, 10);
        priorityQueue.Insert(1, 20);
        priorityQueue.Insert(2, 30);
        Integer extractedValue1 = priorityQueue.extract();
        assertNotNull(extractedValue1); // Verificar que el valor extraído no es nulo
        assertEquals(10, (int) extractedValue1); // Extraer el primer elemento de la cola de prioridad
        Integer extractedValue2 = priorityQueue.extract();
        assertNotNull(extractedValue2); // Verificar que el valor extraído no es nulo
        assertEquals(20, (int) extractedValue2);
    }

    @Test
    public void testInsertNoPriority() {
        assertTrue(priorityQueue.insert(40)); // Insertar un elemento sin prioridad (se insertará en la prioridad más baja)
    }

    @Test
    public void testClear() {
        priorityQueue.Insert(0, 10);
        priorityQueue.Insert(1, 20);
        priorityQueue.Insert(2, 30);
        assertTrue(priorityQueue.clear()); // Limpiar la cola de prioridad
        assertTrue(priorityQueue.isEmpty()); // Verificar que la cola de prioridad esté vacía después de borrar
    }

    @Test
    public void testContains() {
        priorityQueue.Insert(0, 10);
        priorityQueue.Insert(1, 20);
        priorityQueue.Insert(2, 30);
        assertTrue(priorityQueue.contains(20)); // Verificar que la cola de prioridad contenga un elemento específico
        assertFalse(priorityQueue.contains(40)); // Verificar que la cola de prioridad no contenga un elemento que no está presente
    }

    @Test
    public void testSize() {
        priorityQueue.Insert(0, 10);
        priorityQueue.Insert(1, 20);
        priorityQueue.Insert(2, 30);
        assertEquals(3, priorityQueue.size()); // Verificar el tamaño de la cola de prioridad
    }


}