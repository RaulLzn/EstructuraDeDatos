package Model.queue.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raul.Model.queue.array.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> cola;

    @BeforeEach
    public void setUp() {
        cola = new Queue<>(5);
    }

    @Test
    public void testPeek() {
        cola.insert(2);
        cola.insert(3);
        cola.insert(4);
        assertEquals(2, cola.peek());
    }

    @Test
    public void testExtract() {
        cola.insert(1);
        cola.insert(2);
        cola.insert(3);
        cola.insert(4);
        assertEquals(1, cola.extract());
        assertEquals(2, cola.peek());
    }

    @Test
    public void testInsert() {
        assertTrue(cola.insert(1));
        assertTrue(cola.insert(2));
        assertEquals(1, cola.peek());
    }

    @Test
    public void testClear() {
        cola.insert(1);
        cola.insert(2);
        assertTrue(cola.clear());
        assertTrue(cola.isEmpty());
    }

    @Test
    public void testContains() {
        cola.insert(1);
        cola.insert(2);
        assertTrue(cola.contains(1));
        assertFalse(cola.contains(3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(cola.isEmpty());
        cola.insert(1);
        assertFalse(cola.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, cola.size());
        cola.insert(1);
        cola.insert(2);
        assertEquals(2, cola.size());
    }
}