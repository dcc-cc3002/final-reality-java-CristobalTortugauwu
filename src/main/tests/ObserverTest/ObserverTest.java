package ObserverTest;

import ControllerTest.ControllerTest;
import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

public class ObserverTest extends ControllerTest {

    Knight knight;
    GameController controller2;
    ArrayList<PlayerCharacter> playersList2;
    ArrayList<Enemy> enemyList2;
    BlockingQueue<GameCharacter> queue2;

    @Before
    public void setUp() throws InvalidStatValueException {
        super.setUp();
        knight = new Knight("knight",100,50,queue);
    }

    @Test
    public void addObserverTest() throws InvalidStatValueException {
        knight.addObserver(controller);
        int expected = 1;
        assertEquals(expected,knight.countObservers());
        playersList2 = new ArrayList<PlayerCharacter>();
        enemyList2 = new ArrayList<Enemy>();
        queue2 = new LinkedBlockingQueue<>();
        controller2 = new GameController(enemyList2,playersList2,queue2);
        expected = 2;
        knight.addObserver(controller2);
        assertEquals(expected, knight.countObservers());
    }

    @Test
    public void removeObserverTest() throws InvalidStatValueException {
        knight.addObserver(controller);
        int expected = 1;
        assertEquals(expected,knight.countObservers());
        knight.deleteObserver(controller);
        expected = 0;
        assertEquals(expected,knight.countObservers());

    }

    @Test
    public void notifyObservers() {

    }


}
