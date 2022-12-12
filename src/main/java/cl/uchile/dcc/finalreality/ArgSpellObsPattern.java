package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * Argument used in the notify method on the Spells hierarchy.
 */
public class ArgSpellObsPattern {

  int newMana;

  GameCharacter mage;

  ArgObsPattern arg;

  /**
   *Constructor.
   */
  public ArgSpellObsPattern(GameCharacter mage, int newMana, ArgObsPattern arg) {
    this.mage = mage;
    this.newMana = newMana;
    this.arg = arg;
  }

  public int getNewMana() {
    return newMana;
  }

  public GameCharacter getMage() {
    return mage;
  }

  public ArgObsPattern getArg() {
    return arg;
  }

  public void setMage(GameCharacter gc) {
    this.mage = gc;
  }

  public void setMana(int newMana) {
    this.newMana = newMana;
  }
}
