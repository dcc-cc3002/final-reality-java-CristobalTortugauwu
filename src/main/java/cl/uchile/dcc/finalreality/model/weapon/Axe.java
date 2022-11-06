package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWEngineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWKnight;

import java.util.Objects;

/**
 * Axe class.
 */
public class Axe extends AbstractWeapon implements EquipWKnight, EquipWEngineer {
  /**
   * Axe constructor.
   */
  public Axe(final String name, final int damage, final int weight) {
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
  public void equippableByEngineer(Engineer engineer){
    engineer.setWeapon(this);
  }
}
