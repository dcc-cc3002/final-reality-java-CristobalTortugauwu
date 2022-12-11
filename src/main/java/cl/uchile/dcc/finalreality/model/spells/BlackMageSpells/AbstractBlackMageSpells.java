package cl.uchile.dcc.finalreality.model.spells.BlackMageSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractBlackMageSpells extends AbstractSpell implements BlackMageSpells {
  public abstract void useBlackMageSpell(Enemy enemy,
                                         int magicDamage) throws InvalidStatValueException;

  public int manaCost() {
    return 15;
  }

}
