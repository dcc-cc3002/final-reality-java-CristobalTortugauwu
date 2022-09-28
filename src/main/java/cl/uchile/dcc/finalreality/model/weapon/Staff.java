package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon{

    private int magicDamage;
    public Staff(final String name, final int damage, final int weight,final int magicDamage){
        super(name,damage,weight);
        this.magicDamage =magicDamage;
    }
    //agregar los métodos equals en todas las armas, y dps modificar los equals del paquete player
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return magicDamage == staff.magicDamage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magicDamage);
    }
}
