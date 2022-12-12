package cl.uchile.dcc.finalreality.model.character.player.validspell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;

public interface ValidBlackMageSpell {
    void receiveBlackMageSpell(BlackMage blackmage) throws InvalidStatValueException;
}
