package example.codeclan.com.shoppingbasket;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestItems {
    Item jam;
    Item biscuits;

    @Before
    public void before(){
        jam = new Item(20);
        biscuits = new Item(30);
    }


    @Test
    public void testItemHasPrice(){
        assertEquals(20, jam.getPrice(), 0.01);
    }
}
