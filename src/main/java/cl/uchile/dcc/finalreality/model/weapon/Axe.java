package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Axe class.
 */
public class Axe extends AbstractWeapon {
  /**
   * Axe constructor.
   */
  public Axe(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }
  /**
   * HashCode methods
   */
  @Override
  public int hashCode(){
    return Objects.hash(super.hashCode());
  }
}
