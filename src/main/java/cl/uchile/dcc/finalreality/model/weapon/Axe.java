package cl.uchile.dcc.finalreality.model.weapon;

public class Axe extends AbstractWeapon{
    public Axe(final String name, final int damage, final int weight){
        super(name,damage,weight);
    }

    /**
     * Equals method for the Axe class
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass()!=o.getClass()){
            return false;
        }
        Axe axe = (Axe) o;
        return this.getName().equals(axe.getName()) && this.getWeight()==axe.getWeight()
                && this.getDamage()==axe.getDamage();
    }
}
