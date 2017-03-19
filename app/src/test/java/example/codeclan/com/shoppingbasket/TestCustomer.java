package example.codeclan.com.shoppingbasket;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomer {

    Customer customer;

    @Before
    public void before(){
        customer = new Customer("Michaela");
    }

    @Test
    public void testCustomerHasName(){
        assertEquals("Michaela", customer.getName());
    }
}
