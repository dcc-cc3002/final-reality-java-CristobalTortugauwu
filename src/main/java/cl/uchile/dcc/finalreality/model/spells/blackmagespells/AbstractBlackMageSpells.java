package cl.uchile.dcc.finalreality.model.spells.blackmagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractBlackMageSpells extends AbstractSpell implements BlackMageSpells {
  //public abstract void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException;

  public AbstractBlackMageSpells(String name) {
    super(name);
  }
  public int manaCost() {
    return 15;
  }

  @Override
  public void equippableByBlackMage(BlackMage bm) {
    bm.setSpell(this);
  }

}
