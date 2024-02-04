import org.junit.Test;
import raul.Model.array.Array;
import raul.Model.util.collection.Collection;
import raul.Model.util.list.List;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public void testAddElement() {
        Array<String> array = new Array<>(5);

        // Adding the first element
        assertTrue(array.add("Element1"));
        assertEquals("Element1", array.get(0));

        // Adding another element
        assertTrue(array.add("Element2"));
        assertEquals("Element2", array.get(1));

        // Attempting to add null element (should fail)
        assertFalse(array.add(null));

        // Verifying the array after attempts to add more elements
        assertNull(array.get(2));
        assertNull(array.get(3));
    }

    @Test
    public void testAddArrayAtIndex() {
        Array<String> array = new Array<>(5);

        // Agregando un array a una colección vacía
        String[] elementsToAdd = {"Element1", "Element2", "Element3"};
        assertTrue(array.add(0, elementsToAdd));
        assertEquals("Element1", array.get(0));
        assertEquals("Element2", array.get(1));
        assertEquals("Element3", array.get(2));

        // Intentando agregar un array con elementos nulos (debería fallar)
        assertFalse(array.add(3, (String[]) null));

        // Verificando el array después de intentos de agregar más arrays
        assertNull(array.get(3));
        assertNull(array.get(4));
    }


}
