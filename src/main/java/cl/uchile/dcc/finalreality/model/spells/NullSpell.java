package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

public class NullSpell implements Spell {

  void spellError() {
    throw new AssertionError("NullSpell");
  }

  @Override
  public void setEffect(CompositeEffect effects) {
    spellError();
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

  @Override
  public void equippableByWhiteMage(WhiteMage wm) {
    spellError();
  }

  @Override
  public void equippableByBlackMage(BlackMage bm) {
    spellError();
  }
}
