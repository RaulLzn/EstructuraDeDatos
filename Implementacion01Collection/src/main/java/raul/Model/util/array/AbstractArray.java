package raul.Model.util.array;

import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;

public abstract class AbstractArray<E> implements Array<E>, Collection<E>, Cloneable{


    @Override
    public AbstractArray<E> clone() {
        try {
            return (AbstractArray) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
