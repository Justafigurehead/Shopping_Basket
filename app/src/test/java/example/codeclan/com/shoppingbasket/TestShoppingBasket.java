package example.codeclan.com.shoppingbasket;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    Customer customer;
    ShoppingBasket shoppingBasket;
    Item jam;
    Item biscuits;
    Item gum;
    Item book;


    @Before
    public void before(){

        customer = new Customer("Michaela");
        shoppingBasket = new ShoppingBasket(customer);
        jam = new Item(20);
        biscuits = new Item(30);
        gum = new Item(2);
        book = new Item(19);

    }

    @Test
    public void testShoppingBasketIsEmpty(){
        assertEquals(0, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void testAddASingleItemToBasket(){
        shoppingBasket.addItem(jam);
        assertEquals(1, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void testCanRemoveSingleItemFromBasket(){
        shoppingBasket.addItem(jam);
        shoppingBasket.removeItem(jam);
        assertEquals(0, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void testCanRemoveAllItemsInBasket(){
        shoppingBasket.addItem(jam);
        shoppingBasket.addItem(biscuits);
        shoppingBasket.removeAllItems();
        assertEquals(0, shoppingBasket.getNumberOfItems());
    }

    @Test
    public void testCanGetPriceFromItemAddedToBasket(){
        shoppingBasket.addItem(biscuits);
        assertEquals(30, shoppingBasket.getItemPrice(biscuits));
    }

    @Test
    public void testWillReceiveZeroIfItemIsNotInBasket(){
        assertEquals(0, shoppingBasket.getItemPrice(jam));
    }

    @Test
    public void testGetTotalOfAllItemsInBasketWithBOGOFandTenPercentOff(){
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(27, shoppingBasket.getTotal());
    }


    @Test
    public void GetTenPercentOffJam(){
        shoppingBasket.addItem(jam);
        assertEquals(2, shoppingBasket.tenPCOff(shoppingBasket.getItemPrice(jam)));
    }

    @Test
    public void testtestNoBogofAppliedAndNoTenPercentDiscountAdded(){
        shoppingBasket.addItem(gum);
        assertEquals(2, shoppingBasket.getTotal());
    }

    @Test
    public void testIfPurchaseIsNineteenAndNoTenPercentDCAdded(){
        shoppingBasket.addItem(book);
        assertEquals(19, shoppingBasket.getTotal());
    }

    @Test
    public void testifCustomerHasLoyaltyCard(){
        assertEquals(false, shoppingBasket.askForLC());
    }

    @Test
    public void testGiveLCtoCustomer(){
        shoppingBasket.signUpCustomerForLC();
        assertEquals(true, shoppingBasket.askForLC());
    }
}
