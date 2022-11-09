package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * AbstractMage Class.
 */
public abstract class AbstractMage extends AbstractPlayerCharacter implements MagesCharacter {
  private final int maxMana;
  private int currentMana;

  /**
   * AbstractMage constructor.
   * */
  public AbstractMage(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue,
                      int maxMana) throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    this.maxMana = maxMana;
    this.currentMana = maxMana;
  }
  /**
   * Equals method for mages.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MagesCharacter that = (MagesCharacter) o;
    return maxMana == that.getMaxMana();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), maxMana);
  }

  /**
   * Returns the mana.
   */
  public int getMaxMana() {
    return maxMana;
  }

  /**
  * * Return the current mana.
  */
  public int getCurrentMana() {
    return currentMana;
  }

  /**
  * Sets the character's current Mana.
  */
  public void setCurrentMana(final int currentMana) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMana, "Current Mana");
    Require.statValueAtMost(maxMana, currentMana, "Current Mana");
    this.currentMana = currentMana;
  }
}
