package raul.Model.util.priorityqueue;

import raul.Model.util.collection.Collection;
import raul.Model.util.Queue.Queue;

public interface PriorityQueue<E> extends Queue<E> , Collection<E>{

    /**
     * Inserts the specified element at the specified priority.
     * If the priority is greater than the size of the queue,
     * the element will be inserted at the end of the queue.
     *
     * @param element the element to add
     * @return true if the element was added to this queue, else false
     */
    public boolean Insert(int index, E element);
}
