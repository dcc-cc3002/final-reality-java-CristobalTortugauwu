package cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable;

import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;

/**
 * Interface that allows a Knight to equip a certain kinds of weapons.
 */

public interface EquipWeaponKnight extends Iweapon {
  void equippableByKnight(Knight knight);

}
