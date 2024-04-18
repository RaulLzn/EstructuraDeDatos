package raul.Parcial1.BagManager.Objetos;

import raul.Model.util.Iterator.Iterator;
import raul.Model.array.Array;
import raul.Model.linkedlist.doubly.LinkedList;
import raul.Model.priorityqueue.PriorityQueue;

public class BagPriority<E extends ItemPile> extends PriorityQueue<E> {

    private int tamaño;

    public BagPriority(int n, int tamaño){
        super(n);
        this.tamaño = tamaño;
    }

    public boolean espacio() {
        return this.size() != tamaño;
    }

    public void cantidadItemIgual(Item item) {
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            ItemPile itemPileGot = iterator.next();
            Item itemGot = itemPileGot.getItem();
            if (itemGot.equals(item)){
                itemPileGot.addQuantity();
            }
        }
    }

    public boolean containsItem(Item item){
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            Item itemGot = iterator.next().getItem();
            if (itemGot.equals(item)){
                return true;
            }
        }
        return false;
    }

}
