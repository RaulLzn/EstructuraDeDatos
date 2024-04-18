package raul.Model.util.node;


public abstract class AbstractNode<E> implements Node<E>, Cloneable {

    protected E element;

    protected AbstractNode() {
        this.element = null;
    }

    protected AbstractNode(E element) {
        this.element = element;
    }

    /**
     * @param element
     */
    @Override
    public void set(E element) {
        this.element = element;
    }

    /**
     * @return
     */
    @Override
    public E get() {
        return this.element;
    }

    public String toString() {
        return element.toString();
    }

}
