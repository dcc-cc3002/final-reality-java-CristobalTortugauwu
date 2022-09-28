package cl.uchile.dcc.finalreality.model.weapon;

public class Knife extends  AbstractWeapon{
    public Knife(final String name, final int damage, final int weight){
        super(name,damage,weight);
    }

    /**
     *Equals method for the Knife class
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass()!=o.getClass()){
            return false;
        }
        Knife knife = (Knife) o;
        return this.getName().equals(knife.getName()) && this.getWeight()==knife.getWeight()
                && this.getDamage()==knife.getDamage();
    }
}
