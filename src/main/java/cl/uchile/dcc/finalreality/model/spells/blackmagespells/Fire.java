package cl.uchile.dcc.finalreality.model.spells.blackmagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.ArgSpellObsPattern;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.effects.Burned;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

/**
 * Fire spell class.
 */
public class Fire extends AbstractBlackMageSpells {

  /**
   * Constructor of the fire class.
   */
  public Fire(String name) {
    super(name);
  }


  /**
   *This method allows a black mage to use his spell.
   */
  public void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException {
    //First we do the magic damage
    int enemyHp = enemy.getCurrentHp();
    int newHp = enemyHp - magicDamage;
    ArgObsPattern arg = new ArgObsPattern("fireSpell",
            enemy, newHp, null);
    //Now we care about the effect being added to the
    //effects instance in the enemy class.
    if (Math.random() <= 0.2) {
      arg.setEffects(new Burned("burned"));
    }
    setChanged();
    notifyObservers(new ArgSpellObsPattern(null, manaCost(), arg));
  }

}
