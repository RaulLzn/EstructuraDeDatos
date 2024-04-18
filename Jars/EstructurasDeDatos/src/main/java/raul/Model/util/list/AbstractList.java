package raul.Model.util.list;
import raul.Model.util.Iterator.Iterator;
import raul.Model.util.collection.Collection;

import java.util.function.Function;

public abstract class  AbstractList<E> implements List<E>, Collection<E>, Cloneable {

    protected int size;

    protected AbstractList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Function<E, Void> action) {
        Iterator<E> iterator=this.iterator();
        while(iterator.hasNext()) {
            action.apply(iterator.next());
        }
    }



}
