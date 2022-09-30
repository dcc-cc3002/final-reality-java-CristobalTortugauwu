package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.weapon.*;

public class MainExample {
    public static void main(String[] args) {
        //First we will create instance of the weapons
        IWeapon axe = new Axe("axe",1,1);
        IWeapon axe2 = new Axe("axe",1,1);
        IWeapon axe_distinta = new Axe("axe",2,2);
        IWeapon bow = new Bow("bow",1,1);
        IWeapon bow2 = new Bow("bow",1,1);
        IWeapon bow_distinto = new Bow("bow",2,2);
        IWeapon knife = new Knife("knife",1,1);
        IWeapon knife2 = new Knife("knife",1,1);
        IWeapon knife_distinto = new Knife("knife",2,2);
        Staff staff = new Staff("staff",1,1,1);
        Staff staff2 = new Staff("staff",1,1,1);
        Staff staff_distinto = new Staff("staff",2,2,2);
        IWeapon sword = new Sword("sword",1,1);
        IWeapon sword2 = new Sword("sword",1,1);
        IWeapon sword_distinto = new Sword("sword",2,2);
        //now we will test the equals test for every class in the weapon package
        System.out.println(axe.equals(axe2));
        System.out.println(axe2.equals(axe_distinta));
        System.out.println(axe.equals(bow));
        System.out.println(bow.equals(bow2));
        System.out.println(bow2.equals(bow_distinto));
        System.out.println(bow.equals(sword));
        System.out.println(knife.equals(knife2));
        System.out.println(knife2.equals(knife_distinto));
        System.out.println(knife.equals(sword));
        System.out.println(staff.equals(staff2));
        System.out.println(staff2.equals(staff_distinto));
        System.out.println(staff.equals(bow));
        System.out.println(sword.equals(sword2));
        System.out.println(sword2.equals(sword_distinto));
        System.out.println(sword.equals(knife));
        //we´ve finished the testing for the equals method
        System.out.println("----------------------------------");
        //now we will continue testing the methods included in the interface IWeapon,
        //and then we will test the methods that only staff has, so we can use any
        //class inheriting from the abstract class.
        System.out.println(1==knife.getDamage());
        System.out.println(1==knife.getWeight());
        System.out.println(knife.getName().equals("knife"));
        System.out.println(1==staff2.getMagicDamage());
        System.out.println(knife);
        System.out.println(staff);
    }
}
