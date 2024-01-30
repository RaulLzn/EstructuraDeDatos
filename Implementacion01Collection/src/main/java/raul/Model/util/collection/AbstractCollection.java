package raul.Model.util.collection;


import raul.Model.util.Iterator.Iterator;

public abstract class AbstractCollection<E> implements Collection<E>, Cloneable {

    protected abstract E[] getInternalCollection();

    public boolean clear() {
        E[] internalCollection = getInternalCollection();
        boolean trueClear = internalCollection.length > 0;
        for (int i = 0; i < internalCollection.length; i++) {
            internalCollection[i] = null;
        }
        return trueClear;
    }

    public boolean contains(E element) {
        E[] internalCollection = getInternalCollection();
        for (E e : internalCollection) {
            if ((e == null && element == null) || (e != null && e.equals(element))) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(E[] array) {
        E[] internalCollection = getInternalCollection();
        for (E e : array) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

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

    public boolean isEmpty() {
        E[] internalCollection = getInternalCollection();
        return internalCollection.length == 0;
    }

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

    @Override
    public AbstractCollection<E> clone() {
        try {
            return (AbstractCollection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
