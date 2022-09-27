package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.concurrent.BlockingQueue;

public class AbstractOrdinary extends AbstractPlayerCharacter{
    public AbstractOrdinary(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
    }
}
