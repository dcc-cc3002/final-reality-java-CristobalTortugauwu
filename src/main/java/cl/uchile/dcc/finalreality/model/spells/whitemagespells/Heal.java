package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;

import java.util.Observable;

public class Heal extends AbstractWhiteMageSpells {

    public int manaCost() {
        return 15;
    }
    public void useWhiteMageSpell(GameCharacter gamecharacter) throws InvalidStatValueException {
        //First we have to make sure, that the method spellOnAlly is true.
        if (this.spellOnAlly()) {
          int maxHp = gamecharacter.getMaxHp();
          int currHp = gamecharacter.getCurrentHp();
          int newHp = Math.min(maxHp, currHp + maxHp*(3/10));
          setChanged();
          notifyObservers(new ArgObsPattern("healSpell",gamecharacter,newHp,15));
        }

    }
}
