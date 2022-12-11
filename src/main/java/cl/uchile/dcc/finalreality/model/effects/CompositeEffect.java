package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.HashSet;

public class CompositeEffect implements Effect {

  private HashSet<Effect> effects = new HashSet<Effect>();

  public HashSet<Effect> getHashSet() {
    return this.effects;
  }

  //Quiero que los efectos sean únicos, para que no se acumulen (?) ayudaaaa
  public void applyEffect(GameCharacter gc) {

    for (Effect i : this.getHashSet()) {
      i.applyEffect(gc);
    }

  }

  public void addEffect(Effect effect) {
    effects.add(effect);
  }

  public void removeEffect(Effect effect) {
    effects.remove(effect);
  }

}
