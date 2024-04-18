package raul.Model.linkedlist.doubly;

import raul.Model.linkedlist.node.doubly.LinkedNode;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;
import raul.Model.util.list.AbstractList;
import raul.Model.util.list.List;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedList<E> extends AbstractList<E> {

    LinkedNode<E> head;
    LinkedNode<E> tail;

    public LinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    public LinkedList(E element) {
        super();
        add(element);
    }

    public LinkedList(E[] array) {
        super();
        for (E element : array) {
            add(element);
        }
    }

    /**
     * Removes all elements from the collection.
     *
     * @return 'true' if the list was cleared successfully, otherwise 'false'.
     */
    @Override
    public boolean clear() {
        try {
            head = null;
            tail = null;
            size = 0;
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
            LinkedNode<E> current = head;
            while (current != null) {
                if (current.get().equals(element)) {
                    return true;
                }
                current = current.getNext();
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
            for (E element : array) {
                if (!contains(element)) {
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
            boolean found = true;
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!contains(iterator.next())) {
                    found = false;
                    break;
                }
            }
            return found;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Determines if the collection contains any element.
     *
     * @return 'true' if the collection contains any element, otherwise 'false'.
     */
    @Override
    public boolean isEmpty() {
        return head == null && tail == null && size == 0;
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
            LinkedNode<E> current = head;
            LinkedNode<E> temp = null;
            while (current != null) {
                temp = current.getPrevious();
                current.setPrevious(current.getNext());
                current.setNext(temp);
                current = current.getPrevious();
            }
            if (temp != null) {
                head = temp.getPrevious();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Gets an iterator over the elements in the iterator.
     *
     * @return an iterator over the elements in the iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                current = current.getNext();
                return element;
            }
        };
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element The element to be appended to this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(E element) {
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified array to the end of this list.
     *
     * @param array The array containing elements to be added to this list.
     * @return 'true' if the array was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(E[] array) {
        try {
            for (E element : array) {
                add(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param collection The collection containing elements to be added to this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                add(iterator.next());
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Appends the specified element at the beginning of this list.
     *
     * @param element The element to be appended at the beginning of this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    @Override
    public boolean addFirst(E element) {
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified array at the beginning of this list.
     *
     * @param array The array containing elements to be added at the beginning of this list.
     * @return 'true' if the array was added successfully, otherwise 'false'.
     */
    @Override
    public boolean addFirst(E[] array) {
        try {
            for (int i = array.length - 1; i >= 0; i--) {
                addFirst(array[i]);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Appends all of the elements in the specified collection at the beginning of this list.
     *
     * @param collection The collection containing elements to be added at the beginning of this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    @Override
    public boolean addFirst(Collection<E> collection) {
        try {
            LinkedList<E> newList = new LinkedList<>();
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                newList.add(element);
                size++;
            }
            newList.tail.setNext(head);
            this.head = newList.head;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    @Override
    public E peek() {
        try {
            return head.get();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return The last element of this list.
     */
    @Override
    public E peekLast() {
        try {
            return tail.get();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return An array containing the first n elements of the list.
     */
    @Override
    public E[] peekArray(int n) {
        try {
            E[] array = (E[]) new Object[n];
            LinkedNode<E> current = head;
            for (int i = 0; i < n; i++) {
                array[i] = current.get();
                current = current.getNext();
            }
            return array;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return An array containing the last n elements of the list.
     */
    @Override
    public E[] peekLastArray(int n) {
        try {
            E[] array = (E[]) new Object[n];
            LinkedNode<E> current = tail;
            for (int i = n - 1; i >= 0; i--) {
                array[i] = current.get();
                current = current.getPrevious();
            }
            return array;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return A list containing the first n elements of the list.
     */
    @Override
    public List<E> peekCollection(int n) {
        try {
            List<E> list = new LinkedList<>();
            LinkedNode<E> current = head;
            for (int i = 0; i < n; i++) {
                list.add(current.get());
                current = current.getNext();
            }
            return list;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return A list containing the last n elements of the list.
     */
    @Override
    public List<E> peekLastCollection(int n) {
        try {
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            LinkedList<E> save = new LinkedList<>();
            for (int e = 0; e < size - n; e++) {
                previous = current;
                current = current.getNext();
            }
            for (int i = 0; i < n && !(current == head && previous != null); i++) {
                save.add(current.get());
                previous = current;
                current = current.getNext();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    @Override
    public E poll() {
        try {
            if (head == null) {
                return null; // La lista está vacía
            }

            E element = head.get();
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            size--;
            return element;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }

    /**
     * Retrieves and removes the last element of this list.
     *
     * @return The last element of this list.
     */
    @Override
    public E pollLast() {
        try {
            E element = tail.get();
            tail = tail.getPrevious();
            if (tail != null) {
                tail.setNext(null);
            }
            size--;
            return element;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return An array containing the first n elements of the list.
     */
    @Override
    public E[] pollArray(int n) {
        try {
            E[] array = (E[]) new Object[n];
            for (int i = 0; i < n; i++) {
                array[i] = poll();
            }
            return array;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves and removes the last n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return An array containing the last n elements of the list.
     */
    @Override
    public E[] pollLastArray(int n) {
        try {
            LinkedNode<E> current = head;
            for (int e = 0; e < size - n; e++) {
                current = current.getNext();
            }
            LinkedNode<E> newTail = current;
            E[] save = (E[]) new Object[n];
            for (int i = 0; i < n && current != null; i++) {
                save[i] = current.get();
                current = current.getNext();
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                if (size == 1) {
                    head = current;
                    tail = current;
                } else {
                    newTail.setNext(null);
                    this.tail = newTail;
                }
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return A list containing the first n elements of the list.
     */
    @Override
    public List<E> pollCollection(int n) {
        try {
            if (head == null || n <= 0) {
                return null;
            }

            LinkedList<E> resultCollection = new LinkedList<>();
            LinkedNode<E> current = head;
            int count = 0;

            while (current != null && count < n) {
                resultCollection.add(current.get());
                current = current.getNext();
                count++;
            }

            head = current;
            size -= count;
            return resultCollection;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieves and removes the last n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return A list containing the last n elements of the list.
     */
    @Override
    public List<E> pollLastCollection(int n) {
        try {
            List<E> save = new LinkedList<>();
            if (n < size) {
                Iterator<E> it = iterator();
                for (int i = 0; i < size - n; i++) {
                    it.next();
                }
                while (it.hasNext()) {
                    save.add(it.next());
                }

                for (int i = 0; i < n; i++) {
                    pollLast();
                }
            } else {
                save.add(this);
                clear();
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param element The element to be removed from this list.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(E element) {
        try {
            LinkedNode<E> current = head;
            while (current != null) {
                if (current.get().equals(element)) {
                    if (current == head) {
                        head = current.getNext();
                        if (head != null) {
                            head.setPrevious(null);
                        }
                    } else if (current == tail) {
                        tail = current.getPrevious();
                        if (tail != null) {
                            tail.setNext(null);
                        }
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    size--;
                    return true;
                }
                current = current.getNext();
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified array.
     *
     * @param array The array containing elements to be removed from this list.
     * @return 'true' if the array elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(E[] array) {
        try {
            for (E element : array) {
                remove(element);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be removed from this list.
     * @return 'true' if the collection elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                remove(iterator.next());
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Removes all of the elements of this list that satisfy the given predicate.
     *
     * @param filter The predicate used to test elements.
     * @return 'true' if elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(Predicate<E> filter) {
        try {
            LinkedNode<E> current = head;
            while (current != null) {
                if (filter.test(current.get())) {
                    if (current == head) {
                        head = current.getNext();
                        if (head != null) {
                            head.setPrevious(null);
                        }
                    } else if (current == tail) {
                        tail = current.getPrevious();
                        if (tail != null) {
                            tail.setNext(null);
                        }
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    size--;
                }
                current = current.getNext();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param element    The element to be replaced.
     * @param newElement The new element to replace the old one.
     * @param comparator The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        try {
            LinkedNode<E> current = head;
            boolean elementReplaced = false;
            for (int i = 0; i < size; i++) {
                if (comparator.test(current.get()) && current.get().equals(element)) {
                    current.set(newElement);
                    elementReplaced = true;
                }
                current = current.getNext();
            }
            return elementReplaced;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param array      The array containing elements to be replaced.
     * @param newArray   The array containing new elements to replace the old ones.
     * @param comparator The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {
        try {
            for (int i = 0; i < array.length; i++) {
                replace(array[i], newArray[i], comparator);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param collection    The collection containing elements to be replaced.
     * @param newCollection The collection containing new elements to replace the old ones.
     * @param comparator    The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        try {
            if (collection.size() != newCollection.size()) {
                return false;
            }

            boolean replaced = false;
            Iterator<E> iterator = collection.iterator();
            Iterator<E> newIterator = newCollection.iterator();
            while (iterator.hasNext() && newIterator.hasNext()) {
                E element = iterator.next();
                E newElement = newIterator.next();
                if (comparator.test(element)) {
                    replace(element, newElement, e -> e.equals(element));
                    replaced = true;
                }
            }
            return replaced;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Retains only the elements in this list that are contained in the specified array.
     *
     * @param array The array containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    @Override
    public boolean retain(E[] array) {
        try {
            LinkedNode<E> current = head;
            while (current != null) {
                boolean found = false;
                for (E element : array) {
                    if (current.get().equals(element)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    if (current == head) {
                        head = current.getNext();
                        if (head != null) {
                            head.setPrevious(null);
                        }
                    } else if (current == tail) {
                        tail = current.getPrevious();
                        if (tail != null) {
                            tail.setNext(null);
                        }
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    size--;
                }
                current = current.getNext();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    @Override
    public boolean retain(Collection<E> collection) {
        try {
            LinkedNode<E> current = head;
            while (current != null) {
                boolean found = false;
                Iterator<E> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    if (current.get().equals(iterator.next())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    if (current == head) {
                        head = current.getNext();
                        if (head != null) {
                            head.setPrevious(null);
                        }
                    } else if (current == tail) {
                        tail = current.getPrevious();
                        if (tail != null) {
                            tail.setNext(null);
                        }
                    } else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    size--;
                }
                current = current.getNext();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Replaces the specified element by a new element in this list. Only the first occurrence is replaced.
     *
     * @param index   The index of the element to be replaced.
     * @param element The new element to replace the old one.
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean set(E index, E element) {
        if (index == null || element == null) {
            return false;
        }

        LinkedNode<E> current = head;
        while (current != null) {
            if (current.get().equals(index)) {
                current.set(element);
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     *
     * @param toInt The function to extract the integer keys from elements.
     * @return 'true' if the list was sorted successfully, otherwise 'false'.
     */
    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        try {
            for (int i = 0; i < size; i++) {
                LinkedNode<E> current = head;
                for (int j = 0; j < size - 1; j++) {
                    if (toInt.applyAsInt(current.get()) > toInt.applyAsInt(current.getNext().get())) {
                        E temp = current.get();
                        current.set(current.getNext().get());
                        current.getNext().set(temp);
                    }
                    current = current.getNext();
                }
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Returns a sub list of this list between the specified "from" and "to" indices.
     *
     * @param from The starting index of the sub list.
     * @param to   The ending index of the sub list.
     * @return A sub list containing elements from the specified range.
     */
    @Override
    public List<E> subList(E from, E to) {
        LinkedNode<E> current = head;
        LinkedList<E> newList = new LinkedList<>();
        while (current != null && !current.get().equals(from)) {
            current = current.getNext();
        }
        do {
            newList.add(current.get());
            current = current.getNext();
        } while (current.get() != to);
        return newList;
    }

    /**
     * Returns an array containing all of the elements in this list.
     *
     * @return An array containing all of the elements in this list.
     */
    @Override
    public E[] toArray() {
        try {
            E[] array = (E[]) new Object[size];
            LinkedNode<E> current = head;
            for (int i = 0; i < size; i++) {
                array[i] = current.get();
                current = current.getNext();
            }
            return array;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
            return null;
        }
    }
}
