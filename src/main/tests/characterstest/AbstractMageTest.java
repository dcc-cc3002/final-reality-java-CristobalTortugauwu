package characterstest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.blackmagespells.BlackMageSpells;
import cl.uchile.dcc.finalreality.model.spells.blackmagespells.Fire;
import cl.uchile.dcc.finalreality.model.spells.blackmagespells.Thunder;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.Poison;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class AbstractMageTest {

    WhiteMage whitemage;

    BlackMage blackmage;

    BlockingQueue<GameCharacter> queue2;
    @Before
    public void setUp() throws InvalidStatValueException {
        queue2 = new LinkedBlockingQueue<>();

        whitemage = new WhiteMage("whitemage",2,2,40,queue2);

        blackmage = new BlackMage("blackmage",5,5,60,queue2);

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

    @Test(expected = AssertionError.class)
    public void testEquipSpell() {
        Thunder spell = new Thunder("thunder");
        blackmage.equipSpell(spell);
        Thunder expected = new Thunder("thunder");
        assertEquals(blackmage.getSpell(),expected);
        Poison poison = new Poison("poison");
        //In this part we check that black mage doesn't equip spells that he can't use.
        blackmage.equipSpell(poison);
        assertNotEquals(blackmage.getSpell(),poison);
    }

    @Test(expected = NullPointerException.class)
    public void testUseSpell() throws InvalidStatValueException {
      Enemy enemy = new Enemy("enemy", 100, 1000,10,queue2);
      Spell spell = new Fire("fire");
      Spell spellWm = new Poison("poison");
      Staff staff = new Staff("staff",50,30,400);
      Staff staff2 = new Staff("staff2",50,30,400);
      blackmage.equip(staff2);
      whitemage.equip(staff);
      blackmage.equipSpell(spell);
      whitemage.equipSpell(spellWm);
      whitemage.useSpell(enemy);
      blackmage.useSpell(enemy);
      int expected = 600;
      assertEquals(expected, enemy.getCurrentHp());
      expected = 1;
      Poisoned pos = new Poisoned("poisoned");
      enemy.addEffects(pos);
      assertTrue("nani",enemy.getEffects().getHashSet().contains(pos));
      BlackMageSpells spell2 = new Thunder("thunder");
      spell.removeObserver(blackmage);
      blackmage.equipSpell(spell2);
      blackmage.useSpell(enemy);
      assertEquals(spell2,blackmage.getSpell());
      expected = 200;
      assertEquals(expected,enemy.getCurrentHp());
    }
}