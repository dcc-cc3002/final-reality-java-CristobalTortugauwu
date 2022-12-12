package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.ArgObsPattern;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidBlackMageSpell;
import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidWhiteMageSpell;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.effects.CompositeEffect;
import cl.uchile.dcc.finalreality.model.spells.blackmagespells.BlackMageSpells;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.WhiteMageSpells;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 */
public class Enemy extends AbstractCharacter implements ValidBlackMageSpell, ValidWhiteMageSpell {

  private final int weight;

  private CompositeEffect effects;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   *Equals method for the Enemy class, we did not consider the turnsQueue parameter in the
   * input, because for every instance of an object, they can´t share a turn.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Enemy enemy = (Enemy) o;
    return weight == enemy.weight;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ this.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), weight, this.getClass());
  }

  /**
   * Returns a string with the fields and the name of the class.
   */
  @Override
  public String toString() {
    return "Enemy{name='%s', damage=%d, weight=%d,, class='%s'}"
            .formatted(getName(), getMaxHp(), getWeight(), getClass().getSimpleName());
  }

  public void setEffects(CompositeEffect ce) {
    this.effects = ce;
  }

  public CompositeEffect getEffects() {
    return this.effects;
  }

  @Override
  public void attack(GameCharacter target) throws InvalidStatValueException {
    target.attackableByEnemy(this);
  }

  @Override
  public void attackableByPlayerCharacter(PlayerCharacter pc) throws InvalidStatValueException {
    int enemyHp = this.getCurrentHp();
    Iweapon weapon = pc.getEquippedWeapon();
    //If the weapon is not null, then the attack will be valid
    if (!weapon.isNull()) {
      int newHp = enemyHp - weapon.getDamage();
      setChanged();
      notifyObservers(new ArgObsPattern("attackByPlayerCharacter", this,newHp,0));
    }
  }

  @Override
  public void receiveBMSpell(BlackMage blackmage) throws InvalidStatValueException {
    //We know that this weapon, has magicDamage. Pero sería mejor tener
    //una clase que represente a los weapons que tengan magic damage, para que sea extensible.
    //Por ahora dejemoslo así XD
    Staff weapon = (Staff) blackmage.getEquippedWeapon();
    BlackMageSpells spell = blackmage.getSpell();
    int md = weapon.getMagicDamage();
    spell.useBlackMageSpell(this, md);
  }

  @Override
  public void receiveWhiteMagicSpell(WhiteMage whitemage) throws InvalidStatValueException {
    WhiteMageSpells spell = whitemage.getSpell();
    spell.useWhiteMageSpell(this);
  }

}
