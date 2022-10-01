package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;

//By the moment, this class will only have a constructor, latter on we will implement
//new methods, including abstract ones.

/**
 * AbstractOrdinary Class.
 */
public abstract class AbstractOrdinary extends AbstractPlayerCharacter {
  /**
   *AbstractOrdinary constructor.
   */
  public AbstractOrdinary(String name, int maxHp, int defense,
                          BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }
}
