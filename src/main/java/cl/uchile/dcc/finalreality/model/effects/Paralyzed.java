package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.Objects;

/**
 * Paralyzed class effect.
 */
public class Paralyzed implements Effect {

  private String name;

  public Paralyzed(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paralyzed paralyzed = (Paralyzed) o;
    return Objects.equals(name, paralyzed.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public void applyEffect(GameCharacter gc) {

  }

}
