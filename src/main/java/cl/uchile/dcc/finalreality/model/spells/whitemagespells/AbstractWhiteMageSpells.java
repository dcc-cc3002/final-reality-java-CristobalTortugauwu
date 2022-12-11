package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractWhiteMageSpells extends AbstractSpell implements WhiteMageSpells {
    public abstract void useWhiteMageSpell(GameCharacter gamecharacter) throws InvalidStatValueException;
}
