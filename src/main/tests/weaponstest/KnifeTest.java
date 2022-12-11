package weaponstest;

import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KnifeTest {
    Iweapon knife;
    Knife expected;
    Bow different;
    @Before
    public void setUp(){
        knife = new Knife("Knife",5,10);
        expected = new Knife("Knife",5,10);
        different = new Bow("Axe",5,10);
    }

    @Test
    public void testEquals(){
        assertNotEquals(null,knife);
        assertEquals(knife,knife);
        assertEquals(knife,expected);
        assertNotEquals(different,knife);
    }
    @Test
    public void testHashCode(){
        //Tienen los mismos parámetros, pero son distintas clases
        assertNotEquals(different.hashCode(),knife.hashCode());
        assertEquals(knife.hashCode(),expected.hashCode());
    }
}
