package cl.uchile.dcc.finalreality.model.spells.blackmagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.ArgSpellObsPattern;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;

/**
 * Thunder class.
 */
public class Thunder extends AbstractBlackMageSpells {

  public Thunder(String name) {
    super(name);
  }

  /**
   * Uses the thunder spell of the black mage.
   */
  public void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException {
    //First we do the magic damage
    int enemyHp = enemy.getCurrentHp();
    int newHp = enemyHp - magicDamage;
    ArgObsPattern arg = new ArgObsPattern("thunderSpell",
            enemy, newHp, null);
    //Now we care about the effect being added to the
    //effects instance in the enemy class.
    if (Math.random() <= 0.2) {
      arg.setEffects(new Paralyzed("paralyzed"));
    }
    setChanged();
    notifyObservers(new ArgSpellObsPattern(null, manaCost(), arg));
  }
}
