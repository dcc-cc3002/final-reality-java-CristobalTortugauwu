package cl.uchile.dcc.finalreality.model.weapon;

public class Bow extends AbstractWeapon{
    public Bow(final String name, final int damage, final int weight){
        super(name,damage,weight);
    }

    /**
     * Equals method for the Bow class
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass()!=o.getClass()){
            return false;
        }
        Bow bow = (Bow) o;
        return this.getName().equals(bow.getName()) && this.getWeight()==bow.getWeight()
                && this.getDamage()==bow.getDamage();
    }
}
