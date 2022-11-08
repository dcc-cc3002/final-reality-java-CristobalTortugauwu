package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponBlackMage;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponKnight;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponThief;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import java.util.Objects;

/**
 * Knife class.
 */
public class Knife extends  AbstractWeapon implements EquipWeaponKnight,
        EquipWeaponThief, EquipWeaponBlackMage {
  /**
   * Knife Class constructor.
   */
  public Knife(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  /**
   * HashCode method.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  public void equippableByKnight(Knight knight) {
    knight.setWeapon(this);
  }

  public void equippableByThief(Thief thief) {
    thief.setWeapon(this);
  }

  public void equippableByBlackMage(BlackMage blackmage) {
    blackmage.setWeapon(this);
  }

}
