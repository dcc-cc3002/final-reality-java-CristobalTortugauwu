package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

public class AbstractSpell implements Spell {
    private CompositeEffect effect;

    public void setEffect(CompositeEffect effect) {
        this.effect = effect;
    }

    public CompositeEffect getEffect() {
        return this.effect;
    }

}
