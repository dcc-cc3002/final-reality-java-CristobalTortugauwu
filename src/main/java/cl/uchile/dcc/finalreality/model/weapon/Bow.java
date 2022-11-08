package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWEngineer;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWThief;
import cl.uchile.dcc.finalreality.model.character.player.Thief;

import java.util.Objects;

/**
 * Bow class.
 */
public class Bow extends AbstractWeapon implements EquipWEngineer, EquipWThief {
  /**
   *  Bow class constructor.
   */
  public Bow(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }
  /**
   * HashCode method
   */
  @Override
  public int hashCode(){
    return Objects.hash(super.hashCode());
  }

  public void equippableByEngineer(Engineer engineer){
    engineer.setWeapon(this);
  }

  public void equippableByThief(Thief thief){
    thief.setWeapon(this);
  }
}
