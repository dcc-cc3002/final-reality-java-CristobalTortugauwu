package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.effects.Effect;

/**
 * Spell interface.
 */

public interface Spell {

  void setEffect(CompositeEffect effects);

  CompositeEffect getEffect();

  int manaCost();

  void equippableByWhiteMage(WhiteMage wm);

  void equippableByBlackMage(BlackMage bm);

  void removeObserver(WhiteMage wm);

  void removeObserver(BlackMage bm);

}
