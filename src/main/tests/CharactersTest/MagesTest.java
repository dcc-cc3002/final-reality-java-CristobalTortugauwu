package CharactersTest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MagesTest extends AbstractMageTest{
    Knife knife;

    Staff staff;


    @Before
    public void setUp() throws InvalidStatValueException {
        super.setUp();
        knife = new Knife("knife",40,20);
        staff = new Staff("staff",100,100,200);
    }

    @Test
    public void testToString() {
        String expected = "BlackMage{currentMp=20, maxMp=20, maxHp=5, defense=5, name='blackmage'}";
        assertEquals(expected,blackmage.toString());
    }

    @Test
    public void testEquipBlackMage() {
        assertEquals(null,blackmage.getEquippedWeapon());
        blackmage.equip(knife);
        assertEquals(knife,blackmage.getEquippedWeapon());
        blackmage.equip(staff);
        assertEquals(staff,blackmage.getEquippedWeapon());
        blackmage.setWeapon(null);
    }


    @Test(expected = AssertionError.class)
    public void testEquipWhiteMage() {
        assertEquals(null,whitemage.getEquippedWeapon());
        whitemage.equip(staff);
        assertEquals(staff,whitemage.getEquippedWeapon());
        whitemage.equip(knife);

    }
    @Test
    public void testToString2() {
        String expected = "WhiteMage{maxMp=40, maxHp=2, defense=2, name='whitemage'}";
        assertEquals(expected,whitemage.toString());
    }

}
