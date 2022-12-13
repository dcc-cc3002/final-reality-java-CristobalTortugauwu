package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.ArgSpellObsPattern;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;

/**
 * Poison class.
 */
public class Poison extends AbstractWhiteMageSpells {

  public Poison(String name) {
    super(name);
  }

  public int manaCost() {
    return 40;
  }

  /**
   * This methods uses the white mage spell.
   */
  public void useWhiteMageSpell(GameCharacter gamecharacter) {
    if (gamecharacter.isEnemy()) {
      //At this point, we're sure that we can use the spell on an enemy.
      ArgObsPattern arg = new ArgObsPattern("poisonSpell",
              gamecharacter, gamecharacter.getCurrentHp(), new Poisoned("poisoned"));
      setChanged();
      notifyObservers(new ArgSpellObsPattern(null, manaCost(), arg));
    }
  }

}
