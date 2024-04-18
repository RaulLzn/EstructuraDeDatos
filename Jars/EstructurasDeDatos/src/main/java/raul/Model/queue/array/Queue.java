package raul.Model.queue.array;

import raul.Model.array.Array;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.Queue.AbstractQueue;
import raul.Model.util.collection.Collection;
import java.util.function.Function;

public class Queue<E> extends AbstractQueue<E> {

    Array<E> queue;

    int head ;
    int tail ;
    int capacidad;

    public Queue(int capacidad) {
        queue = new Array<>(capacidad);
        this.capacidad = capacidad;
        head = 0;
        tail = 0;
    }

    /**
     * Allows you to retrieve the value at the front of a queue without actually removing it
     *
     * @return the value at the front of the queue.
     */
    @Override
    public E peek() {
        try {
            return queue.get(head);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Allows you to retrieve and remove the value at the front of a queue
     *
     * @return the value at the front of the queue.
     */
    @Override
    public E extract() {
        E element = queue.get(head);
        if(queue.remove(head) && element != null){
            head %= capacidad;
            return element;
        }
        return null;

    }

    /**
     * Allows you to insert a value at the end of a queue
     *
     * @param element the value to add to the back of the queue.
     * @return 'true' if the value was inserted successfully, otherwise 'false'.
     */
    @Override
    public boolean insert(E element) {
        if (queue.add(element)) {
            tail = (tail+1)%capacidad;
            return true;
        }
        return false;
    }

    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    @Override
    public boolean clear() {
        try {
            queue.clear();
            head = 0;
            tail = 0;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determines if the collection contains the specified element.
     *
     * @param element the element to search for.
     * @return 'true' if the collection contains the specified element, otherwise
     * 'false'.
     */
    @Override
    public boolean contains(E element) {
        try {
            return queue.contains(element);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determines if the collection contains the specified elements in the array.
     *
     * @param array the array containing elements to be searched for in this
     *              collection.
     * @return 'true' if the collection contains the specified elements in the
     * array, otherwise 'false'.
     */
    @Override
    public boolean contains(E[] array) {
        try {
            return queue.contains(array);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determines if the collection contains the specified elements.
     *
     * @param collection the collection containing elements to be searched for in
     *                   this collection.
     * @return 'true' if the collection contains the specified elements, otherwise
     * 'false'.
     */
    @Override
    public boolean contains(Collection<E> collection) {
        try {
            return queue.contains(collection);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        try {
            return queue.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Redistributes the elements in the collection in reverse order.
     *
     * @return 'true' if the collection was reversed successfully, otherwise
     * 'false'.
     */
    @Override
    public boolean reverse() {
        try {
            return queue.reverse();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        try {
            return queue.size();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * For each element in the iterator, executes the specified action.
     *
     * @param action the action to be executed for each element.
     */
    @Override
    public void forEach(Function<E, Void> action) {
        try {
            queue.forEach(action);
        } catch (Exception e) {
        }
    }

    /**
     * Gets an iterator over the elements in the iterator.
     *
     * @return an iterator over the elements in the iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int count = 0;
            int apuntador = head;
            @Override
            public boolean hasNext() {
                return count++ < queue.size();
            }

            @Override
            public E next() {
                if (apuntador >= capacidad) {
                    apuntador=0;
                }
                return queue.get(apuntador++);
            }
        };
    }
}
