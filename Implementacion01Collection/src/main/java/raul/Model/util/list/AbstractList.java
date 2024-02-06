package raul.Model.util.list;
import raul.Model.util.collection.Collection;

public abstract class AbstractList<E> implements List<E>, Collection<E>, Cloneable {

    @Override
    public AbstractList<E> clone() {
        try {
            return (AbstractList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
