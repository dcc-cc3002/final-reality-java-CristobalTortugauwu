package cl.uchile.dcc.finalreality.model.spells.BMSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.spells.Spell;

public interface BlackMageSpells extends Spell {
    void useBMSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException;
}
