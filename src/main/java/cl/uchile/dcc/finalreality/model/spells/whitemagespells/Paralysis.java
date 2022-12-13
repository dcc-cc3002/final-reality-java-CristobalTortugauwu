package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.ArgSpellObsPattern;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;

/**
 * Paralysis class spell.
 */
public class Paralysis extends AbstractWhiteMageSpells {
  public Paralysis(String name) {
    super(name);
  }

  public int manaCost() {
    return 25;
  }

  /**
   * This method uses the white mage spell.
   */
  public void useWhiteMageSpell(GameCharacter gamecharacter) {
    if (gamecharacter.isEnemy()) {
      //At this point, we're sure that we can use the spell on an enemy.
      ArgObsPattern arg = new ArgObsPattern("paralysisSpell",
              gamecharacter, gamecharacter.getCurrentHp(), new Paralyzed("paralyzed"));
      setChanged();
      notifyObservers(new ArgSpellObsPattern(null, manaCost(), arg));
    }
  }
}
