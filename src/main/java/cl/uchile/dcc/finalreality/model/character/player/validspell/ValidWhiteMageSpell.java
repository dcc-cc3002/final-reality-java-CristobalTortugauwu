package cl.uchile.dcc.finalreality.model.character.player.validspell;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

public interface ValidWhiteMageSpell {
    void receiveWMSpell(WhiteMage whiteMage) throws InvalidStatValueException;
}
