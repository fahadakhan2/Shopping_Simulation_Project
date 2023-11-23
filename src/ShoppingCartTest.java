package src;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void testSetShopperWithValidShopperPassedIn() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        new ShoppingCart(shopper);
    }

    @Test (expected = DataValidationException.class)
    public void testSetShopperWithInvalidNullShopperPassedIn() throws DataValidationException {
        new ShoppingCart(null);
    }

    @Test
    public void testGetShopper() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        assertEquals(shopper, shoppingCart.getShopper());
    }

    @Test
    public void testCountOfItemsInCartAfterAddingItemToCart() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(2, shoppingCart.countOfItemsInCart());
    }

    @Test
    public void testCountOfItemsInCartZeroItems() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        assertEquals(0, shoppingCart.countOfItemsInCart());
    }

    @Test
    public void testGetCurrentTotalAfterAddingItemsToCart() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(31.2, shoppingCart.getCurrentTotal(), 0.01);
    }

    @Test
    public void testGetCurrentTotalEmptyCart() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        assertEquals(0.0, shoppingCart.getCurrentTotal(), 0.01);
    }

    @Test(expected = DataValidationException.class)
    public void testAddItemToCartNullItem() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        shoppingCart.addItemToCart(null);
    }

    @Test
    public void testGetSalesTaxIllinois() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(1.2, shoppingCart.getSalesTax(), 0.01);
    }

    @Test
    public void testGetSalesTaxCalifornia() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.CA, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(1.2, shoppingCart.getSalesTax(), 0.01);
    }

    @Test
    public void testGetSalesTaxNewYork() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.NY, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(1.2, shoppingCart.getSalesTax(), 0.01);
    }

    @Test
    public void testGetSalesTaxNoTaxState() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(0.0, shoppingCart.getSalesTax(), 0.01);
    }

    @Test
    public void testGetShippingCostStandardShippingRawTotalLessThan51() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 50.0, 1);
        shoppingCart.addItemToCart(item);

        assertEquals(10.0, shoppingCart.getShippingCost(), 0.01);
    }

    @Test
    public void testGetShippingCostStandardShippingRawTotalGreaterThan50() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 60.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(0.0, shoppingCart.getShippingCost(), 0.01);
    }

    @Test
    public void testGetShippingCostNextDayShipping() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.IL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 10.0, 2);
        shoppingCart.addItemToCart(item);

        assertEquals(25.0, shoppingCart.getShippingCost(), 0.01);
    }

    @Test
    public void testEditQuantity() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 20.0, 2);
        shoppingCart.addItemToCart(item);

        int newQuantity = 1;
        shoppingCart.editQuantity(item, newQuantity);

        assertEquals(newQuantity, item.getQuantity());
    }

    @Test(expected = DataValidationException.class)
    public void testEditQuantityInvalidNegativeQuantity() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 20.0, 2);
        shoppingCart.addItemToCart(item);

        int newQuantity = -1;
        shoppingCart.editQuantity(item, newQuantity);
    }

    @Test(expected = DataValidationException.class)
    public void testEditQuantityInvalidNullItem() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 20.0, 2);
        shoppingCart.addItemToCart(item);

        int newQuantity = 3;
        shoppingCart.editQuantity(null, newQuantity);
    }

    @Test
    public void testRemoveItemValidItem() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 20.0, 2);
        shoppingCart.addItemToCart(item);
        shoppingCart.removeItem(item);

        assertTrue(shoppingCart.getItems().isEmpty());
    }

    @Test(expected = DataValidationException.class)
    public void testRemoveItemInvalidItemNull() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item = new Item("Test Item", 20.0, 2);
        shoppingCart.addItemToCart(item);
        shoppingCart.removeItem(null);
    }

    @Test(expected = DataValidationException.class)
    public void testRemoveItemInvalidItemNotInCart() throws DataValidationException {
        Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
        ShoppingCart shoppingCart = new ShoppingCart(shopper);

        Item item1 = new Item("Test Item", 20.0, 2);
        Item item2 = new Item("Test Item 2", 20.0, 2);

        shoppingCart.addItemToCart(item1);
        shoppingCart.removeItem(item2);
    }
}
