package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

public class NullSpell implements Spell {

  @Override
  public void setEffect(CompositeEffect effects) {

  }

  @Override
  public CompositeEffect getEffect() {
    return null;
  }

  @Override
  public boolean spellOnAlly() {
    return false;
  }

  @Override
  public int manaCost() {
    return 0;
  }
}
