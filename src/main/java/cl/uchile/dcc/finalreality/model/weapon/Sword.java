package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWThief;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWKnight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;

import java.util.Objects;

/**
 * Sword class.
 */
public class Sword extends AbstractWeapon implements EquipWKnight, EquipWThief {
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

  public void equippableByKnight(Knight knight){
    knight.setWeapon(this);
  }

  public void equippableByThief(Thief thief){
    thief.setWeapon(this);
  }
}
