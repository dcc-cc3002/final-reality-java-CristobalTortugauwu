package characterstest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import static org.junit.Assert.*;

public class AbstractCharactersTest {
    PlayerCharacter player;

    Enemy enemy;
    BlockingQueue<GameCharacter> queue;
    @Before
    public void setUp() throws InvalidStatValueException {
        queue = new LinkedBlockingQueue<>();
        player = new Engineer("engineer",5,10,queue);
        enemy = new Enemy("enemy",10,6,8,queue);
    }
    @Test
    public void testEquals() throws InvalidStatValueException {
        PlayerCharacter expected = new Engineer("engineer",5,10,queue);
        assertEquals(expected,player);
        assertEquals(player,player);
        assertNotEquals(player,enemy);
    }
    @Test
    public void testHashCode(){
        assertEquals(player.hashCode(),player.hashCode());
        assertNotEquals(player.hashCode(),enemy.hashCode());
    }

    @Test(expected = NullPointerException.class)
    public void testAddToQueue() {
        enemy.addToQueue();
        enemy.addToQueue();
        player.addToQueue();
        queue.poll();
        queue.poll();
        System.out.println(queue.isEmpty());
    }

    @Test
    public void testGetName(){
        String name = "engineer";
        assertEquals(name,player.getName());
    }

    @Test
    public void testGetCurrentHp() {
        int expected = 5;
        assertEquals(player.getCurrentHp(),expected);
    }

    @Test(expected = InvalidStatValueException.class)
    public void testSetCurrentHp() throws InvalidStatValueException {
        int expected = 3;
        player.setCurrentHp(3);
        assertEquals(expected,player.getCurrentHp());
        player.setCurrentHp(-1);
        assertEquals(expected,player.getCurrentHp());
    }



}
