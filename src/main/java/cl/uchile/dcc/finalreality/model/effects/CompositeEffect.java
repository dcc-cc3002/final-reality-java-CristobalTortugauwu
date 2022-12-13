package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.HashSet;

/**
 * CompositeEffect class.
 */
public class CompositeEffect implements Effect {

  private HashSet<Effect> effects = new HashSet<Effect>();

  /**
   *Getter for the HashSet.
   */
  public HashSet<Effect> getHashSet() {
    return this.effects;
  }

  /**
   *This method can apply all the effect that are contained in the HashSet.
   */
  public void applyEffect(GameCharacter gc) {

    for (Effect i : this.getHashSet()) {
      i.applyEffect(gc);
    }

  }

  public void addEffect(Effect effect) {
    if(effect.equals(null)) {
      return;
    }
    effects.add(effect);
  }

  public void removeEffect(Effect effect) {
    effects.remove(effect);
  }

}
