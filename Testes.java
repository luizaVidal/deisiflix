package pt.ulusofona.deisi.aed.deisiflix;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Testes {
    @Test
    public void testToString01(){
        Filme obj = new Filme(11631, "Mamma Mia!", "03-07-2008",
                1435, 6.4, 52000000, 108.0,
                null, null, null);

        assertEquals("11631 | Mamma Mia! | 03-07-2008 | 1435 | 6.4", obj.toString());
    }
    @Test
    public void testToString02(){
        Filme obj = new Filme(772, "Home Alone 2: Lost in New York", "19-11-1992",
                2459 , 6.3, 18000000, 120.0,
                null, null, null);

        assertEquals("772 | Home Alone 2: Lost in New York | 19-11-1992 | 2459 | 6.3", obj.toString());
    }

}