package raul.Model.priorityqueue;

import raul.Model.array.Array;
import raul.Model.queue.list.Queue;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;
import raul.Model.util.priorityqueue.AbstractPriorityQueue;

import java.util.function.Function;

public class PriorityQueue<E> extends AbstractPriorityQueue<E> {

    Array<Queue<E>> priorityQueue;
    int priorities;

    public PriorityQueue(int priorities) {
        this.priorities = priorities;
        priorityQueue = new Array<>(priorities);
        for (int i = 0; i < priorities; i++) {
            priorityQueue.set(i, new Queue<>());
        }
    }

    /**
     * Inserts the specified element at the specified priority.
     * If the priority is greater than the size of the queue,
     * the element will be inserted at the end of the queue.
     *
     * @param index
     * @param element the element to add
     * @return true if the element was added to this queue, else false
     */
    @Override
    public boolean Insert(int index, E element) {
        if (index < 0 || index >= priorities) {
            return false;
        }
        return priorityQueue.get(index).insert(element);
    }

    /**
     * Allows you to retrieve the value at the front of a queue without actually removing it
     *
     * @return the value at the front of the queue.
     */
    @Override
    public E peek() {
        for (int ii = 0; ii < priorities; ii++) {
            if (!priorityQueue.get(ii).isEmpty()) {
                return priorityQueue.get(ii).peek();
            }
        }
        return null;
    }

    /**
     * Allows you to retrieve and remove the value at the front of a queue
     *
     * @return the value at the front of the queue.
     */
    @Override
    public E extract() {
        for (int ii = 0; ii < priorities; ii++) {
            if (!priorityQueue.get(ii).isEmpty()) {
                return priorityQueue.get(ii).extract();
            }
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
        return priorityQueue.get(priorities - 1).insert(element);
    }

    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    @Override
    public boolean clear() {
        for (int ii = 0; ii < priorities; ii++) {
            priorityQueue.get(ii).clear();
        }
        return true;
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
        for (int ii = 0; ii < priorities; ii++) {
            if (priorityQueue.get(ii).contains(element)) {
                return true;
            }
        }
        return false;
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
        for (int ii = 0; ii < priorities; ii++) {
            if (priorityQueue.get(ii).contains(array)) {
                return true;
            }
        }
        return false;
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
        for (int ii = 0; ii < priorities; ii++) {
            if (priorityQueue.get(ii).contains(collection)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        for (int ii = 0; ii < priorities; ii++) {
            if (!priorityQueue.get(ii).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Redistributes the elements in the collection in reverse order.
     *
     * @return 'true' if the collection was reversed successfully, otherwise
     * 'false'.
     */
    @Override
    public boolean reverse() {
        for (int ii = 0; ii < priorities; ii++) {
            priorityQueue.get(ii).reverse();
        }
        return true;
    }

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        int size = 0;
        for (int ii = 0; ii < priorities; ii++) {
            size += priorityQueue.get(ii).size();
        }
        return size;
    }

    /**
     * For each element in the iterator, executes the specified action.
     *
     * @param action the action to be executed for each element.
     */
    @Override
    public void forEach(Function<E, Void> action) {
        for (int ii = 0; ii < priorities; ii++) {
            priorityQueue.get(ii).forEach(action);
        }
    }

    /**
     * Gets an iterator over the elements in the iterator.
     *
     * @return an iterator over the elements in the iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            Iterator<E> iterator = priorityQueue.get(index).iterator();

            @Override
            public boolean hasNext() {
                if (iterator.hasNext()) {
                    return true;
                }
                for (int ii = index + 1; ii < priorities; ii++) {
                    if (!priorityQueue.get(ii).isEmpty()) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                if (iterator.hasNext()) {
                    return iterator.next();
                }
                for (int ii = index + 1; ii < priorities; ii++) {
                    if (!priorityQueue.get(ii).isEmpty()) {
                        index = ii;
                        iterator = priorityQueue.get(ii).iterator();
                        return iterator.next();
                    }
                }
                return null;
            }
        };
    }


}
