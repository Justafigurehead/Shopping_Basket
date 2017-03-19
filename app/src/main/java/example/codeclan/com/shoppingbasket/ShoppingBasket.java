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
        return counter -= this.getBogofTotal();
    }

    public int getBogofTotal(){
        int counter = 0;

        for (int i = 1;
             i < items.size();
             i = i + 2){
            Item item = items.get(i);
            counter += item.getPrice();
        }
        return counter;

    }
    // Rubber duck here: For buy one get one free. It usually means that you get the cheapest item free when you buy another. At its most basic where every item is subject to the BOGOF coupon then every second item would be free. Therefore every odd index number would be free. So, rubber duck, if I got the count of shopping baskets' items, I could get the odd indexes and subtract it from the total counter.
}



