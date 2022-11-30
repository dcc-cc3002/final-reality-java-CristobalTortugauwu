package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.attackable.AttackableByEnemy;
import cl.uchile.dcc.finalreality.model.character.player.attackable.AttackableByPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Enemy extends AbstractCharacter implements AttackableByPlayerCharacter {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   *Equals method for the Enemy class, we did not consider the turnsQueue parameter in the
   * input, because for every instance of an object, they can´t share a turn.
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
    Enemy enemy = (Enemy) o;
    return weight == enemy.weight;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ this.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), weight, this.getClass());
  }

  /**
   * Returns a string with the fields and the name of the class.
   */
  @Override
  public String toString() {
    return "Enemy{name='%s', damage=%d, weight=%d,, class='%s'}"
            .formatted(getName(), getMaxHp(), getWeight(), getClass().getSimpleName());
  }

  public void attack(AttackableByEnemy attacked) throws InvalidStatValueException {
    attacked.attackableByEnemy(this);
  }

  public void attackableByPlayerCharacter(PlayerCharacter pc) throws InvalidStatValueException {
    this.setCurrentHp(this.getCurrentHp()-pc.getEquippedWeapon().getDamage());
  }
}
