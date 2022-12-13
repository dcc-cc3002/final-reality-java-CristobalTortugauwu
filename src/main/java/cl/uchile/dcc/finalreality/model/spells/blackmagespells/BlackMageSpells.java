package cl.uchile.dcc.finalreality.model.spells.blackmagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.spells.Spell;

/**
 * BlackMageSpells class.
 */
public interface BlackMageSpells extends Spell {
  void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException;
}
