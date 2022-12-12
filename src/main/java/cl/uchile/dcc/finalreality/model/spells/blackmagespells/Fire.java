package cl.uchile.dcc.finalreality.model.spells.blackmagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

public class Fire extends AbstractBlackMageSpells {

    public Fire(String name) {
        super(name);
    }
    public void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException {
        //First we do the magic damage
        int enemyHp = enemy.getCurrentHp();
        int newHp = enemyHp-magicDamage;
        enemy.setCurrentHp(Math.max(newHp, 0));
        //Now we care about the effect being added to the
        //effects instance in the enemy class.
        if (Math.random()<=0.2) {
            CompositeEffect effects = enemy.getEffects();
            effects.addEffect(new Burned());
            enemy.setEffects(effects);
        }
    }

}
