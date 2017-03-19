package example.codeclan.com.shoppingbasket;


import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private Customer customer;

    public ShoppingBasket(Customer customer){
        this.items = new ArrayList<Item>();
        this.customer = customer;
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
        int total = 0;

        for (Item item : items) {
            counter += item.getPrice();
        }
        counter -= this.getBogofTotal();

        if (counter >= 20) {
            total = counter - tenPCOff(counter);
            return total;
        } else {
            return counter;
        }
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

    public int tenPCOff(int value){
        int total = (int) (value * 10f / 100f);
        return total;
    }

    public boolean askForLC() {
        return this.customer.checkLoyaltyCard();
    }

    public void signUpCustomerForLC() {
        this.customer.giveLoyaltyCard();
    }
}



