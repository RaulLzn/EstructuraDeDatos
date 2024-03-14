package raul.Model.queue.list;

import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.Queue.AbstractQueue;
import raul.Model.util.collection.Collection;

import java.util.function.Function;

public class Queue<E> extends AbstractQueue<E> {


    LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    /**
     * @return 
     */
    @Override
    public E peek() {
        return queue.peek();
    }

    /**
     * @return 
     */
    @Override
    public E extract() {
        return queue.poll();
    }

    /**
     * @param element 
     * @return
     */
    @Override
    public boolean insert(E element) {
        return queue.add(element);
    }

    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    @Override
    public boolean clear() {
        return queue.clear();
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
        return queue.contains(element);
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
        return queue.contains(array);
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
        return queue.contains(collection);
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Redistributes the elements in the collection in reverse order.
     *
     * @return 'true' if the collection was reversed successfully, otherwise
     * 'false'.
     */
    @Override
    public boolean reverse() {
        return queue.reverse();
    }

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * For each element in the iterator, executes the specified action.
     *
     * @param action the action to be executed for each element.
     */
    @Override
    public void forEach(Function<E, Void> action) {
        queue.forEach(action);
    }

    /**
     * Gets an iterator over the elements in the iterator.
     *
     * @return an iterator over the elements in the iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }
}
