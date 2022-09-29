package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class AbstractMage extends AbstractPlayerCharacter implements MagesCharacter{
    private int mana;

    public AbstractMage(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue, int mana) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
        this.mana=mana;
    }
    /**
     * Equals method for mages
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MagesCharacter that = (MagesCharacter) o;
        return mana == that.getMana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mana);
    }
    //mover el max mana y el current mana a esta clase :D
    /**
     * Returns the mana
     */
     public int getMana(){
         return mana;
     }
}
