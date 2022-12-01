package cl.uchile.dcc.finalreality.model.spells.WMSpells;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Paralyzed;

public class Paralysis extends AbstractWhiteMageSpells implements WhiteMageSpells {

    public int manaCost() {
        return 25;
    }
    public void useWMSpell(GameCharacter gamecharacter){
        if(this.spellOnAlly()){
             //At this point, we're sure that we can use the spell on an enemy.
             Enemy enemy = (Enemy) gamecharacter;
             CompositeEffect effect = enemy.getEffects();
             effect.addEffect(new Paralyzed());
             enemy.setEffects(effect);
        }
    }
}
