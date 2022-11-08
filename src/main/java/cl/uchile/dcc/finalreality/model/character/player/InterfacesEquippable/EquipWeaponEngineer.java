package cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;

/**
 * Interface that allows an Engineer to equip a certain kinds of weapons.
 */

public interface EquipWeaponEngineer extends Iweapon {
  void equippableByEngineer(Engineer engineer);
}
