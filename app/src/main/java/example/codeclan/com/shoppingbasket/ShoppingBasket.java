package example.codeclan.com.shoppingbasket;


import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private Customer customer;

    public ShoppingBasket(Customer customer) {
        this.items = new ArrayList<Item>();
        this.customer = customer;
    }


    public int getNumberOfItems() {
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

    public double getItemPrice(Item selectedi) {
        for (Item item : items) {
            if (item == selectedi) {
                return item.getPrice();
            }
        }
        return 0;
    }

    public double getTotal() {
        double counter = 0;
        double total = 0;

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

    public double getBogofTotal() {
        int counter = 0;

        for (int i = 1;
             i < items.size();
             i = i + 2) {
            Item item = items.get(i);
            counter += item.getPrice();
        }
        return counter;

    }

    public double tenPCOff(double value) {
        return value * 10f / 100f;

    }

    public boolean askForLC() {
        return this.customer.checkLoyaltyCard();
    }


    public void askToSignUpForLC(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            this.customer.giveLoyaltyCard();
        }
    }

    public double loyaltyCardDC(){
        double total = getTotal();
        double discountedTotal = 0;
        if (customer.checkLoyaltyCard()){
              discountedTotal = total * 2f /100;
        }
        return discountedTotal;
    }
}



