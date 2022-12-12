package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

//We implemented this interface by now, because we want to
//cast inside the equals methods, so we don´t use a cast with an abstract type

/**
 * Mage interface.
 */
public interface MagesCharacter extends PlayerCharacter {

  int getMaxMana();

  int getCurrentMana();

  void setCurrentMana(int mana)  throws InvalidStatValueException;

}
