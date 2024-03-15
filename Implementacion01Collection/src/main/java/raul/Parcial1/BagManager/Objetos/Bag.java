package raul.Parcial1.BagManager.Objetos;

import raul.Model.array.Array;
import raul.Model.linkedlist.doubly.LinkedList;
import raul.Model.priorityqueue.PriorityQueue;

public class Bag {

    public int slots;

    public PriorityQueue<Item> items;


    public boolean lleno;

    public Bag(int slots) {
        if (slots == 8 || slots == 12 || slots ==14)
            this.slots = slots;
        else System.out.println("Error, una bolsa solo puede tener 8, 12 o 14 slots;");
        this.items = items = new PriorityQueue<>(4);
        if (items.size() < slots)
            this.lleno = false;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public void añadirItem(Item item){
        if (lleno != true)
            items.Insert(item.priority, item);
    }



}
