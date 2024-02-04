package raul.Model.util.list;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * Represents a generic list data structure.
 *
 * @param <E> The type of elements stored in the list.
 */
public interface List<E> {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element The element to be appended to this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    boolean add(E element);

    /**
     * Appends all of the elements in the specified array to the end of this list.
     *
     * @param array The array containing elements to be added to this list.
     * @return 'true' if the array was added successfully, otherwise 'false'.
     */
    boolean add(E[] array);

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param collection The collection containing elements to be added to this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    boolean add(Collection<E> collection);

    /**
     * Appends the specified element at the beginning of this list.
     *
     * @param element The element to be appended at the beginning of this list.
     * @return 'true' if the element was added successfully, otherwise 'false'.
     */
    boolean addFirst(E element);

    /**
     * Appends all of the elements in the specified array at the beginning of this list.
     *
     * @param array The array containing elements to be added at the beginning of this list.
     * @return 'true' if the array was added successfully, otherwise 'false'.
     */
    boolean addFirst(E[] array);

    /**
     * Appends all of the elements in the specified collection at the beginning of this list.
     *
     * @param collection The collection containing elements to be added at the beginning of this list.
     * @return 'true' if the collection was added successfully, otherwise 'false'.
     */
    boolean addFirst(Collection<E> collection);

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    E peek();

    /**
     * Retrieves, but does not remove, the last element of this list.
     *
     * @return The last element of this list.
     */
    E peekLast();

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return An array containing the first n elements of the list.
     */
    E[] peekArray(int n);

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return An array containing the last n elements of the list.
     */
    E[] peekLastArray(int n);

    /**
     * Retrieves, but does not remove, the first n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return A list containing the first n elements of the list.
     */
    List<E> peekCollection(int n);

    /**
     * Retrieves, but does not remove, the last n elements of the list.
     *
     * @param n The number of elements to retrieve.
     * @return A list containing the last n elements of the list.
     */
    List<E> peekLastCollection(int n);

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return The first element of this list.
     */
    E poll();

    /**
     * Retrieves and removes the last element of this list.
     *
     * @return The last element of this list.
     */
    E pollLast();

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return An array containing the first n elements of the list.
     */
    E[] pollArray(int n);

    /**
     * Retrieves and removes the last n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return An array containing the last n elements of the list.
     */
    E[] pollLastArray(int n);

    /**
     * Retrieves and removes the first n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return A list containing the first n elements of the list.
     */
    List<E> pollCollection(int n);

    /**
     * Retrieves and removes the last n elements of the list.
     *
     * @param n The number of elements to retrieve and remove.
     * @return A list containing the last n elements of the list.
     */
    List<E>pollLastCollection(int n);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param element The element to be removed from this list.
     * @return 'true' if the element was removed successfully, otherwise 'false'.
     */
    boolean remove(E element);

    /**
     * Removes from this list all of its elements that are contained in the specified array.
     *
     * @param array The array containing elements to be removed from this list.
     * @return 'true' if the array elements were removed successfully, otherwise 'false'.
     */
    boolean remove(E[] array);

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be removed from this list.
     * @return 'true' if the collection elements were removed successfully, otherwise 'false'.
     */
    boolean remove(Collection<E> collection);

    /**
     * Removes all of the elements of this list that satisfy the given predicate.
     *
     * @param filter The predicate used to test elements.
     * @return 'true' if elements were removed successfully, otherwise 'false'.
     */
    boolean remove(Predicate<E> filter);

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param element     The element to be replaced.
     * @param newElement  The new element to replace the old one.
     * @param comparator  The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    boolean replace(E element, E newElement, Predicate<E> comparator);

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param array      The array containing elements to be replaced.
     * @param newArray   The array containing new elements to replace the old ones.
     * @param comparator The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    boolean replace(E[] array, E[] newArray, Predicate<E> comparator);

    /**
     * Replaces each element of this list with the result of applying the function to that element.
     *
     * @param collection The collection containing elements to be replaced.
     * @param newCollection The collection containing new elements to replace the old ones.
     * @param comparator The comparator to determine if an element should be replaced.
     * @return 'true' if elements were replaced successfully, otherwise 'false'.
     */
    boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);

    /**
     * Retains only the elements in this list that are contained in the specified array.
     *
     * @param array The array containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    boolean retain(E[] array);

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param collection The collection containing elements to be retained in this list.
     * @return 'true' if elements were retained successfully, otherwise 'false'.
     */
    boolean retain(Collection<E> collection);

    /**
     * Replaces the specified element by a new element in this list. Only the first occurrence is replaced.
     *
     * @param index   The index of the element to be replaced.
     * @param element The new element to replace the old one.
     * @return 'true' if the element was replaced successfully, otherwise 'false'.
     */
    boolean set(int index, E element);

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     *
     * @param toInt The function to extract the integer keys from elements.
     * @return 'true' if the list was sorted successfully, otherwise 'false'.
     */
    boolean sort(ToIntFunction<E> toInt);

    /**
     * Returns a sub list of this list between the specified "from" and "to" indices.
     *
     * @param from The starting index of the sub list.
     * @param to   The ending index of the sub list.
     * @return A sub list containing elements from the specified range.
     */
    List<E> subList(int from, int to);

    /**
     * Returns an array containing all of the elements in this list.
     *
     * @return An array containing all of the elements in this list.
     */
    E[] toArray();
}

