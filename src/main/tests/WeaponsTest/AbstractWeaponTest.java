package WeaponsTest;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractWeaponTest {
    Axe axe;
    @Before
    public void setUp(){
        axe = new Axe("axe",5,10);
    }
    @Test
    public void testGetName(){
        String expected = "axe";
        assertEquals(expected,axe.getName());
    }
    @Test
    public void testGetDamage(){
        int expected = 5;
        assertEquals(expected,axe.getDamage());
    }
    @Test
    public void testGetWeight(){
        int expected = 10;
        assertEquals(expected,axe.getWeight());
    }
    @Test
    public void testToString(){
        String expected = "Weapon{name='axe', damage=5, weight=10, class='Axe'}";
        assertEquals(expected,axe.toString());
    }

}
