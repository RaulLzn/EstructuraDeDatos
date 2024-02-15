package raul.Model.array;

import raul.Model.util.Iterator.Iterator;
import raul.Model.util.array.AbstractArray;
import raul.Model.util.collection.Collection;

import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a collection of elements that can be accessed by an index.
 * @param <E>
 */
public class Array<E> extends AbstractArray<E> {


    private E[] elements;

    /**
     * @param dimension
     */
    public Array(int dimension) {
        this.elements = (E[]) new Object[dimension];
    }

    public Array(E[] elements) {
        this.elements = elements;
    }

    /**
     * Inserts the specified element at the clear position in this collection.
     *
     * @param element The element to be inserted.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(E element) {
        try {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    elements[i] = element;
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
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
        if(index < 0 || index > elements.length || array == null) {
            return false;
        }
        int remainingSpace = elements.length - index;
        if (remainingSpace < array.length) {
            int spaceForIndex = 0;
            for (int ii = 0; ii < remainingSpace; ii++) {
                spaceForIndex++;
            }
            for (int ii = 0; ii < spaceForIndex; ii++) {
                elements[index] = array[ii];
                index++;
            }
            return false;
        }
        try {
            int it = 0;
            for (int ii = 0; ii < array.length; ii++) {
                elements[index] = array[ii];
                index++;
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
        try {
            Iterator<E> collectionIterator = collection.iterator();
            int counter = 0;
            int restSpaces = elements.length - index;
            if (restSpaces >= collection.size()) {
                for (int i = index; counter < collection.size(); i++) {
                    elements[i] = collectionIterator.next();
                    counter++;
                }
                return true;
            } else {
                for (int i = index; counter < elements.length; i++) {
                    elements[i] = collectionIterator.next();
                    counter++;
                }
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Moves all the elements to the left.
     */
    @Override
    public void defragment() {
        try {
            int noNullCount = 0;
            for (int ii = 0; ii < elements.length; ii++) {
                if (elements[ii] != null) {
                    elements[noNullCount++] = elements[ii];
                }
            }
            for (int ii = noNullCount; ii < elements.length; ii++) {
                elements[ii] = null;
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
    }

    /**
     * Returns the element at the specified position in this collection.
     *
     * @param index The index of the element to be returned.
     * @return The element at the specified position.
     */
    @Override
    public E get(int index) {
        try {
            if (index < elements.length && index >= 0) {
                return elements[index];
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        try {
            for (int ii = 0; ii < elements.length; ii++) {
                if ((elements[ii] == null && element == null) || (elements[ii] != null && elements[ii].equals(element))) {
                    return ii;
                }
            }
            return -1;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this collection.
     *
     * @param element The element to search for.
     * @return The index of the last occurrence of the specified element in this collection, or -1 if not found.
     */
    @Override
    public int lastIndexOf(E element) {
        try {
            for (int ii = elements.length - 1; ii >= 0; ii--) {
                if ((elements[ii] == null && element == null) || (elements[ii] != null && elements[ii].equals(element))) {
                    return ii;
                }
            }
            return -1;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this collection.
     *
     * @param index The index of the element to be removed.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(int index) {
        try {
            if (index < 0 || index >= elements.length) {
                return false;
            }
            elements[index] = null;
            defragment();
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        try {
            for (int ii = 0; ii < elements.length; ii++) {
                if (elements[ii] != null && filter.test(elements[ii])) {
                    elements[ii] = null;
                    defragment();
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        if (from < 0 || to > elements.length || from > to) {
            return false;
        }
        try {
            for (int ii = from; ii < to; ii++) {
                elements[ii] = null;
                defragment();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        if (newDimension < 0) {
            return false;
        }
        try {
            E[] newElements = (E[]) new Object[newDimension];
            for (int ii = 0; ii < newDimension; ii++) {
                if (ii < elements.length) {
                    newElements[ii] = elements[ii];
                }
            }
            elements = newElements;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        if (index < 0 || index > elements.length){
            return false;
        }
        try {
            elements[index] = element;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
            for (int ii = 0; ii < elements.length; ii++) {
                elements[ii] = null;
            }
            defragment();
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
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
        try {
            for (E element1 : elements) {
                if (element1.equals(element)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
        try {
            for (E e : array) {
                if (!contains(e)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
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
        try {
            Iterator<E> collectionIterator = collection.iterator();
            while (collectionIterator.hasNext()) {
                E element = collectionIterator.next();
                if (!contains(element)) {
                    return false;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return true;
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        for (E e : elements) {
            if (e != null) {
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
        try {
            E[] newElements = (E[]) new Object[elements.length];
            for (int ii = 0; ii < elements.length; ii++) {
                newElements[ii] = elements[elements.length - 1 - ii];
            }
            elements = newElements;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Gets the size of the collection.
     *
     * @return the number of elements in this collection.
     */
    @Override
    public int size() {
        return elements.length;
    }

    /**
     * For each element in the iterator, executes the specified action.
     *
     * @param action the action to be executed for each element.
     */
    @Override
    public void forEach(Function<E, Void> action) {
        for (E e : elements) {
            action.apply(e);
        }
    }

    /**
     * Gets an iterator over the elements in the collection.
     *
     * @return an iterator over the elements in the collection.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public E next() {
                return elements[index++];
            }
        };
    }

}
