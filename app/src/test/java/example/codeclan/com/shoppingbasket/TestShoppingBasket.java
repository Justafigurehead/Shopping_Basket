package example.codeclan.com.shoppingbasket;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    ShoppingBasket shoppingBasket;
    Item jam;
    Item biscuits;

    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();
        jam = new Item(20);
        biscuits = new Item(30);
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
    public void testGetTotalOfAllItemsInBasket(){
        shoppingBasket.addItem(biscuits);
        shoppingBasket.addItem(jam);
        assertEquals(50, shoppingBasket.getTotal());
    }
}
