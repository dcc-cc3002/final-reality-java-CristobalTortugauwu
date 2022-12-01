package cl.uchile.dcc.finalreality.model.spells.WMSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.Spell;

public interface WhiteMageSpells extends Spell {
    void useWMSpell(GameCharacter gamecharacter) throws InvalidStatValueException;
}
