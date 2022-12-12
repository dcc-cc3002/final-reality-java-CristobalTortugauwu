package observertest;

import cl.uchile.dcc.finalreality.model.character.player.MagesCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.Heal;
import controllertest.ControllerTest;
import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        //playerList, eList, controller, staff and sword.
        super.setUp();
        knight = new Knight("knight", 100, 50, queue);
    }

    @Test
    public void addObserverTest() throws InvalidStatValueException {
        knight.addObserver(controller);
        int expected = 1;
        assertEquals(expected,knight.countObservers());
        playersList2 = new ArrayList<PlayerCharacter>();
        enemyList2 = new ArrayList<Enemy>();
        queue2 = new LinkedBlockingQueue<>();
        controller2 = new GameController(enemyList2, playersList2, queue2);
        expected = 2;
        knight.addObserver(controller2);
        assertEquals(expected, knight.countObservers());
    }

    @Test
    public void removeObserverTest() throws InvalidStatValueException {
        knight.addObserver(controller);
        int expected = 1;
        assertEquals(expected, knight.countObservers());
        knight.deleteObserver(controller);
        expected = 0;
        assertEquals(expected, knight.countObservers());

    }

    @Test
    public void notifyObserversTest() throws InvalidStatValueException {
      //First we use the init method
      controller.init("whitemage",100,20,100,4,staff,
              "knight",200,50,0,2,sword);
      //Now we will test if the hp changes when we attack.
      ArrayList<Enemy> eList = controller.getEnemyList();
      ArrayList<PlayerCharacter> pcList = controller.getPlayerCharacterList();
      controller.attackByEnemy(eList.get(0),
              pcList.get(1));
      int expected = 150;
      assertEquals(expected, pcList.get(1).getCurrentHp());
      controller.attackByEnemy(eList.get(0), pcList.get(1));
      expected = 100;
      assertEquals(expected, pcList.get(1).getCurrentHp());
      //case where a PlayerCharacter attacks an enemy.
      controller.attackByPlayerCharacter(pcList.get(1), eList.get(0));
      expected = 900;
      assertEquals(expected, eList.get(0).getCurrentHp());
      //Now we will test the spells
      Spell heal = new Heal("heal");
      ((MagesCharacter)pcList.get(0)).equipSpell(heal);
      controller.useSpellByWhiteMage((WhiteMage) pcList.get(0),
              pcList.get(1));
      expected = 160;
      assertEquals(expected, pcList.get(1).getCurrentHp());
    }

}
