package cl.uchile.dcc.finalreality.model.spells.BlackMageSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.spells.Spell;

public interface BlackMageSpells extends Spell {
    void useBlackMageSpell(Enemy enemy, int magicDamage) throws InvalidStatValueException;
}
