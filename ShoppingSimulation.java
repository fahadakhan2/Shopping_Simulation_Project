import src.*;

public class ShoppingSimulation {
    public static void main(String[] args) {
        try {
            Shopper shopper1 = new Shopper(State.IL, Shipping.STANDARD);
//            Shopper shopper2 = new Shopper(State.AL, Shipping.NEXT_DAY);

            ShoppingCart cart = new ShoppingCart(shopper1);

            // Example item addition
            Item item1 = new Item("Item 1", 10.0, 2);
            Item item2 = new Item("Item 2", 20.0, 1);
            cart.addItem(item1);
            cart.addItem(item2);

            // Example operations
            cart.editQuantity(item1, 3);
            cart.removeItem(item2);

            // Get the current total
            cart.getCurrentTotal();

            // Checkout
            cart.checkout();
        } catch (DataValidationException dve) {
            dve.getMessage();
        }
    }
}
