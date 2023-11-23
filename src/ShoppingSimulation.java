package src;

public class ShoppingSimulation {
    public static void main(String[] args) {
        try {
            Shopper shopper = new Shopper("Fahad", State.IL, Shipping.STANDARD);
//        	Shopper shopper = new Shopper("Fahad", State.AL, Shipping.NEXT_DAY);
//        	Shopper shopper = new Shopper("Fahad", State.PO, Shipping.SAME_DAY);

            ShoppingCart cart = new ShoppingCart(shopper);

            // Add items to shopping cart
            Item item1 = new Item("Item 1", 10.0, 6);
            Item item2 = new Item("Item 2", 20.0, 1);

            cart.addItemToCart(item1);
            cart.addItemToCart(item2);

            // Show cart content
            cart.getContents();

            // Example operations
            cart.editQuantity(item1, 3);
            cart.removeItem(item2);

            // show cart content after edit and removal
            cart.getContents();

            // Get the current total
            cart.getCurrentTotal();

            // Checkout
            cart.checkout();
        } catch (DataValidationException e) {
            e.getMessage();
        }
    }
}
