package cl.uchile.dcc.finalreality.model.character.player.attackable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public interface AttackableByPlayerCharacter {
    void attackableByPlayerCharacter(PlayerCharacter pc) throws InvalidStatValueException;
}
