package ObserverTest;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

public class ObserverTest {

    GameController controller;

    Staff staff;

    Sword sword;

    @Before
    public void setUp() throws InvalidStatValueException {
        staff = new Staff("staff",100,20,100);
        sword = new Sword("sword",100,100);
        controller.init("whitemage",100,20,100,4,staff,
                "knight",200,50,0,2,sword);
    }

    @Test
    public void addObserverTest() {
        Enemy enemy = controller.getEnemyList().get(0);
        enemy.addObserver(controller);


    }




}
