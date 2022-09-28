package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.concurrent.BlockingQueue;

public class AbstractOrdinary extends AbstractPlayerCharacter{
    //Por ahora solo tendra un constructor, ya que aún no hay métodos que implementar
    public AbstractOrdinary(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
    }
}
