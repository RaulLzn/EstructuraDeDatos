/*
 * Implementar un componente para gestionar el inventario de personaje de un juego. 
 * Cada ítem debe tener las siguientes propiedades: Item name (string); 
 * Priority (integer: 0 a 4); Rank (integer: 0 a 1000); Type (enum: cloth, leather, plate); 
 * Durability (integer: 0 a 1); Y description (string). El inventario consta de 4 bolsas con 8 o 12 o 14 slots. 
 * La bosas cambian en el tiempo de juego. Al inicio del juego solo se tiene una bolsa es de 8 slots. 
 * El componente debe tener la capacidad de: Agrega una bolsa al inventario. 
 * Agrega un ítem a la bolsa por prioridad (0 es la mayor prioridad). 
 * Si la bolsa está llena pasará a la siguiente. 
 * Si el ítem ya se encuentra en la bolsa los apila en el mismo lugar. 
 * Desplegar una lista priorizada de ítems. Intercambia dos ítems de lugar al otro en el inventario. 
 * Las bolsas pueden ir en cualquier orden y se pueden eliminar junto con todos los ítems. 
 */

package raul.Parcial1.BagManager;

import raul.Model.priorityqueue.PriorityQueue;
import raul.Model.util.Iterator.Iterator;
import raul.Parcial1.BagManager.Objetos.BagPriority;
import raul.Parcial1.BagManager.Objetos.Inventory;
import raul.Parcial1.BagManager.Objetos.Item;
import raul.Parcial1.BagManager.Objetos.ItemPile;

public class Player {
    private Inventory<BagPriority<ItemPile>> bag;

    public Player() {
        this.bag = new Inventory<>(4);
        bag.add(new BagPriority<>(5, 8));
    }

    /**
     * Agrega una bolsa al inventario
     * @param tamaño
     */
    public void addBag(int tamaño) {
        if (tamaño == 8 || tamaño == 12 || tamaño == 14) {
            bag.add(new BagPriority<>(5, tamaño));
        }
    }

    /**
     * Agrega un ítem a la bolsa por prioridad (0 es la mayor prioridad).
     * Si la bolsa está llena pasará a la siguiente.
     * Si el ítem ya se encuentra en la bolsa los apila en el mismo lugar.
     * @param item
     * @return
     */
    public boolean addItem(Item item){
        for (int i=0; i<bag.size(); i++){
            BagPriority<ItemPile> actualBag = bag.get(i);
            if (actualBag.containsItem(item)){
                actualBag.cantidadItemIgual(item);
                return true;
            }
            if (actualBag.espacio()){
                actualBag.Insert(item.getPriority(), new ItemPile(item, 1));
                return true;
            }
        }
        return false;
    }

    /**
     * Desplegar una lista priorizada de ítems.
     * @return
     */
    public PriorityQueue<Item> displayItems() {
        PriorityQueue<Item> itemsToDisplay = new PriorityQueue<>(5);
        for (int i = 0; i < bag.size(); i++) {
            BagPriority<ItemPile> bagPriority = bag.get(i);
            Iterator<ItemPile> iterator = bagPriority.iterator();
            while (iterator.hasNext()) {
                ItemPile itemPile = iterator.next();
                itemsToDisplay.Insert(itemPile.getItem().getPriority(), itemPile.getItem());
            }
        }
        return itemsToDisplay;
    }

    /**
     * Intercambia dos ítems de lugar al otro en el inventario.
     * @param item1
     * @param item2
     */
    public void exchangeItems (Item item1, Item item2){
        if (bag.contains(item1) != -1 && bag.contains(item2)!= -1){
            bag.exchangeItems(item1, item2);
        }
    }

    /**
     * Elimina una bolsa del inventario
     * @param bagIndex
     */
    public void removeBag(int bagIndex) {
        bag.remove(bagIndex);
    }

}
