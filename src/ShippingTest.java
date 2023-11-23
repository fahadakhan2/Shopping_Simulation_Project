package src;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShippingTest {

    @Test
    public void testEnumValues() {
        Shipping[] expectedValues = { Shipping.STANDARD, Shipping.NEXT_DAY };
        assertArrayEquals(expectedValues, Shipping.values());
    }

}
