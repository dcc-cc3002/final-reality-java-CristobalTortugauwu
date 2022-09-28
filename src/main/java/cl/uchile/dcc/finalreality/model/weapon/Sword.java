package cl.uchile.dcc.finalreality.model.weapon;

public class Sword extends AbstractWeapon{
    public Sword(final String name, final int damage, final int weight){
        super(name,damage,weight);
    }

    /**
     *Equals method for the Sword class
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass()!=o.getClass()){
            return false;
        }
        Sword sword = (Sword) o;
        return this.getName().equals(sword.getName()) && this.getWeight()==sword.getWeight()
                && this.getDamage()==sword.getDamage();
    }
}
