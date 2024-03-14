package raul.Model.BagManager.BagManager;

public interface BagManager {

    /**
     * Agrega una bolsa a la lista.
     * @param length
     * @return true si la bolsa fue agregada, false si ya existe.
     */
    boolean addBag(int length);


    boolean addItem(Item item);


}
