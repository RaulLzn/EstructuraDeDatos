package raul.Model.linkedlist.singly;

import raul.Model.linkedlist.node.singly.LinkedNode;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;
import raul.Model.util.list.AbstractList;
import raul.Model.util.list.List;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Linkedlist<E> extends AbstractList<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private int size;

    public Linkedlist() {
        head = null;
        tail = null;
        size = 0;
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

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element The element to be appended to this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(E element) {
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
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param collection The collection containing elements to be added to this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    @Override
    public boolean add(java.util.Collection<E> collection) {
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
        return false;
    }

    /**
     * Appends all of the elements in the specified collection at the beginning of this list.
     *
     * @param collection The collection containing elements to be added at the beginning of this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    @Override
    public boolean addFirst(java.util.Collection<E> collection) {
        return false;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return The last element of this list.
     */
    @Override
    public E peekLast() {
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
        return null;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * Retrieves and removes the last element of this list.
     *
     * @return The last element of this list.
     */
    @Override
    public E pollLast() {
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
        return null;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param element The element to be removed from this list.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(E element) {
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
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be removed from this list.
     * @return 'true' if the collection elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(java.util.Collection<E> collection) {
        return false;
    }

    /**
     * Removes all of the elements of this list that satisfy the given predicate.
     *
     * @param filter The predicate used to test elements.
     * @return 'true' if elements were removed successfully, otherwise 'false'.
     */
    @Override
    public boolean remove(Predicate<E> filter) {
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
    public boolean replace(java.util.Collection<E> collection, java.util.Collection<E> newCollection, Predicate<E> comparator) {
        return false;
    }

    /**
     * Retains only the elements in this list that are contained in the specified array.
     *
     * @param array The array containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    @Override
    public boolean retain(E[] array) {
        return false;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    @Override
    public boolean retain(java.util.Collection<E> collection) {
        return false;
    }

    /**
     * Replaces the specified element by a new element in this list. Only the first occurrence is replaced.
     *
     * @param index   The index of the element to be replaced.
     * @param element The new element to replace the old one.
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */
    @Override
    public boolean set(int index, E element) {
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
        return false;
    }

    /**
     * Returns a sub list of this list between the specified "from" and "to" indices.
     *
     * @param from The starting index of the sub list.
     * @param to   The ending index of the sub list.
     * @return A sub list containing elements from the specified range.
     */
    @Override
    public List<E> subList(int from, int to) {
        return null;
    }

    /**
     * Returns an array containing all of the elements in this list.
     *
     * @return An array containing all of the elements in this list.
     */
    @Override
    public E[] toArray() {
        return null;
    }
}
