package src;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();
    private Shopper shopper;

    public ShoppingCart(Shopper s) throws DataValidationException {
        setShopper(s);
    }

    private void setShopper(Shopper s) throws DataValidationException {
        if (s == null) {
            throw new DataValidationException("Invalid shopper passed as argument: " + s);
        }
        shopper = s;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int countOfItemsInCart() {
        int countOfItems = 0;

        for (Item i : items) {
            countOfItems += i.getQuantity();
        }
        return countOfItems;
    }

    public void addItemToCart(Item item) throws DataValidationException {
        if (item == null) {
            throw new DataValidationException("Invalid item passed in: " + item);
        }

        items.add(item);
        int c = countOfItemsInCart();
        System.out.println("The current count of items in the cart is: " + c);
    }

    public double getCurrentTotal() {
        if (items.isEmpty()) {
            System.out.println("The total for the items in the shopping cart is: $0.00");
            return 0.0;
        }

        double finalTotal =  getRawTotal() + getSalesTax() + getShippingCost();
        System.out.println("The total for the items in the shopping cart is: $" + finalTotal);
        return finalTotal;
    }

    public double getRawTotal() {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }

    public double getSalesTax() {
        double taxRate = 0.0;

        if (State.IL == shopper.getState() || State.CA == shopper.getState() || State.NY == shopper.getState()) {
            taxRate = 0.06;
        }
        return getRawTotal() * taxRate;
    }

    public double getShippingCost() {
        double shippingCost = 0.0;

        if (shopper.getPreferredShippingMethod() == Shipping.STANDARD) {
            shippingCost = (getRawTotal() > 50.0) ? 0.0 : 10.0;
        } else if (shopper.getPreferredShippingMethod() == Shipping.NEXT_DAY) {
            shippingCost = 25.0;
        }
        return shippingCost;
    }

    public void getContents() {
        StringBuilder sb = new StringBuilder();

        sb.append("Shopping cart for ").append(shopper.getName()).append(":").append("\n");
        if (items.isEmpty()) {
            sb.append("The shopping cart is currently empty.");
        }

        for (Item i : items) {
            sb.append(i.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }

    public void checkout() {
        System.out.println("Transaction completed!");
    }

    public void editQuantity(Item item, int newQuantity) throws DataValidationException {
        if (item == null || newQuantity < 1) {
            throw new DataValidationException("The item you entered is either null or a the quantity entered is negative.");
        }

        item.setQuantity(newQuantity);
        System.out.println("The quantity of one of the items in your cart has changed. Here is the updated item: " + item.toString());
    }

    public void removeItem(Item item) throws DataValidationException{
        if (item == null || !items.contains(item)) {
            throw new DataValidationException("The item you are trying to remove is either null or is not in your shopping cart.");
        }

        items.remove(item);
        System.out.println("An item was removed from your cart: " + item.toString());
    }
}
