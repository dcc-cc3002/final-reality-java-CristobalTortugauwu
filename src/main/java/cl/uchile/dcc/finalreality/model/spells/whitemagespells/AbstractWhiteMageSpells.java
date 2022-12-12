package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractWhiteMageSpells extends AbstractSpell implements WhiteMageSpells {

    public AbstractWhiteMageSpells(String name) {
      super(name);
    }
    //public abstract void useWhiteMageSpell(GameCharacter gamecharacter) throws InvalidStatValueException;
    @Override
    public void equippableByWhiteMage(WhiteMage wm) {
      wm.setSpell(this);
    }

}
