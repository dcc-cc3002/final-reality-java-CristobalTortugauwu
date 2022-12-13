package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.ArgSpellObsPattern;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * Heal class spell.
 */
public class Heal extends AbstractWhiteMageSpells {

  public Heal(String name) {
    super(name);
  }

  public int manaCost() {
    return 15;
  }

  /**
   * Uses the white mage spell.
   */
  public void useWhiteMageSpell(GameCharacter gamecharacter) throws InvalidStatValueException {
    int maxHp = gamecharacter.getMaxHp();
    int currHp = gamecharacter.getCurrentHp();
    int newHp = Math.min(maxHp, (currHp + (maxHp * 3) / 10));
    ArgObsPattern arg = new ArgObsPattern("healSpell", gamecharacter, newHp, null);
    setChanged();
    notifyObservers(new ArgSpellObsPattern(null, manaCost(), arg));
  }
}
