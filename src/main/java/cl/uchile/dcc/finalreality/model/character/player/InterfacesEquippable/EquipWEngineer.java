package cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;

public interface EquipWEngineer extends Iweapon {
    void equippableByEngineer(Engineer engineer);
}
