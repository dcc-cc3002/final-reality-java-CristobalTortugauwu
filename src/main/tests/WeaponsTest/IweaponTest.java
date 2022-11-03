package WeaponsTest;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IweaponTest {
    Axe axe;
    @Before
    public void setUp(){
        axe = new Axe("axe",5,10);
    }
    @Test
    public void getNameTest(){
        String expected = "axe";
        assertEquals(expected,axe.getName());
    }
    @Test
    public void getDamageTest(){
        int expected = 5;
        assertEquals(expected,axe.getDamage());
    }
    @Test
    public void getWeightTest(){
        int expected = 10;
        assertEquals(expected,axe.getWeight());
    }
}
