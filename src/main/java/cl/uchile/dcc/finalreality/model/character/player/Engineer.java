/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class Engineer extends AbstractOrdinary {


  /**
   * Creates a new engineer.
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
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Engineer{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  /**
   *Equals method for the Engineer class
   */
  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if (o == null || getClass() != o.getClass())
      return false;
    Engineer engineer = (Engineer) o;
    return this.getName().equals(engineer.getName()) && this.getDefense()==engineer.getDefense()
            && this.getMaxHp()==engineer.getMaxHp();
  }

}
