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
        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(new Cat(0, ""));

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getName()).thenReturn("Meow");
        when(mockCat.getId()).thenReturn(1);

        String result = rc.listCats(ListOfCats);
        System.out.println(result);

        boolean res = result.equals("ID 1. Meow");
        System.out.println(res);
        assertTrue(res);
    }

    @Test
    public void testListRentedCat() {

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(new Cat(0, ""));

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getName()).thenReturn("Meow");
        when(mockCat.getId()).thenReturn(0);
        when(mockCat.getRented()).thenReturn(true);

        String result = rc.listCats(ListOfCats);
        assertTrue(result.length() == 0);
    }

    @Test
    public void testCatDoesExist() {

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(new Cat(0, ""));

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getId()).thenReturn(0);

        assertTrue(rc.catExists(0, ListOfCats));
    }

    @Test
    public void testCatDoesNotExist() {
        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(new Cat(0, ""));

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getId()).thenReturn(1);

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
