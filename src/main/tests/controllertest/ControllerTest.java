package controllertest;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

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
    }

    @Test(expected = NullPointerException.class)
    public void testInit() throws InvalidStatValueException {
        controller.init("whitemage",100,20,100,4,staff,
                "knight",200,50,0,2,sword);
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
