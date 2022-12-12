package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidBlackMageSpell;
import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidWhiteMageSpell;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;

import java.util.Objects;
import java.util.Observable;

public abstract class AbstractSpell extends Observable implements Spell {

  private String name;

  private CompositeEffect effect;

  public AbstractSpell(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractSpell that = (AbstractSpell) o;
    return Objects.equals(name, that.name) && Objects.equals(effect, that.effect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, effect);
  }

  public void setEffect(CompositeEffect effect) {
    this.effect = effect;
  }

  public CompositeEffect getEffect() {
    return this.effect;
  }

  public abstract int manaCost();

  void error() {
    throw new AssertionError("No se puede equipar este hechizo");
  };

  @Override
  public void equippableByWhiteMage(WhiteMage wm) {
    error();
  }

  @Override
  public void equippableByBlackMage(BlackMage bm) {
    error();
  }

}
