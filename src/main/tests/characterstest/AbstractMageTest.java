package characterstest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AbstractMageTest {

    WhiteMage whitemage;

    BlackMage blackmage;

    BlockingQueue<GameCharacter> queue2;
    @Before
    public void setUp() throws InvalidStatValueException {
        queue2 = new LinkedBlockingQueue<>();

        whitemage = new WhiteMage("whitemage",2,2,40,queue2);

        blackmage = new BlackMage("blackmage",5,5,20,queue2);

    }

    @Test
    public void changeValue() throws InvalidStatValueException {
        ArrayList<PlayerCharacter> list = new ArrayList<PlayerCharacter>();
        list.add(whitemage); list.add(blackmage);
        BlackMage blackmage2 = new BlackMage("newbm",5,51,3,queue2);
        int i = list.indexOf(blackmage);
        list.set(i,blackmage2);
        for(int k =0 ;k<2;k++) {
            System.out.println(list.get(k));
        }
    }
    @Test
    public void testEquals() throws InvalidStatValueException {
        WhiteMage expected = new WhiteMage("whitemage",2,2,40,queue2);
        assertEquals(whitemage,expected);
        assertEquals(whitemage,whitemage);
        assertNotEquals(whitemage,blackmage);
    }

    @Test
    public void testHashCodeMage() throws InvalidStatValueException {
        WhiteMage expected = new WhiteMage("whitemage",2,2,40,queue2);
        assertEquals(expected.hashCode(),whitemage.hashCode());

    }

    @Test
    public void testGetMaxMana() {
        int expected = 20;
        assertEquals(expected,blackmage.getMaxMana());
    }

    @Test (expected = InvalidStatValueException.class)
    public void testSetCurrentMana() throws InvalidStatValueException {
        blackmage.setCurrentMana(15);
        int expected = 15;
        assertEquals(expected, blackmage.getCurrentMana());
        blackmage.setCurrentMana(-5);
        assertEquals(expected, blackmage.getCurrentMana());
        blackmage.setCurrentMana(25);
        assertEquals(expected,blackmage.getCurrentMana());

    }


}