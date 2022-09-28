package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.concurrent.BlockingQueue;

public class AbstractMage extends AbstractPlayerCharacter{
    private int mana;

    public AbstractMage(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue, int mana) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
        this.mana=mana;
    }
     //mover el max mana y el current mana a esta clase :D
    /**
     * Returns the mana
     */
     public int getMana(){
         return mana;
     }
}
