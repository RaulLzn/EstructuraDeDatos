package raul.Model.linkedlist.singly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedlistTest {

    @Test
    void clear() {
    }

    @Test
    void contains() {
    }

    @Test
    void testContains() {
    }

    @Test
    void testContains1() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void reverse() {
    }

    @Test
    void size() {
    }

    @Test
    void forEach() {
    }

    @Test
    void iterator() {
    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
        Linkedlist<Integer> list = new Linkedlist<>();
        assertTrue(list.add(23));
        assertTrue(list.add(30));
        assertTrue(list.add(20));
        assertTrue(list.add((Integer) null));
        assertEquals(4, list.size());

        Object[] expected = {23, 30, 20, null};

        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            assertEquals(it.next(), list.get(it.nextIndex() - 1));
        }
    }

    @Test
    void testAdd1() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void testAddFirst() {
    }

    @Test
    void testAddFirst1() {
    }

    @Test
    void peek() {
    }

    @Test
    void peekLast() {
    }

    @Test
    void peekArray() {
    }

    @Test
    void peekLastArray() {
    }

    @Test
    void peekCollection() {
    }

    @Test
    void peekLastCollection() {
    }

    @Test
    void poll() {
    }

    @Test
    void pollLast() {
    }

    @Test
    void pollArray() {
    }

    @Test
    void pollLastArray() {
    }

    @Test
    void pollCollection() {
    }

    @Test
    void pollLastCollection() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void testRemove1() {
    }

    @Test
    void testRemove2() {
    }

    @Test
    void replace() {
    }

    @Test
    void testReplace() {
    }

    @Test
    void testReplace1() {
    }

    @Test
    void retain() {
    }

    @Test
    void testRetain() {
    }

    @Test
    void set() {
    }

    @Test
    void sort() {
    }

    @Test
    void subList() {
    }

    @Test
    void toArray() {
    }
}