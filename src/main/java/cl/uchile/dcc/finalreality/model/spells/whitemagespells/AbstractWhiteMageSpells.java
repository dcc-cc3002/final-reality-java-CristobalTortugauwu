package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

/**
 * AbstractWhiteMageSpell class.
 */
public abstract class AbstractWhiteMageSpells extends AbstractSpell implements WhiteMageSpells {

  public AbstractWhiteMageSpells(String name) {
    super(name);
  }

  @Override
  public void equippableByWhiteMage(WhiteMage wm) {
    //Once the spell is equipped, we add the mage as an observer
    this.addObserver(wm);
    wm.setSpell(this);
  }

  public void removeObserver(WhiteMage wm) {
    this.deleteObserver(wm);
  }

}
