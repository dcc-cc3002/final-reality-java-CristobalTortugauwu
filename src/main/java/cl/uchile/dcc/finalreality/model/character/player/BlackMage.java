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
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.InterfacesEquippable.EquipWeaponBlackMage;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.player.ValidSpell.ValidBMSpell;
import cl.uchile.dcc.finalreality.model.spells.BMSpells.BlackMageSpells;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.0
 */
public class BlackMage extends AbstractMage {

  BlackMageSpells spell;
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

  public void equip(EquipWeaponBlackMage weapon) {
    weapon.equippableByBlackMage(this);
  }

  public void setSpell(BlackMageSpells spell) {
      this.spell = spell;
  }

  public BlackMageSpells getSpell() {
    return this.spell;
  }
  //Implementar double dispatch, porque podrían haber enemigos inmunes a cierta magia
  public void useSpell(ValidBMSpell enemy) throws InvalidStatValueException {
      //If the object has magic damage, it can use spells, otherwise it won't
      if(this.getEquippedWeapon().hasMagicDamage())
          //implementar ataque
          enemy.receiveBMSpell(this);
  }

}
