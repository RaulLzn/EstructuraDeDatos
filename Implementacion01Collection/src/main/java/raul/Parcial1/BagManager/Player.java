package raul.Parcial1.BagManager;

import raul.Model.array.Array;
import raul.Parcial1.BagManager.Objetos.Bag;
import raul.Parcial1.BagManager.Objetos.Item;

public class Player {

    public String name;
    public int numBags = 1;
    public Array<Bag> bags;

    public Player(String name, int numBags) {
        this.bags = new Array<>(numBags);
        this.name = name;
        if (numBags <= 4)
            this.numBags = numBags;
        else System.out.println("No se puede añadir, maximo de bolsas alcanzado");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumBags() {
        return numBags;
    }

    public void setNumBags(int numBags) {
        this.numBags = numBags;
    }

    public void añadirBolsa(Bag bag) {
        if (bags.size() < numBags)
            bags.add(bag);
        else System.out.println("No se ha podido añadir la bolsa por que se ha alcanzado el limite maximo");
    }

    public boolean añadirItemPrioridad(Item item){
        for (int ii = 0; ii < bags.size(); ii++){
            if (bags[ii] > bags. )
        }
    }

}
