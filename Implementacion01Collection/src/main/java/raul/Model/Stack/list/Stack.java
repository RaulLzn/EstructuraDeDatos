package raul.Model.Stack.list;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;
import raul.Model.util.stack.AbstractStack;

import java.util.function.Function;

public class Stack<E> extends AbstractStack<E> {

    LinkedList<E> stack;

    public Stack() {
        stack = new LinkedList<>();
    }


    /**
     * @return 
     */
    @Override
    public boolean clear() {
        return stack.clear();
    }

    /**
     * @param element the element to search for. 
     * @return
     */
    @Override
    public boolean contains(E element) {
        return stack.contains(element);
    }

    /**
     * @param array the array containing elements to be searched for in this 
     *              collection.
     * @return
     */
    @Override
    public boolean contains(E[] array) {
        return stack.contains(array);
    }

    /**
     * @param collection the collection containing elements to be searched for in 
     *                   this collection.
     * @return
     */
    @Override
    public boolean contains(Collection<E> collection) {
        return stack.contains(collection);
    }

    /**
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * @return 
     */
    @Override
    public boolean reverse() {
        return stack.reverse();
    }

    /**
     * @return 
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * @param action the action to be executed for each element. 
     */
    @Override
    public void forEach(Function<E, Void> action) {
        stack.forEach(action);
    }

    /**
     * @return 
     */
    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }

    /**
     * @return 
     */
    @Override
    public E peek() {
        return stack.peekLast();
    }

    /**
     * @return 
     */
    @Override
    public E pop() {
        return stack.pollLast();
    }

    /**
     * @param element 
     * @return
     */
    @Override
    public boolean push(E element) {
        return stack.add(element);
    }
}
