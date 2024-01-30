package raul.Model.util.array;

import java.util.logging.Level;
import java.util.logging.Logger;

import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;

import java.util.function.Function;
import java.util.function.Predicate;

public class AbstractArray<E> implements Array<E>, Collection<E>, Cloneable {

    private E[] elements;

    public AbstractArray(int size) {
        this.elements = (E[]) new Object[size];
    }

    /**
     * Inserts the specified element at the clear position in this collection.
     *
     * @param element The element to be inserted.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(E element) {
        for (int ii = 0; ii < elements.length; ii++) {
            try {
                if (elements[ii] == null) {
                    elements[ii] = element;
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
    }

    /**
     * Inserts all of the elements in the specified array into this collection, starting at the specified position.
     *
     * @param index The index at which the specified element is to be inserted.
     * @param array The array containing elements to be added to this collection.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(int index, E[] array) {
        if (index < elements.length && index >= 0 && array.length <= elements.length && (array.length + index) <= elements.length) {
            try {
                for (int i = 0; i < array.length; i++) {
                    elements[index + i] = array[i];
                }
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    /**
     * Inserts all of the elements in the specified collection into this collection, starting at the specified position.
     *
     * @param index      The index at which the specified element is to be inserted.
     * @param collection The collection containing elements to be added to this collection.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */

    @Override
    public boolean add(int index, Collection<E> collection) {
        Iterator<E> collectionIterator = collection.iterator();
        int i = 0;
        if (index < elements.length && index >= 0 && this.elements.length <= collection.size() && (collection.size() + index) <= elements.length) {
            try {
                while (collectionIterator.hasNext()) {
                    E element = collectionIterator.next();
                    elements[index + i] = element;
                    i++;
                }
                return true;
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            }
        }
        return false;
    }

    /**
     * Moves all the elements to the left.
     */
    @Override
    public void defragment() {

    }

    /**
     * Returns the element at the specified position in this collection.
     *
     * @param index The index of the element to be returned.
     * @return The element at the specified position.
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this collection.
     *
     * @param element The element to search for.
     * @return The index of the first occurrence of the specified element in this collection, or -1 if not found.
     */
    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this collection.
     *
     * @param element The element to search for.
     * @return The index of the last occurrence of the specified element in this collection, or -1 if not found.
     */
    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    /**
     * Removes the element at the specified position in this collection.
     *
     * @param index The index of the element to be removed.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(int index) {
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this collection, if it is present.
     *
     * @param filter The filter to apply to each element to determine if it should be removed.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(Predicate<E> filter) {
        return false;
    }

    /**
     * Removes from this collection all of the elements whose index is between "from" (inclusive) and "to" (exclusive).
     *
     * @param from The initial index of the range to be removed.
     * @param to   The final index of the range to be removed.
     * @return 'true' if the elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(int from, int to) {
        return false;
    }

    /**
     * Resizes the array to the specified dimension. If the specified dimension is less than the current dimension, the array is truncated.
     *
     * @param newDimension The new dimension of the array.
     * @return 'true' if the array was resized successfully, otherwise 'false'.
     */
    @Override
    public boolean dimension(int newDimension) {
        return false;
    }

    /**
     * Replaces the element at the specified position in this collection with the specified element.
     *
     * @param index   The index of the element to replace.
     * @param element The element to be stored at the specified position.
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean set(int index, E element) {
        return false;
    }

    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    @Override
    public boolean clear() {
        return false;
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
        return false;
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Redistributes the elements in the collection in reverse order.
     *
     * @return 'true' if the collection was reversed successfully, otherwise
     * 'false'.
     */
    @Override
    public boolean reverse() {
        return false;
    }

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * For each element in the iterator, executes the specified action.
     *
     * @param action the action to be executed for each element.
     */
    @Override
    public void forEach(Function<E, Void> action) {

    }

    /**
     * Gets an iterator over the elements in the collection.
     *
     * @return an iterator over the elements in the collection.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public AbstractArray<E> clone() {
        try {
            return (AbstractArray) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
