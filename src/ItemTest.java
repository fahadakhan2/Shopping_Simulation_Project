package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

    @Test
    public void testValidItemCreationName() throws DataValidationException {
        Item item = new Item("Test Item", 20.0, 3);

        assertEquals("Test Item", item.getName());
    }

    @Test
    public void testValidItemCreationPrice() throws DataValidationException {
        Item item = new Item("Test Item", 20.0, 3);

        assertEquals(20.0, item.getPrice(), 0.01);
    }

    @Test (expected = DataValidationException.class)
    public void testSetItemPriceZero() throws DataValidationException {
        new Item("Test Item", 0.0, 3);
    }

    @Test
    public void testSetItemPriceEqualToMax() throws DataValidationException {
        new Item("Test Item", 99999.99, 3);
    }

    @Test
    public void testSetItemQuanityEqualTo1() throws DataValidationException {
        Item item = new Item("Test Item", 20.0, 1);

        assertEquals(1, item.getQuantity());
    }

    @Test
    public void testSetPriceZero() throws DataValidationException {

    }

    @Test(expected = DataValidationException.class)
    public void testInvalidNameEmptyString() throws DataValidationException {
        new Item("", 15.0, 2);
    }


    @Test(expected = DataValidationException.class)
    public void testInvalidNegativePrice() throws DataValidationException {
        new Item("Invalid Price", -5.0, 1);
    }

    @Test(expected = DataValidationException.class)
    public void testInvalidGreaterThanMaxPrice() throws DataValidationException {
        new Item("Invalid Price", 1000000, 1);
    }

    @Test(expected = DataValidationException.class)
    public void testInvalidQuantity() throws DataValidationException {
        new Item("Invalid Quantity", 10.0, 0);
    }

    @Test
    public void testToString() throws DataValidationException {
        Item item = new Item("Test Item", 15.5, 4);

        String expected = "Test Item: $15.5x4";
        assertEquals(expected, item.toString());
    }

}

