package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.IWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Sword;

public class MainExample {
    public static void main(String[] args) {
        //primero crearemos instancias de los weapons
        IWeapon axe = new Axe("axe",1,1);
        IWeapon axe2 = new Axe("axe",1,1);
        IWeapon axe_distinta = new Axe("axe",2,2);
        IWeapon bow = new Bow("bow",1,1);
        IWeapon sword = new Sword("sword",1,1);
        System.out.println(axe.equals(axe2));
        System.out.println(axe2.equals(axe_distinta));
        System.out.println(bow.equals(bow));
        System.out.println("hola");
    }
    //Preguntar sobre el metodo equals en la clase abstracta, pero instanciado con una interfaz
    //Además mover ciertas parámetros que pueden ir en AbstractMage y

}
