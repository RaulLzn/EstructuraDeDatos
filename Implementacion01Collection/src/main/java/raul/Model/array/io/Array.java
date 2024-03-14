package raul.Model.array.io;

import java.io.Serializable;

public class Array<E extends Serializable> extends AbstractSerializableArray<E>{

    /**
     * @param dimension
     */
    public Array(int dimension) {
        super(dimension);
    }

    public Array(E[] elements) {
        super(elements);
    }
}
