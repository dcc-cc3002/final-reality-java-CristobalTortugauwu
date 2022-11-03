package WeaponsTest;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StaffTest {
    Staff staff;
    Staff staff2;
    Staff expected;
    @Before
    public void setUp(){
        staff = new Staff("staff",5,10,5);
        expected = new Staff("staff",5,10,5);
        staff2 = new Staff("staff",5,12,6);
    }
    @Test
    public void getMagicDamageTest(){
        int expected = 5;
        assertEquals(expected,staff.getMagicDamage());
        assertNotEquals(staff.getMagicDamage(),staff2.getMagicDamage());
    }
    @Test
    public void equalsTest(){
        assertEquals(staff,staff);
        assertNotEquals(staff2,staff);
        assertEquals(staff,expected);
        assertNotEquals(null,staff);

    }
    @Test
    public void hashCodeTest(){
        assertNotEquals(staff.hashCode(),staff2.hashCode());
        assertEquals(staff.hashCode(),expected.hashCode());
    }
}
