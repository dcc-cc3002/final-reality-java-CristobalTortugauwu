package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;


/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * We will use observable instead of propertychangesupport because it´s easier XD,
 * I will change it after I've delivered the last task
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractCharacter extends Observable implements GameCharacter {

  //attributes of the character
  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final String name;

  //Queue elements
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;

  //Observer Pattern variable

  /**
   * Creates a new character.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
                              @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
  }

  /**
   * Equals method that will be used for al GameCharacters, we did not include turnsQueue
   * because it´s different for every instance.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameCharacter that = (GameCharacter) o;
    return maxHp == that.getMaxHp() && defense == that.getDefense() && name.equals(that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxHp, defense, name);
  }

  /**
   * This method is used with the purpose in which the GameCharacters will wait in a specific Queue.
   */
  @Override
  public abstract void waitTurn();


  /**
   * {@inheritDoc}
   */
  public void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  void error() {
    throw new AssertionError("You can't attack this character");
  }

  ;

  public abstract void attack(GameCharacter target) throws InvalidStatValueException;

  public void attackableByPlayerCharacter(PlayerCharacter pc) throws InvalidStatValueException {
    error();
  }

  public void attackableByEnemy(Enemy enemy) throws InvalidStatValueException {
    error();
  }

  //---------Section of the observer pattern methods.-----------

  /**
   * Method that adds a new observer.
   * @param controller   an observer to be added.
   */

}
