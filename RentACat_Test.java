import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;

public class RentACat_Test {

    private RentACat rc;

    @Before
    public void setup() {
        rc = new RentACat();
    }


    @Test
    public void testListCats() {

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getName()).thenReturn("Meow");
        when(mockCat.getId()).thenReturn(1);
        when(mockCat.toString()).thenReturn("ID 1. Meow");

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(mockCat);

        String result = rc.listCats(ListOfCats);
        boolean res = result.equals("ID 1. Meow");
        assertTrue(res);
    }

    @Test
    public void testListRentedCat() {
        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getName()).thenReturn("Meow");
        when(mockCat.getId()).thenReturn(0);
        when(mockCat.getRented()).thenReturn(true);

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(mockCat);

        String result = rc.listCats(ListOfCats);
        assertTrue(result.length() == 0);
    }

    @Test
    public void testCatDoesExist() {
        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getId()).thenReturn(0);

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(mockCat);

        assertTrue(rc.catExists(0, ListOfCats));
    }

    @Test
    public void testCatDoesNotExist() {

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getId()).thenReturn(1);

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(mockCat);

        assertFalse(rc.catExists(0, ListOfCats));
    }

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

    @Test(expected = NullPointerException.class)
    public void testRentNullCat() {
        boolean returnResult = rc.rentCat(null);
    }

}
