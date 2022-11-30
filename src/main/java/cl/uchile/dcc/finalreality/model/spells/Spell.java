package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Effect;

public interface Spell {

    void setEffect(CompositeEffect effects);

    CompositeEffect getEffect();
}
