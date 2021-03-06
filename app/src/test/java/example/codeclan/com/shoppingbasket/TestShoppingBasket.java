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
        assertEquals(30, shoppingBasket.getItemPrice(biscuits), 0.01);
    }

    @Test
    public void testWillReceiveZeroIfItemIsNotInBasket(){
        assertEquals(0, shoppingBasket.getItemPrice(jam), 0.01);
    }

    @Test
    public void testGetTotalOfAllItemsInBasketWithBOGOFandTenPercentOff(){
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(27, shoppingBasket.getTotal(), 0.01);
    }


    @Test
    public void GetTenPercentOffJam(){
        shoppingBasket.addItem(jam);
        assertEquals(2, shoppingBasket.tenPCOff(shoppingBasket.getItemPrice(jam)), 0.01);
    }

    @Test
    public void testtestNoBogofAppliedAndNoTenPercentDiscountAdded(){
        shoppingBasket.addItem(gum);
        assertEquals(2, shoppingBasket.getTotal(),0.01);
    }

    @Test
    public void testIfPurchaseIsNineteenAndNoTenPercentDCAdded(){
        shoppingBasket.addItem(book);
        assertEquals(19, shoppingBasket.getTotal(), 0.01);
    }

    @Test
    public void testifCustomerHasLoyaltyCard(){
        assertEquals(false, shoppingBasket.askForLC());
    }

    @Test
    public void testCustomerAsksToSignUpForLC(){
        shoppingBasket.askToSignUpForLC("yes");
        assertEquals(true, shoppingBasket.askForLC());
    }

    @Test
    public void testCustomerTurnsDownLC(){
        shoppingBasket.askToSignUpForLC("No");
        assertEquals(false, shoppingBasket.askForLC());
    }

    @Test
    public void testCustomerHasLCandGets2percentDC(){
        shoppingBasket.askToSignUpForLC("yes");
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(0.54, shoppingBasket.loyaltyCardDC(), 0.01);
    }

    @Test
    public void testCustomerDoesNotHaveLCAndGetsNoDiscount(){
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(0, shoppingBasket.loyaltyCardDC(), 0.01);
    }

    @Test
    public void testCustomerHasLCAndDiscountGetsAppliedToTotal(){
        shoppingBasket.askToSignUpForLC("yes");
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(26.5, shoppingBasket.getCustomerTotal(), 0.1);
    }

    @Test
    public void testCustomerGetsCustomerTotalButHasNoLC(){
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(27, shoppingBasket.getCustomerTotal(), 0.1);
    }
}
