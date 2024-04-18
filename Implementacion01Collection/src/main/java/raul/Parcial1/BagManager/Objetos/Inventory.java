package raul.Parcial1.BagManager.Objetos;

import raul.Model.array.Array;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class Inventory<E extends BagPriority> extends Array<E> {

    public Inventory(int dimension) {
        super(dimension);
    }

    //Este metodo recibe un item y retorna el indice de la bolsa que contiene el item
    public int contains(Item item) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).containsItem(item)) {
                index = i;
            }
        }
        return index;
    }

    //Metodo para inntercambiar Items entre bolsas
    public void exchangeItems(Item item1, Item item2) {
        int index1 = contains(item1);
        int index2 = contains(item2);

        if (index1 == -1 || index2 == -1) {
            // Si uno de los elementos no está presente en ninguna bolsa, salir
            return;
        }

        BagPriority bag1 = this.get(index1);
        BagPriority bag2 = this.get(index2);

        LinkedList<ItemPile> items1 = new LinkedList<>();
        LinkedList<ItemPile> items2 = new LinkedList<>();

        // Extraer todos los elementos de la bolsa 1 excepto el item1 y viceversa
        extractAllExcept(bag1, item1, items1);
        extractAllExcept(bag2, item2, items2);

        // Intercambiar los elementos en las listas temporales
        items1.add(new ItemPile(item2, item1.getPriority()));
        items2.add(new ItemPile(item1, item2.getPriority()));

        // Insertar los elementos actualizados en las bolsas
        insertAll(bag1, items1);
        insertAll(bag2, items2);
    }

    // Método para extraer todos los elementos de una bolsa excepto el indicado
    private void extractAllExcept(BagPriority bag, Item itemToExclude, LinkedList<ItemPile> items) {
        int size = bag.size();
        for (int i = 0; i < size; i++) {
            ItemPile item = (ItemPile) bag.extract();
            if (!item.getItem().equals(itemToExclude)) {
                items.add(item);
            }
        }
    }

    // Método para insertar todos los elementos de una lista en una bolsa
    private void insertAll(BagPriority bag, LinkedList<ItemPile> items) {
        Iterator<ItemPile> iterator = items.iterator();
        while (iterator.hasNext()) {
            ItemPile item = iterator.next();
            // Insertar el elemento en la bolsa utilizando el método insert de la clase BagPriorityQueue
            bag.insert(item.getItem());
        }
    }

}
