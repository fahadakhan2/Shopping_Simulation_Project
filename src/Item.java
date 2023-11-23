package src;

public class Item {
    private String name;
    private double price;
    private int quantity;

    Item(String name, double price, int quantity) throws DataValidationException {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    private void setName(String n) throws DataValidationException {
        if (n.isEmpty() || n == null) {
            throw new DataValidationException("Invalid name entered: " + n);
        }
        name = n;
    }

    public String getName() {
        return name;
    }

    private void setPrice(double p) throws DataValidationException {
        if (p <= 0.00 || p > 99999.99) {
            throw new DataValidationException("Invalid amount entered for price: " + p);
        }
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int q) throws DataValidationException {
        if (q < 1) {
            throw new DataValidationException("Invalid amount entered for quantity: " + q);
        }
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + ": " + "$" + price + "x" + quantity;
    }
}
