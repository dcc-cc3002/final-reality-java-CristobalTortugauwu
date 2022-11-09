package WeaponsTest;

import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SwordTest {
    Iweapon sword;
    Sword expected;
    Knife different;
    @Before
    public void setUp(){
        sword = new Sword("Sword",5,10);
        expected = new Sword("Sword",5,10);
        different = new Knife("Axe",5,10);
    }

    @Test
    public void testEquals(){
        assertNotEquals(null,sword);
        assertEquals(sword,sword);
        assertEquals(sword,expected);
        assertNotEquals(different,sword);
    }
    @Test
    public void testHashCode(){
        //Tienen los mismos parámetros, pero son distintas clases
        assertNotEquals(different.hashCode(),sword.hashCode());
        assertEquals(sword.hashCode(),expected.hashCode());
    }
}
