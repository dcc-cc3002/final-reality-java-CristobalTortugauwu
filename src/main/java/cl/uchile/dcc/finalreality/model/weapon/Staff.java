package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * Abstract Weapon class.
 */
public class Staff extends AbstractWeapon {

  private final int magicDamage;

  public Staff(final String name, final int damage, final int weight, final int magicDamage) {
    super(name, damage, weight);
    this.magicDamage = magicDamage;
  }

  /**
  *Returns the magicDamage.
  */
  public int getMagicDamage() {
    return magicDamage;
  }

  /**
   *Equals method for the staff class.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Staff staff = (Staff) o;
    return magicDamage == staff.getMagicDamage();
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, magic= %d, class='%s'}".formatted(getName(),
            getDamage(), getWeight(), getMagicDamage(), getClass().getSimpleName());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), magicDamage);
  }
}
