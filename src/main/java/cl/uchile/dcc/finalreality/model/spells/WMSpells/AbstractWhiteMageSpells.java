package cl.uchile.dcc.finalreality.model.spells.WMSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Effect;
import cl.uchile.dcc.finalreality.model.spells.AbstractSpell;

public abstract class AbstractWhiteMageSpells extends AbstractSpell implements WhiteMageSpells {
    public abstract void useWMSpell(GameCharacter gamecharacter) throws InvalidStatValueException;
}
