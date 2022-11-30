/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.attackable.AttackableByEnemy;
import cl.uchile.dcc.finalreality.model.character.player.attackable.AttackableByPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Iweapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter, AttackableByEnemy {

  private Iweapon equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
                  /* command = */ this::addToQueue,
                  /* delay = */ this.getEquippedWeapon().getWeight() / 10,
                  /* unit = */ TimeUnit.SECONDS);
  }

  public void setWeapon(Iweapon weapon) {
    equippedWeapon = weapon;
  }

  @Override
  public Iweapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.getClass());
  }
  public void attack(AttackableByPlayerCharacter attacked) throws InvalidStatValueException {
    attacked.attackableByPlayerCharacter(this);
  }

  public void attackableByEnemy(Enemy enemy) throws InvalidStatValueException {
    int playerHp = this.getCurrentHp();
    int newHp = playerHp - enemy.getWeight();
    if(newHp<=0)
        this.setCurrentHp(0);
    else
        this.setCurrentHp(newHp);
  }
}
