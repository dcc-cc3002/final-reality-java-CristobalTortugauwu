package cl.uchile.dcc.finalreality;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Effect;

/**
 * This class exists because we will use it to update the information that changes
 * in the observable, so that the observers subscribed will be updated.
 */
public class ArgObsPattern {

  private String action;

  private GameCharacter pc;

  private int newHp;

  //In the future I'll change it to an arrayList.
  private Effect effects;

  /**
   *ArsObsPattern constructor.
   */
  public ArgObsPattern(String action, GameCharacter pc, int newHp, Effect effects) {

    this.action = action;
    this.pc = pc;
    this.newHp = newHp;
    this.effects = effects;
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

  public Effect getEffect() {
    return this.effects;
  }
}
