package example.codeclan.com.shoppingbasket;

public class Customer {

    private String name;
    private Boolean loyaltyCard;

    public Customer(String name) {
        this.name = name;
        this.loyaltyCard = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkLoyaltyCard() {
        return this.loyaltyCard;
    }

    public void giveLoyaltyCard(){
        this.loyaltyCard = true;
    }
}
