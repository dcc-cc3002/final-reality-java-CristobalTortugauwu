package cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable;

import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;


public interface EquipWKnight extends Iweapon {
    void equippableByKnight(Knight knight);

}
