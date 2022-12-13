package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.*;


/**
 * NullWeapon Class.
 */
public class NullWeapon implements Iweapon {

  public NullWeapon() {

  }

  @Override
  public boolean hasMagicDamage() {
    return false;
  }

  @Override
  public void equippableByKnight(Knight knight) {

  }

  @Override
  public void equippableByWhiteMage(WhiteMage whitemage) {

  }

  @Override
  public void equippableByBlackMage(BlackMage blackmage) {

  }

  @Override
  public void equippableByEngineer(Engineer engineer) {

  }

  @Override
  public void equippableByThief(Thief thief) {

  }

  @Override
  public int getDamage() {
    return 0;
  }

  @Override
  public int getWeight() {
    return 0;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public boolean isNull() {
    return true;
  }
}
