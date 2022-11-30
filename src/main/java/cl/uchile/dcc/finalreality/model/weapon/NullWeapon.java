package cl.uchile.dcc.finalreality.model.weapon;

public class NullWeapon implements Iweapon{

    public NullWeapon() {

    }
    @Override
    public boolean hasMagicDamage(){
        return false;
    }
    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
