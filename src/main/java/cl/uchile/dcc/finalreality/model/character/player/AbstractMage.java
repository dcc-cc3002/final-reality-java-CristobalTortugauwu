package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractMage extends AbstractPlayerCharacter implements MagesCharacter{
    private int MaxMana;

    private int currentMana;


    public AbstractMage(String name, int maxHp, int defense, BlockingQueue<GameCharacter> turnsQueue, int MaxMana) throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
        this.MaxMana=MaxMana;
        this.currentMana=MaxMana;
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
        return MaxMana == that.getMaxMana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MaxMana);
    }
    //mover el max mana y el current mana a esta clase :D
    /**
     * Returns the mana
     */
     public int getMaxMana(){
         return MaxMana;
     }
    /**
     * Return the current mana
     */
    public int getCurrentMana(){
        return currentMana;
    }
    /**
     * Sets the character's current Mana.
     */
    public void setCurrentMana(final int currentMana) throws InvalidStatValueException {
        Require.statValueAtLeast(0, currentMana, "Current Mana");
        Require.statValueAtMost(MaxMana, currentMana, "Current Mana");
        this.currentMana = currentMana;
    }
}
