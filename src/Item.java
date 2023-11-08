package src;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) throws DataValidationException {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    private void setName(String n) throws DataValidationException {
        if (n.isEmpty()) {
            throw new DataValidationException("Invalid name entered: " + n);
        }
        name = n;
    }

    public String getName() {
        return name;
    }

    private void setPrice(double p) throws DataValidationException {
        if (p <= 0.00) {
            throw new DataValidationException("Invalid amount entered for price: " + p);
        }
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int q) throws DataValidationException {
        if (q <= 0) {
            throw new DataValidationException("Invalid amount entered for quantity: " + q);
        }
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }
}
