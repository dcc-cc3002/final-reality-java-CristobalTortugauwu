package cl.uchile.dcc.finalreality.model.spells.WhiteMageSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.Spell;

public interface WhiteMageSpells extends Spell {
    void useWhiteMageSpell(GameCharacter gamecharacter) throws InvalidStatValueException;
}
