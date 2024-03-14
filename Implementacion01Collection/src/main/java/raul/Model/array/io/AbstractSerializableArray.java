package raul.Model.array.io;

import java.io.Serializable;
import raul.Model.array.Array;

public abstract class AbstractSerializableArray<E extends Serializable> extends Array<E> implements Serializable{

    protected static final long serialVersionUID = 1L;

    /**
     * @param dimension
     */
    public AbstractSerializableArray(int dimension) {
        super(dimension);
    }

    public AbstractSerializableArray(E[] elements) {
        super(elements);
    }
}
