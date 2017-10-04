import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.mockito.Mockito;

public class RentACat_Test {

    private RentACat rc;
    @Before
    public void setup() {
        rc = new RentACat();
    }


    // Add Tests
    @Test
    public void testReturnNotRentedCat() {
        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getRented()).thenReturn(false);

        boolean returnResult = rc.returnCat(mockCat);

        assertFalse(returnResult);
    }

    @Test
    public void testRentCurrentlyRentedCat() {
        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getRented()).thenReturn(true);

        boolean returnResult = rc.rentCat(mockCat);

        assertFalse(returnResult);
    }

}
