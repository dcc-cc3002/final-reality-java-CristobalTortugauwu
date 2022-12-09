package CharactersTest;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.Before;
import org.junit.Test;

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

    @Test //cd (expected = NullPointerException.class)
    public void testWaitTurn() throws InterruptedException, InvalidStatValueException {
        Enemy enemyTwo = new Enemy("enemy2",30,10,20,queue);
        enemy.waitTurn();
        enemyTwo.waitTurn();
        Thread.sleep(10000);
        assertEquals("enemy",queue.poll().getName());
        assertEquals("enemy2",queue.poll().getName());
    }
    @Test
    public void testToString() {
        String expected = "Enemy{name='enemy', damage=6, weight=10,, class='Enemy'}";
        assertEquals(enemy.toString(),expected);
    }

}
