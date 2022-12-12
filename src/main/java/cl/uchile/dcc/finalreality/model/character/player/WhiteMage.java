/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import cl.uchile.dcc.finalreality.model.character.player.validspell.ValidWhiteMageSpell;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.spells.whitemagespells.WhiteMageSpells;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class WhiteMage extends AbstractMage {

  private WhiteMageSpells spell;
  /**
   * Creates a new character.
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
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMana, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue, maxMana);
  }

  /**
   * Returns a string with the fields and the name of the class.
   */
  @Override
  public String toString() {
    return "WhiteMage{maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(this.getMaxMana(), maxHp, defense, name);
  }

  @Override
  public void equip(Iweapon weapon) {
      weapon.equippableByWhiteMage(this);
  }

  public void setSpell(WhiteMageSpells spell) {
      this.spell = spell;
  }

  public WhiteMageSpells getSpell() {
      return this.spell;
  }

  @Override
  public void equipSpell(Spell spell) {
    spell.equippableByWhiteMage(this);
  }

  public void useSpell(GameCharacter character) throws InvalidStatValueException {
      //First we check if the mage has enough mana to use the spell

      WhiteMageSpells spell = this.getSpell();
      int totalMana = (this.getCurrentMana()-spell.manaCost());
      if (totalMana<0)
        //If the mage doesn't have enough mana, it can't use the spell
        return;
      Staff weapon = (Staff) this.getEquippedWeapon();
      if (!weapon.isNull()) {
        character.receiveWhiteMageSpell(this);
      }
  }
}
