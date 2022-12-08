package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.*;

/**
 * Interface Weapon.
 */
public interface Iweapon {
  int getDamage();

  int getWeight();

  String getName();

  boolean isNull();

  boolean hasMagicDamage();

  void equippableByKnight(Knight knight);

  void equippableByWhiteMage(WhiteMage whitemage);

  void equippableByBlackMage(BlackMage blackmage);

  void equippableByEngineer(Engineer engineer);

  void equippableByThief(Thief thief);


}
