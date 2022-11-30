package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponBlackMage;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponWhiteMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.Objects;

/**
 * Abstract Weapon class.
 */
public class Staff extends AbstractWeapon implements EquipWeaponBlackMage, EquipWeaponWhiteMage {

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

  public void equippableByBlackMage(BlackMage blackmage) {
      blackmage.setWeapon(this);
  }

  public void equippableByWhiteMage(WhiteMage whitemage) {
      whitemage.setWeapon(this);
  }

  public boolean hasMagicDamage() {
    return true;
  }
}
