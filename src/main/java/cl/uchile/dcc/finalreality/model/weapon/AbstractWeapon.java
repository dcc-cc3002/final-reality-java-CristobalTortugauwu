package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractWeapon implements Iweapon {
  //La clase es abstracta, porque después necesitaré implementar métodos abstractos
  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Iweapon that = (Iweapon) o;
    return damage == that.getDamage() && weight == that.getWeight() && name.equals(that.getName());
  }

  /**
   * HashCode function returns an int.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, damage, weight, this.getClass());
  }

  /**
   * Returns the name of the weapon.
  */
  public String getName() {
    return name;
  }

  /**
  * Returns the damage corresponding of the weapon.
  **/
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }
  /**
   * Returns a string with the details of the fields and the class name.
   */

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, class='%s'}"
            .formatted(name, damage, weight, getClass().getSimpleName());
  }

  public boolean isNull() {
    return false;
  }

  public boolean hasMagicDamage() {
    return false;
  }
}
