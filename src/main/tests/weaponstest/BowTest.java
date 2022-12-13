package weaponstest;

import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BowTest {
    Iweapon bow;
    Bow expected;
    Knife different;
    @Before
    public void setUp(){
        bow = new Bow("Bow",5,10);
        expected = new Bow("Bow",5,10);
        different = new Knife("Axe",5,10);
    }

    @Test
    public void testEquals(){
        assertNotEquals(null,bow);
        assertEquals(bow,bow);
        assertEquals(bow,expected);
        assertNotEquals(different,bow);
    }
    @Test
    public void testHashCode(){
        //Tienen los mismos parámetros, pero son distintas clases
        assertNotEquals(different.hashCode(),bow.hashCode());
        assertEquals(bow.hashCode(),expected.hashCode());
    }
}
