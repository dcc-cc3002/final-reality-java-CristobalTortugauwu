package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon{

    private int magicDamage;
    public Staff(final String name, final int damage, final int weight,final int magicDamage){
        super(name,damage,weight);
        this.magicDamage =magicDamage;
    }

    /**
     *Return the magicDamage
     */
    public int getMagicDamage(){
        return magicDamage;
    }

    /**
     *Equals method for the staff class
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass()!=o.getClass()){
            return false;
        }
        Staff staff = (Staff) o;
        return this.getName().equals(staff.getName()) && this.getWeight()==staff.getWeight()
                && this.getDamage()==staff.getDamage() && this.getMagicDamage()==staff.getMagicDamage();
    }

}
