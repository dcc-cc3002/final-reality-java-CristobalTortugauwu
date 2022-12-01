package cl.uchile.dcc.finalreality.model.spells.WMSpells;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;
import cl.uchile.dcc.finalreality.model.spells.WMSpells.WhiteMageSpells;

public class Poison extends AbstractWhiteMageSpells {

    public int manaCost() {
        return 40;
    }

    public void useWMSpell(GameCharacter gamecharacter){
        if(this.spellOnAlly()){
            //At this point, we're sure that we can use the spell on an enemy.
            Enemy enemy = (Enemy) gamecharacter;
            CompositeEffect effect = enemy.getEffects();
            effect.addEffect(new Poisoned());
            enemy.setEffects(effect);
        }
    }

}
