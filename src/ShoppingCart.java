package src;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();
    private State state;
    private Shipping shipping;

    public ShoppingCart(State st, Shipping sh) throws DataValidationException {
        setState(st);
        setShipping(sh);
    }


    private void setState(State st) throws DataValidationException {
        if (st == null) {
            throw new DataValidationException("Invalid state passed in as argument: " + st);
        }
        state = st;
    }

    private void setShipping(Shipping sh) throws DataValidationException{
        if (sh == null) {
            throw new DataValidationException("Invalid shipping option passed in as argument: " + sh);
        }
        shipping = sh;
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
        System.out.println("The current count of items in the cart is" + countOfItems + ".");
    }

    public void getCurrentTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        double taxRate = 0.0;
        if (State.IL == state || State.CA == state || State.NY == state) {
            taxRate = 0.06; // 6% sales tax
        }

        double salesTax = total * taxRate;

        double shippingCost = 0.0;
        if (shipping == Shipping.STANDARD) {
            shippingCost = (total > 50.0) ? 0.0 : 10.0;
        } else if (shipping == Shipping.NEXT_DAY) {
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
