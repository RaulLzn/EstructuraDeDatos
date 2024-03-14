package raul.Model.queue.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testInsert() {
        assertTrue(queue.insert(1));
        assertEquals(1, queue.size());
    }

    @Test
    public void testPeek() {
        queue.insert(1);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.size()); // Ensure size remains unchanged
    }

    @Test
    public void testExtract() {
        queue.insert(1);
        queue.insert(2);
        assertEquals(1, queue.extract());
        assertEquals(1, queue.size());
        assertEquals(2, queue.extract());
        assertEquals(0, queue.size());
    }

    @Test
    public void testClear() {
        queue.insert(1);
        assertTrue(queue.clear());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testContains() {
        queue.insert(1);
        assertTrue(queue.contains(1));
        assertFalse(queue.contains(2));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.insert(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testReverse() {
        queue.insert(1);
        queue.insert(2);
        queue.reverse();
        assertEquals(2, queue.extract());
        assertEquals(1, queue.extract());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.insert(1);
        assertEquals(1, queue.size());
    }

}