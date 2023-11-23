package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShopperTest {

    @Test
    public void testValidShopperState() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.CA, Shipping.STANDARD);
        assertEquals(State.CA, shopper.getState());
    }

    @Test
    public void testValidShopperShippingMethod() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.CA, Shipping.STANDARD);
        assertEquals(Shipping.STANDARD, shopper.getPreferredShippingMethod());
    }

    @Test
    public void testValidSetAndGetName() throws DataValidationException {
        Shopper shopper = new Shopper("John Doe", State.CA, Shipping.STANDARD);
        assertEquals("John Doe", shopper.getName());
    }

    @Test(expected = DataValidationException.class)
    public void testSetNameEmptyString() throws DataValidationException {
        new Shopper("", State.CA, Shipping.STANDARD);
    }

    @Test(expected = DataValidationException.class)
    public void testInvalidStateNull() throws DataValidationException {
        new Shopper("Fahad", null, Shipping.NEXT_DAY);
    }


    @Test(expected = DataValidationException.class)
    public void testInvalidShippingMethod() throws DataValidationException {
        new Shopper("Fahad", State.NY, null);
    }

}
