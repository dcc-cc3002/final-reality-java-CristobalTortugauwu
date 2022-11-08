package CharactersTest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractOrdinary;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AbstractOrdinaryTest {
    BlockingQueue <GameCharacter> queue;
    Engineer engineer;
    Knight knight;
    Thief thief;
    Axe axe;
    Bow bow;
    Knife knife;
    Sword sword;

    @Before
    public void setUp() throws InvalidStatValueException {
        queue = new LinkedBlockingQueue<>();
        engineer = new Engineer("engineer",5,5,queue);
        knight = new Knight("knight",3,4,queue);
        thief = new Thief("thief",20,1,queue);
        axe = new Axe("axe",15,20);
        bow = new Bow("bow",2,30);
        knife = new Knife("knife",40,10);
        sword = new Sword("sword",100,60);
    }

    @Test
    public void testEquipEngineer() {
        assertEquals(null,engineer.getEquippedWeapon() );
        engineer.equip(axe);
        assertEquals(axe,engineer.getEquippedWeapon());
        engineer.equip(bow);
        assertEquals(bow,engineer.getEquippedWeapon());
    }

    @Test
    public void testToString() {
        String expected = "Engineer{maxHp=5, defense=5, name='engineer'}";
        assertEquals(expected,engineer.toString());
    }

    @Test
    public void testEquipKnight() {
        assertEquals(null,knight.getEquippedWeapon());
        knight.equip(axe);
        assertEquals(axe,knight.getEquippedWeapon());
        knight.equip(knife);
        assertEquals(knife,knight.getEquippedWeapon());
        knight.equip(sword);
        assertEquals(sword,knight.getEquippedWeapon());
    }

    @Test
    public void testToString2() {
        String expected = "Knight{maxHp=3, defense=4, name='knight'}";
        assertEquals(expected,knight.toString());
    }

    @Test
    public void testEquipThief() {
        assertEquals(null,thief.getEquippedWeapon());
        thief.equip(knife);
        assertEquals(knife,thief.getEquippedWeapon());
        thief.equip(bow);
        assertEquals(bow,thief.getEquippedWeapon());
        thief.equip(sword);
        assertEquals(sword,thief.getEquippedWeapon());
    }

    @Test
    public void testToString3() {
        String expected = "Thief{maxHp=20, defense=1, name='thief'}" ;
        System.out.println(thief.toString());
    }

    @Test (expected = NullPointerException.class)
    public void testWaitTurn() throws InterruptedException {
        thief.equip(knife);
        knight.equip(sword);
        thief.addToQueue();
        knight.addToQueue();
        thief.waitTurn();
        knight.waitTurn();
        Thread.sleep(10000);
        assertEquals("thief",queue.poll().getName());
        assertEquals("knight",queue.poll().getName());


    }
    /*
     * Hay que testear getEquippedWeapon y waitTurn
     */
}
