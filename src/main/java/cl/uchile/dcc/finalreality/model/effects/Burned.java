package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

/**
 * Burned effect class.
 */
public class Burned implements Effect {

  private String name;

  public Burned(String name) {
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
    Burned burned = (Burned) o;
    return Objects.equals(name, burned.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public void applyEffect(GameCharacter gc) {
        //mismo comentario que en paralyzed.
  }
}
