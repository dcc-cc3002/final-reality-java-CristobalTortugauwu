package CharactersTest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EnemyTest extends AbstractCharactersTest{

    @Before
    public void setUp() throws InvalidStatValueException {
        super.setUp();
    }

    @Test
    public void testGetWeight() {
        int expected = 10;
        assertEquals(expected,enemy.getWeight());
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        Enemy equals = new Enemy("enemy",10,6,8,queue);
        Knight player = new Knight("knight",1,23,queue);
        assertEquals(enemy,equals);
        assertEquals(enemy,enemy);
        assertNotEquals(enemy,player);
    }

    @Test (expected = NullPointerException.class)
    public void testWaitTurn() throws InterruptedException {
        enemy.addToQueue();
        enemy.waitTurn();
        Thread.sleep(2000);
        queue.poll();

    }
    @Test
    public void testToString() {
        String expected = "Enemy{name='enemy', damage=6, weight=10,, class='Enemy'}";
        assertEquals(enemy.toString(),expected);
    }

}
