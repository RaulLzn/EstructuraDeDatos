package raul.Model.util.iterable;

import java.util.function.Function;

import raul.Model.util.Iterator.Iterator;

public interface Iterable<E> {

    /**
     * For each element in the iterator, executes the specified action.
     * @param action the action to be executed for each element.
     */
    public void forEach(Function<E, Void> action);

    /**
     * Gets an iterator over the elements in the iterator.
     * @return an iterator over the elements in the iterator.
     */
    public Iterator<E> iterator();

}