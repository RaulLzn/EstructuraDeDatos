package raul.Model.util.collection;

import raul.Model.util.Iterator.Iterator;

/**
 * This abstract class provides a partial implementation of the Collection interface.
 * It includes common functionality and allows concrete Collection classes to implement specific details.
 * @param <E> The type of elements in the collection.
 */
public abstract class AbstractCollection<E> implements Collection<E>, Cloneable {

    /**
     * Protected method to be implemented by concrete classes, providing access to the internal collection.
     * @return The internal array or collection.
     */
    protected abstract E[] getInternalCollection();

    /**
     * Clears all elements from the collection.
     * @return 'true' if the collection was cleared successfully, otherwise 'false'.
     */
    public boolean clear() {
        E[] internalCollection = getInternalCollection();
        boolean trueClear = internalCollection.length > 0;
        for (int i = 0; i < internalCollection.length; i++) {
            internalCollection[i] = null;
        }
        return trueClear;
    }

    /**
     * Checks if the collection contains a specific element.
     * @param element The element to search for.
     * @return 'true' if the collection contains the specified element, otherwise 'false'.
     */
    public boolean contains(E element) {
        E[] internalCollection = getInternalCollection();
        for (E e : internalCollection) {
            if ((e == null && element == null) || (e != null && e.equals(element))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the collection contains all elements from a specified array.
     * @param array The array containing elements to be searched for in this collection.
     * @return 'true' if the collection contains all specified elements, otherwise 'false'.
     */
    public boolean contains(E[] array) {
        E[] internalCollection = getInternalCollection();
        for (E e : array) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the collection contains all elements from another collection.
     * @param collection The collection containing elements to be searched for in this collection.
     * @return 'true' if the collection contains all specified elements, otherwise 'false'.
     */
    public boolean contains(Collection<E> collection) {
        Iterator<E> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {
            E element = collectionIterator.next();
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the collection is empty.
     * @return 'true' if the collection contains no elements, otherwise 'false'.
     */
    public boolean isEmpty() {
        E[] internalCollection = getInternalCollection();
        return internalCollection.length == 0;
    }

    /**
     * Reverses the order of elements in the collection.
     * @return 'true' if the collection was reversed successfully, otherwise 'false'.
     */
    public boolean reverse() {
        E[] internalCollection = getInternalCollection();
        int size = internalCollection.length;
        for (int i = 0; i < size / 2; i++) {
            E temp = internalCollection[i];
            internalCollection[i] = internalCollection[size - i - 1];
            internalCollection[size - i - 1] = temp;
        }
        return true;
    }

    /**
     * Clones the collection.
     * @return A cloned instance of the AbstractCollection.
     */
    @Override
    public AbstractCollection<E> clone() {
        try {
            return (AbstractCollection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
