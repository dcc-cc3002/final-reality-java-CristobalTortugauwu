/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidBlackMageSpell;
import cl.uchile.dcc.finalreality.model.spells.blackmagespells.BlackMageSpells;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.0
 */
public class BlackMage extends AbstractMage {

  private BlackMageSpells spell;
  /**
   * Creates a new Black Mage.
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
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMana, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue, maxMana);
    Require.statValueAtLeast(0, maxMana, "Max MP");
  }
  /**
   * Returns a string with the fields and the name of the class.
   */

  @Override
  public String toString() {
    return "BlackMage{currentMp=%d, maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(this.getCurrentMana(), this.getMaxMana(), maxHp, defense, name);
  }

  public void equip(Iweapon weapon) {
    weapon.equippableByBlackMage(this);
  }

  public void setSpell(BlackMageSpells spell) {
      this.spell = spell;
  }

  public BlackMageSpells getSpell() {
    return this.spell;
  }

  public void useSpell(ValidBlackMageSpell enemy) throws InvalidStatValueException {
    //First we check if the mage has enough mana to use the spell
    BlackMageSpells spell = this.getSpell();
    int totalMana = (this.getCurrentMana()-spell.manaCost());
    if(totalMana<0)
        //If the mage doesn't have enough mana, it can't use the spell
        return;
    //If the object has magic damage, it can use spells, otherwise it won't
    Staff weapon = (Staff) this.getEquippedWeapon();
    if(this.getEquippedWeapon().hasMagicDamage() && !weapon.isNull())
          //implementar ataque
          enemy.receiveBMSpell(this);
  }

}
