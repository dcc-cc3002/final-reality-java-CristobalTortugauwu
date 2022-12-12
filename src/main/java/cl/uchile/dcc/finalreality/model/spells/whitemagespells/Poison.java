package cl.uchile.dcc.finalreality.model.spells.whitemagespells;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Poisoned;


public class Poison extends AbstractWhiteMageSpells {

  public Poison(String name) {
    super(name);
  }

  public int manaCost() {
    return 40;
  }

  public void useWhiteMageSpell(GameCharacter gamecharacter) {
    Enemy enemy = (Enemy) gamecharacter;
    CompositeEffect effect = enemy.getEffects();
    effect.addEffect(new Poisoned());
    enemy.setEffects(effect);
  }

}
