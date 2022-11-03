package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Bow class.
 */
public class Bow extends AbstractWeapon {
  /**
   *  Bow class constructor.
   */
  public Bow(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }
  /**
   * HashCode method
   */
  @Override
  public int hashCode(){
    return Objects.hash(super.hashCode());
  }
}
