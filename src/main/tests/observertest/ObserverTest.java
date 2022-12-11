package observertest;

import controllertest.ControllerTest;
import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
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
        //From the above class we have the following variables available:
        //playerList, enemyList, controller, staff and sword.
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

    @Test(expected = NullPointerException.class)
    public void notifyObservers() throws InvalidStatValueException {
        //First we use the init method
        controller.init("whitemage",100,20,100,4,staff,
                "knight",200,50,0,2,sword);
        //Now we will test if the hp changes when we attack.
        controller.attackByEnemy(controller.getEnemyList().get(0),
                controller.getPlayerCharacterList().get(1));
        int expected = 150;
        System.out.println(controller.getPlayerCharacterList().get(1).getCurrentHp());
        assertEquals(expected,controller.getPlayerCharacterList().get(1).getCurrentHp());
    }


}
