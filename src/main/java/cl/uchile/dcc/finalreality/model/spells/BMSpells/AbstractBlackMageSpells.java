package cl.uchile.dcc.finalreality.model.spells.BMSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractBlackMageSpells extends AbstractSpell implements BlackMageSpells {
    public void useBMSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException {
        int enemyHp = enemy.getCurrentHp();
        int newHp = enemyHp-magicDamage;
        enemy.setCurrentHp(Math.max(newHp, 0));
    }
}
