package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Sword class.
 */
public class Sword extends AbstractWeapon {
  /**
   * Sword class constructor.
   * */
  public Sword(final String name, final int damage, final int weight) {
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
