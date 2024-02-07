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
        return null;
    }

    public String toString() {
        return element.toString();
    }

    @Override
    public AbstractNode<E> clone() {
        try {
            AbstractNode clone = (AbstractNode) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
