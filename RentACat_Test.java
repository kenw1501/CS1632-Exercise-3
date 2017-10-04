import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;

public class RentACat_Test {


    @Before
    public void setup() {

    }


    // Add Tests
    @Test
    public void testListCats() {
        Cat testCat = new Cat(0, "Meow");

        ArrayList<Cat> ListOfCats = new ArrayList<Cat>();
        ListOfCats.add(testCat);

        Cat mockCat = Mockito.mock(Cat.class);
        when(mockCat.getName()).thenReturn("Meow");
        when(mockCat.getId()).thenReturn(0);


        RentACat r = new RentACat();
        String result = r.listCats(ListOfCats);

        assert(result.equals("ID 0. Meow"));
    }


}
