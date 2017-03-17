package example.codeclan.com.shoppingbasket;


import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;

    public ShoppingBasket(){
        this.items = new ArrayList<Item>();
    }


    public int getNumberOfItems(){
        return items.size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeAllItems() {
        items.clear();
    }

    public int getItemPrice(Item selectedi) {
        for (Item item : items) {
            if (item == selectedi) {
                return item.getPrice();
            }
        }
        return 0;
    }

    public int getTotal() {
        int counter = 0;
        for (Item item : items){
           counter += item.getPrice();
        }
//        int numberOfItems = getNumberOfItems();
//        if (numberOfItems  )
        return counter;
    }
}
