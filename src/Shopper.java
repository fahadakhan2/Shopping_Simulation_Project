package src;

public class Shopper {
    private String name;
    private State state;
    private Shipping preferredShippingMethod;

    public Shopper(String name, State state, Shipping preferredShippingMethod) throws DataValidationException {
        setName(name);
        setState(state);
        setPreferredShippingMethod(preferredShippingMethod);
    }

    public String getName() {
        return name;
    }

    private void setName(String n) throws DataValidationException {
        if (n == null || n.isEmpty()) {
            throw new DataValidationException("Invalid name passed in");
        }
        name = n;
    }

    public State getState() {
        return state;
    }

    private void setState(State st) throws DataValidationException {
        if (st == null) {
            throw new DataValidationException("The state passed in is not valid: " + st);
        }
        state = st;
    }

    public Shipping getPreferredShippingMethod() {
        return preferredShippingMethod;
    }

    private void setPreferredShippingMethod(Shipping sh) throws DataValidationException, IllegalArgumentException {
        if (sh == null) {
            throw new DataValidationException("The shipping method passed in is not valid: " + sh);
        }
        preferredShippingMethod = sh;
    }
}
