package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.concurrent.BlockingQueue;

public class AbstractMage extends AbstractPlayerCharacter{
    private double mana;

    public AbstractMage(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue, double mana) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
        this.mana=mana;
    }

}
