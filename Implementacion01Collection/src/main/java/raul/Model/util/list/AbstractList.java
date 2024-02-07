package raul.Model.util.list;
import raul.Model.util.collection.Collection;

public abstract class AbstractList<E> implements List<E>, Collection<E>, Cloneable {

    protected int size;

    protected AbstractList() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public AbstractList<E> clone() {
        try {
            return (AbstractList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
