package ControllerTest;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

public class ControllerTest {

    GameController controller;
    WhiteMage whitemage;
    Knight knight;
    Staff staff;
    Sword sword;;
    ArrayList<PlayerCharacter> playersList;
    ArrayList<Enemy> enemyList;
    BlockingQueue<GameCharacter> queue;
    @Before
    public void setUp() throws InvalidStatValueException {
        playersList = new ArrayList<PlayerCharacter>();
        enemyList = new ArrayList<Enemy>();
        queue = new LinkedBlockingQueue<>();
        controller = new GameController(enemyList,playersList,queue);
        BlockingQueue<GameCharacter> gameQueue = controller.getQueue();
        whitemage = new WhiteMage("whitemage",3,3,3,gameQueue);
        //knight = new Knight("knight",3,3,gameQueue);
        staff = new Staff("staff",100,20,100);
        sword = new Sword("sword",100,100);
    }

    @Test
    public void testInit() throws InvalidStatValueException {
        controller.init();
    }


    /**@Test
    public void testCreatePlayer() throws InvalidStatValueException {
        BlackMage blackmage = new BlackMage("blackmage",3,31,2, gameQueue);
        BlackMage expected = new BlackMage("blackmage",3,31,2, gameQueue);
        controller.createPlayer(blackmage,staff);
        assertEquals(expected,controller.getPlayerCharacterList().get(2));
    }
    */



}
