package src;

public class Shopper {
    private State state;
    private Shipping preferredShippingMethod;
    public Shopper(State state, Shipping preferredShippingMethod) throws DataValidationException {
        setState(state);
        setPreferredShippingMethod(preferredShippingMethod);
    }

    public State getState() {
        return state;
    }

    private void setState(State st) throws DataValidationException {
        if (st == null) {
            throw new DataValidationException("The state passed in is not valid: " + st);
        }

        // Checks if the provided state is a valid enum constant
        boolean isValidState = false;
        for (State stateEnum : State.values()) {
            if (stateEnum == st) {
                isValidState = true;
                break;
            }
        }

        if (!isValidState) {
            throw new DataValidationException("Invalid state enum: " + st);
        }
        state = st;
    }

    public Shipping getPreferredShippingMethod() {
        return preferredShippingMethod;
    }

    private void setPreferredShippingMethod(Shipping sh) throws DataValidationException {
        if (sh == null) {
            throw new DataValidationException("The shipping method passed in is not valid: " + sh);
        }

        boolean isValidShippingMethod = false;
        for (Shipping shippingEnum : Shipping.values()) {
            if (shippingEnum == sh) {
                isValidShippingMethod = true;
                break;
            }
        }

        if (!isValidShippingMethod) {
            throw new DataValidationException("Invalid shipping enum: " + sh);
        }
        preferredShippingMethod = sh;
    }
}
