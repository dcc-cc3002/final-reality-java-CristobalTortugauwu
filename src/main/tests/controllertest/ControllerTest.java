package controllertest;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.Paralysis;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.Poison;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    protected GameController controller;
    protected Staff staff;
    protected Sword sword;;
    protected ArrayList<PlayerCharacter> playersList;
    protected ArrayList<Enemy> enemyList;
    protected BlockingQueue<GameCharacter> queue;

    @Before
    public void setUp() throws InvalidStatValueException {
        playersList = new ArrayList<PlayerCharacter>();
        enemyList = new ArrayList<Enemy>();
        queue = new LinkedBlockingQueue<>();
        controller = new GameController(enemyList,playersList,queue);
        staff = new Staff("staff",100,20,100);
        sword = new Sword("sword",100,100);
        controller.init("whitemage", 100, 20, 100, 4, staff,
                "knight", 200, 50, 0, 2, sword);
    }

    @Test
    public void testInit() throws InvalidStatValueException {
        controller.init("whitemage", 100, 20, 100, 4, staff,
                "knight", 200, 50, 0, 2, sword);
        Enemy expected = new Enemy("enemy", 50, 1000, 10, queue);
        assertEquals(expected, controller.getEnemyList().get(0));
        WhiteMage expected2 = new WhiteMage("whitemage", 100, 20, 100, queue);
        ArrayList<PlayerCharacter> list = controller.getPlayerCharacterList();
        assertEquals(expected2, list.get(0));
        Knight expected3 = new Knight("knight",200,50,queue);
        assertEquals(expected3, list.get(1));
    }


    @Test
    public void testCreatePlayer() throws InvalidStatValueException {
        controller.createPlayer("engineer", 100, 250, 0, 1, sword);
        int expected = 2;
        assertEquals(expected,controller.getPlayerCharacterList().size());
        Axe axe = new Axe("axe",300,200);
        controller.createPlayer("engineer", 100, 250, 0, 1, axe);
        expected = 3;
        assertEquals(expected,controller.getPlayerCharacterList().size());
        controller.createPlayer("blackmage", 120, 50, 200, 0, axe);
        controller.createPlayer("blackmage", 120, 50, 200, 0, staff);
        expected = 4;
        assertEquals(expected,controller.getPlayerCharacterList().size());
    }

    @Test
    public void testUseSpellByWhiteMage() throws InvalidStatValueException {
      PlayerCharacter wm =  controller.getPlayerCharacterList().get(0);
      Enemy enemy = controller.getEnemyList().get(0);
      Paralysis par = new Paralysis("paralysis");
      controller.equipSpell(par, (WhiteMage) wm);
      controller.useSpellByWhiteMage((WhiteMage) wm, enemy);
      int expected = 75;
      assertEquals(expected,wm.getCurrentMana());
      assertTrue("hope this works",!enemy.getEffects().getHashSet().isEmpty());
      Poison poison = new Poison("poison");
      controller.changeSpellByWhiteMage((WhiteMage) wm, poison);
      Poison expectedSpell = new Poison("poison");
      assertEquals(expectedSpell,((WhiteMage) wm).getSpell());
      controller.useSpellByWhiteMage((WhiteMage) wm, enemy);
      expected = 35;
      assertEquals(expected,wm.getCurrentMana());
      expected = 2;
      assertEquals(expected,enemy.getEffects().getHashSet().size());
    }

    @Test
    public void testUseSpellByBlackMAge() {

    }



}
