package cl.uchile.dcc.finalreality.model.character.player.ValidSpell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;

public interface ValidBMSpell {
    void receiveBMSpell(BlackMage blackmage) throws InvalidStatValueException;
}
