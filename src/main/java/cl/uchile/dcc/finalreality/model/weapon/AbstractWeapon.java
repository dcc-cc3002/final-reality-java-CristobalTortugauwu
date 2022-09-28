package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public class AbstractWeapon implements IWeapon{
    //La clase es abstracta, porque después necesitaré implementar métodos abstractos
    private final String name;
    private final int damage;
    private final int weight;

    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     */
    public AbstractWeapon(final String name, final int damage, final int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    /**
     * Returns the name of the weapon
     */
    public String getName()
    {
        return name;
    }
    /**
    * Returns the damage of the weapon
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the weight of the weapon.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight);
    }
}
