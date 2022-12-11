package weaponstest;

import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
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
    public void testGetMagicDamage(){
        int expected = 5;
        assertEquals(expected,staff.getMagicDamage());
        assertNotEquals(staff.getMagicDamage(),staff2.getMagicDamage());
    }
    @Test
    public void testEquals(){
        Sword notExpected = new Sword("sword",124,4);
        assertEquals(staff,staff);
        assertNotEquals(staff2,staff);
        assertEquals(staff,expected);
        assertNotEquals(notExpected,staff);

    }
    @Test
    public void testHashCode(){
        assertNotEquals(staff.hashCode(),staff2.hashCode());
        assertEquals(staff.hashCode(),expected.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Weapon{name='staff', damage=5, weight=10, magic= 5, class='Staff'}";
        assertEquals(expected,staff.toString());
    }

}
