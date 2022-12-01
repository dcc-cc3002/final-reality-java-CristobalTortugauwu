package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

public abstract class AbstractSpell implements Spell {
    private CompositeEffect effect;

    public void setEffect(CompositeEffect effect) {
        this.effect = effect;
    }

    public CompositeEffect getEffect() {
        return this.effect;
    }

    /**
     * This method exists solely with the purpose to verify if a spell can
     * be used in an enemy or an ally. It's return false in case that it can be used on
     * an enemy, and true otherwise.
     * @return
     */
    public boolean spellOnAlly() {
        return false;
    }

    public abstract int manaCost();

}
