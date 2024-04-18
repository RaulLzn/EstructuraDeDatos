package raul.Model.util.Queue;

import raul.Model.util.collection.Collection;

public interface Queue<E> extends Collection<E>{

    /**
     * Allows you to retrieve the value at the front of a queue without actually removing it
     *
     * @return the value at the front of the queue.
     */
    public E peek();

    /**
     * Allows you to retrieve and remove the value at the front of a queue
     *
     * @return the value at the front of the queue.
     */
    public E extract();

    /**
     * Allows you to insert a value at the end of a queue
     *
     * @param element the value to add to the back of the queue.
     * @return 'true' if the value was inserted successfully, otherwise 'false'.
     */
    public boolean insert(E element);

}
