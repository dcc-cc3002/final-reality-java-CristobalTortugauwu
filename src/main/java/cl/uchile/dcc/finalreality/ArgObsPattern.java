package cl.uchile.dcc.finalreality;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This class exists because we will use it to update the information that changes
 * in the observable, so that the observers subscribed will be updated.
 */
public class ArgObsPattern {

  private String action;

  private GameCharacter pc;

  private int newHp;

  private int newMana;

  public ArgObsPattern(String action, GameCharacter pc, int newHp, int newMana) {

    this.action = action;

    this.pc = pc;

    this.newHp = newHp;

    this.newMana = newMana;
  }

  public String getAction() {
      return action;
  }

  public GameCharacter getGameCharacter() {
      return this.pc;
  }

  public int getNewHp() {
      return this.newHp;
  }

  public int getNewMana() {
      return this.newMana;
  }
}
