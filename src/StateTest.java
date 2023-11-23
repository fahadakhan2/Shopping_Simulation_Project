package src;

import static org.junit.Assert.*;
import org.junit.Test;

public class StateTest {
    @Test
    public void testEnumValues() {
        State[] expectedValues = {
                State.AL, State.AK, State.AZ, State.AR, State.CA, State.CO, State.CT, State.DE,
                State.FL, State.GA, State.HI, State.ID, State.IL, State.IN, State.IA, State.KS,
                State.KY, State.LA, State.ME, State.MD, State.MA, State.MI, State.MN, State.MS,
                State.MO, State.MT, State.NE, State.NV, State.NH, State.NJ, State.NM, State.NY,
                State.NC, State.ND, State.OH, State.OK, State.OR, State.PA, State.RI, State.SC,
                State.SD, State.TN, State.TX, State.UT, State.VT, State.VA, State.WA, State.WV,
                State.WI, State.WY
        };
        assertArrayEquals(expectedValues, State.values());
    }
}
