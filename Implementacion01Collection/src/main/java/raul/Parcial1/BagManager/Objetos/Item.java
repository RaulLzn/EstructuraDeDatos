package raul.Parcial1.BagManager.Objetos;

public class Item {
    public String name;
    public int priority;
    public int rank;
    public enum Type {CLOTH, LEATER, PLATE};
    public int durability;
    public String description;

    public Item(String name, int priority, int rank, int durability, String description) {
        this.name = name;
        if (priority >= 0 && priority < 4)
            this.priority = priority;
        else System.out.println("Prioridad por fuera del rango");
        if (rank >= 0 && rank < 1000)
            this.rank = rank;
        else System.out.println("Rango por fuera del rango");
        if (durability >= 0 && durability <= 1)
            this.durability = durability;
        else System.out.println("Durabilidad por fuera del rango");
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
