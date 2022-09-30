package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon{

    private final int magicDamage;
    public Staff(final String name, final int damage, final int weight,final int magicDamage){
        super(name,damage,weight);
        this.magicDamage =magicDamage;
    }

    /**
     *Returns the magicDamage
     */
    public int getMagicDamage(){
        return magicDamage;
    }

    /**
     *Equals method for the staff class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return magicDamage == staff.getMagicDamage();
    }

    /**
     * Returns a string with the fields and the name of the class
     */
    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d, magic= %d, class='%s'}"
                .formatted(getName(), getDamage(), getWeight(),getMagicDamage(),getClass().getSimpleName());
    }

    /**
     * HashCode function returns an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magicDamage);
    }
}
