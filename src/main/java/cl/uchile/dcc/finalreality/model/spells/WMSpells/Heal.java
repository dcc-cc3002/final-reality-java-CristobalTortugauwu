package cl.uchile.dcc.finalreality.model.spells.WMSpells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.WMSpells.WhiteMageSpells;

public class Heal extends AbstractWhiteMageSpells {

    public int manaCost() {
        return 15;
    }
    public void useWMSpell(GameCharacter gamecharacter) throws InvalidStatValueException {
        //First we have to make sure, that the method spellOnAlly is true.
        if(!this.spellOnAlly()){
            int addedHp = gamecharacter.getMaxHp();
            gamecharacter.setCurrentHp(addedHp*(3/10));
        }

    }
}
