package cl.uchile.dcc.finalreality.model.character.player.attackable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;

public interface AttackableByEnemy {
    void attackableByEnemy(Enemy enemy) throws InvalidStatValueException;
}
