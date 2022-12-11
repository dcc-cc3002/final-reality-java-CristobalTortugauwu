package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

import java.util.Observer;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public interface GameCharacter {

  /**
   * Adds this character to the turns queue.
   */
  void addToQueue();

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   *
    */
  void attack(GameCharacter gamecharacter) throws InvalidStatValueException;

  void attackableByPlayerCharacter(PlayerCharacter pc) throws InvalidStatValueException;

  void attackableByEnemy(Enemy enemy) throws InvalidStatValueException;

  //Section of the methods implemented for the Observer pattern
  void addObserver(Observer controller);

  void removeObserver(Observer controller);
}
