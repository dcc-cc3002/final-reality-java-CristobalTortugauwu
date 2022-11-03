package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Knife class.
 */
public class Knife extends  AbstractWeapon {
  /**
   * Knife Class constructor.
   */
  public Knife(final String name, final int damage, final int weight) {
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
