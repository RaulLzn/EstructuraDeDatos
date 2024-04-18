package raul.Parcial1.BagManager.Objetos;

public class ItemPile {
    private Item item;
    private int quantity;

    public ItemPile(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ItemPile(Item item) {
        this.item = item;
        this.quantity = 1;
    }

    public int getPriority(){
        return item.getPriority();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(){
        this.quantity++;
    }
}
