package src;

import javax.xml.crypto.Data;
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

    public void addItem(Item item) throws DataValidationException {
        if (item == null) {
            throw new DataValidationException("Invalid item passed in: " + item);
        }
        items.add(item);

        int countOfItems = 0;
        for (Item i : items) {
            countOfItems += i.getQuantity();
        }
        System.out.println("The current count of items in the cart is: " + countOfItems);
    }

    public void getCurrentTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        double taxRate = 0.0;
        if (State.IL == shopper.getState() || State.CA == shopper.getState() || State.NY == shopper.getState()) {
            taxRate = 0.06; // 6% sales tax
        }

        double salesTax = total * taxRate;

        double shippingCost = 0.0;
        if (shopper.getPreferredShippingMethod() == Shipping.STANDARD) {
            shippingCost = (total > 50.0) ? 0.0 : 10.0;
        } else if (shopper.getPreferredShippingMethod() == Shipping.NEXT_DAY) {
            shippingCost = 25.0;
        }

        double finalTotal =  total + salesTax + shippingCost;
        System.out.println("The total for the items in the shopping cart is: $" + finalTotal);
    }

    public void getContents() {
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        }

        System.out.println("Here are all the items in the shopping cart:");
        for (Item i : items) {
            System.out.println(i.toString());
        }
    }

    public void checkout() {
        System.out.println("Transaction completed");
    }

    public void editQuantity(Item item, int newQuantity) throws DataValidationException {
        if (item == null || newQuantity < 1) {
            throw new DataValidationException("The item you entered is either null or a the quantity entered is negative.");

        }
        item.setQuantity(newQuantity);
    }

    public void removeItem(Item item) throws DataValidationException{
        if (item == null || !items.contains(item)) {
            throw new DataValidationException("The item you are trying to remove is either null or is not in your shopping cart.");
        }
        items.remove(item);
    }
}
