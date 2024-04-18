package raul.Parcial1.BagManager.Objetos;

public class Item {
    public String name;
    public int priority;
    public int rank;
    public Type type;
    public int durability;
    public String description;


    public Item(String name, int priority, int rank, Type type, int durability, String description) {
        this.name = name;
        this.priority = priority;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", rank=" + rank +
                ", type=" + type +
                ", durability=" + durability +
                ", description='" + description + '\'' +
                '}';
    }
}
