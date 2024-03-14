package raul.Model.util.stack;

public interface Stack<E> {

    /**
     * Allows you to retrieve the value at the top of a stack without actually removing it
     *
     * @return the value at the top of the stack.
     */
    public E peek();

    /**
     * Allows you to retrieve and remove the value at the top of a stack
     *
     * @return the value at the top of the stack.
     */
    public E pop();

    /**
     * Allows you to insert a value at the top of a stack
     *
     * @param element the value to add to the top of the stack.
     * @return 'true' if the value was inserted successfully, otherwise 'false'.
     */
    public boolean push(E element);
}
