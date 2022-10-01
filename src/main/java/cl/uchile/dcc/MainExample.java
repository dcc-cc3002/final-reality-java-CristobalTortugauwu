package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Main example.
 */
public class MainExample {
  /**
   * Static method created with the purpose of running all the test.
   */
  public static void main(String[] args) throws InterruptedException, InvalidStatValueException {
    //First we will create instance of the weapons
    Iweapon axe = new Axe("axe", 1, 1);
    Iweapon axe2 = new Axe("axe", 1, 1);
    Iweapon axeDistinta = new Axe("axe", 2, 2);
    Iweapon bow = new Bow("bow", 1, 1);
    Iweapon bow2 = new Bow("bow", 1, 1);
    Iweapon bowDistinto = new Bow("bow", 2, 2);
    Iweapon knife = new Knife("knife", 1, 1);
    Iweapon knife2 = new Knife("knife", 1, 1);
    Iweapon knifeDistinto = new Knife("knife", 2, 2);
    Staff staff = new Staff("staff", 1, 1, 1);
    Staff staff2 = new Staff("staff", 1, 1, 1);
    Staff staffDistinto = new Staff("staff", 2, 2, 2);
    Iweapon sword = new Sword("sword", 1, 1);
    Iweapon sword2 = new Sword("sword", 1, 1);
    Iweapon swordDistinto = new Sword("sword", 2, 2);
    //now we will test the equals test for every class in the weapon package
    System.out.println("----------------Testing equals methods in weapons--------");
    System.out.println(axe.equals(axe2));
    System.out.println(axe2.equals(axeDistinta));
    System.out.println(axe.equals(bow));
    System.out.println(bow.equals(bow2));
    System.out.println(bow2.equals(bowDistinto));
    System.out.println(bow.equals(sword));
    System.out.println(knife.equals(knife2));
    System.out.println(knife2.equals(knifeDistinto));
    System.out.println(knife.equals(sword));
    System.out.println(staff.equals(staff2));
    System.out.println(staff2.equals(staffDistinto));
    System.out.println(staff.equals(bow));
    System.out.println(sword.equals(sword2));
    System.out.println(sword2.equals(swordDistinto));
    System.out.println(sword.equals(knife));
    //we´ve finished the testing for the equals method
    System.out.println("-------Testing getters-----------");
    //now we will continue testing the methods included in the interface IWeapon,
    //and then we will test the methods that only staff has, so we can use any
    //class inheriting from the abstract class.
    System.out.println(1 == axe.getDamage());
    System.out.println(1 == axe.getWeight());
    System.out.println(axe.getName().equals("axe"));
    System.out.println(1 == bow.getDamage());
    System.out.println(1 == bow.getWeight());
    System.out.println(bow.getName().equals("bow"));
    System.out.println(1 == knife.getDamage());
    System.out.println(1 == knife.getWeight());
    System.out.println(knife.getName().equals("knife"));
    System.out.println(1 == staff.getDamage());
    System.out.println(1 == staff.getWeight());
    System.out.println(staff.getName().equals("staff"));
    System.out.println(1 == sword.getDamage());
    System.out.println(1 == sword.getWeight());
    System.out.println(sword.getName().equals("sword"));
    System.out.println(1 == staff2.getMagicDamage());
    System.out.println(axe);
    System.out.println(bow);
    System.out.println(knife);
    System.out.println(staff);
    System.out.println(sword);
    System.out.println("---------------------------");
    /*
      Now we are going to test the methods of the character package, and also we are going
     to create instances of the classes in the character package
     To make it easier to test, we are going to create two array list, one containing the
     weapons, and another one containing the classes
     */
    final ArrayList<Iweapon> list_weapons = new ArrayList<>();
    final ArrayList<PlayerCharacter> list_characters = new ArrayList<>();
    final ArrayList<PlayerCharacter> list_characters_True = new ArrayList<>();
    final ArrayList<PlayerCharacter> list_characters_False = new ArrayList<>();
    //We proceed to create a new Queue
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //The elements inside the list_weapons will be use with the purpose of testing the
    //methods; waitTurn and equip.
    list_weapons.add(bow);
    list_weapons.add(axe);
    list_weapons.add(knife);
    list_weapons.add(staff);
    list_weapons.add(staff2);
    final PlayerCharacter knight = new Knight("knight", 1, 1, queue);
    final PlayerCharacter knight2 = new Knight("knight", 1, 1, queue);
    final PlayerCharacter knight_distinto = new Knight("knight", 2, 2, queue);
    final PlayerCharacter engineer = new Engineer("engineer", 1, 1, queue);
    final PlayerCharacter engineer2 = new Engineer("engineer", 1, 1, queue);
    final PlayerCharacter engineer_distinto = new Engineer("engineer", 2, 2, queue);
    final PlayerCharacter thief = new Thief("thief", 1, 1, queue);
    final PlayerCharacter thief2 = new Thief("thief", 1, 1, queue);
    final PlayerCharacter thief_distinto = new Thief("thief", 2, 2, queue);
    final PlayerCharacter whitemage = new WhiteMage("whitemage", 1, 1, 1, queue);
    final PlayerCharacter whitemage2 = new WhiteMage("whitemage", 1, 1, 1, queue);
    final PlayerCharacter whitemage_distinto = new WhiteMage("whitemage", 2, 2, 2, queue);
    final PlayerCharacter blackmage = new BlackMage("blackmage", 1, 1, 1, queue);
    final PlayerCharacter blackmage2 = new BlackMage("blackmage", 1, 1, 1, queue);
    final PlayerCharacter blackmage_distinto = new BlackMage("blackmage", 2, 2, 2, queue);
    Enemy enemy = new Enemy("enemy", 1, 1, 1, queue);
    Enemy enemy2 = new Enemy("enemy", 1, 1, 1, queue);
    Enemy enemyDistinto = new Enemy("enemy", 2, 2, 2, queue);
    //The first five elements in the list_characters will be used with the purpose of
    //testing the methods; waitTurn and equip.
    list_characters.add(knight);
    list_characters.add(engineer);
    list_characters.add(thief);
    list_characters.add(whitemage);
    list_characters.add(blackmage);
    //The following one, will be use for testing the equals methods and everything else
    list_characters_True.add(knight2);
    list_characters_True.add(engineer2);
    list_characters_True.add(thief2);
    list_characters_True.add(whitemage2);
    list_characters_True.add(blackmage2);
    list_characters_False.add(knight_distinto);
    list_characters_False.add(engineer_distinto);
    list_characters_False.add(thief_distinto);
    list_characters_False.add(whitemage_distinto);
    list_characters_False.add(blackmage_distinto);
    System.out.println("-----getters and setters for the Mages-----");
    MagesCharacter mage = new WhiteMage("mage", 1, 1, 5, queue);
    MagesCharacter mage2 = new BlackMage("mage2", 1, 1, 5, queue);
    System.out.println(1 == mage.getMaxMana());
    System.out.println(1 == mage2.getMaxMana());
    mage.setCurrentMana(5);
    mage2.setCurrentMana(5);
    System.out.println(5 == mage.getCurrentMana());
    System.out.println(5 == mage.getCurrentMana());
    System.out.println("-----------------------");
    System.out.println("-----Equals methods, getters and setters test----------");
    //First we focus on the True Values
    for (int i = 0; i < 6; i++) {
      if (i == 5) {
        System.out.println(enemy.equals(enemy2));
        System.out.println(enemy.getName());
        System.out.println(enemy.getDefense());
        System.out.println(enemy.getMaxHp());
        System.out.println(enemy.getWeight());
        enemy.setCurrentHp(0);
        System.out.println(enemy.getCurrentHp());
      } else {
        System.out.println(list_characters.get(i).equals(list_characters_True.get(i)));
        //Testing setters and getters
        System.out.println(list_characters.get(i).getEquippedWeapon());
        System.out.println(list_characters.get(i).getName());
        System.out.println(list_characters.get(i).getDefense());
        System.out.println(list_characters.get(i).getMaxHp());
        list_characters.get(i).setCurrentHp(0);
        System.out.println(list_characters.get(i).getCurrentHp());
      }
    }
    //Now we test the False values
    for (int i = 0; i < 6; i++) {
      if (i == 5) {
        System.out.println(enemy.equals(enemyDistinto));
      } else {
        System.out.println(list_characters.get(i).equals(list_characters_False.get(i)));
      }
    }
    //Finally, we will try to reproduce or imitate the TimerExample, but adding
    //new classes and weapons.
    System.out.println("----------testing equip and waitTurn Methods--------");
    for (int i = 0; i < 6; i++) {
      // Gives a random speed to each character to generate different waiting times
      if (i == 5) {
        enemy.waitTurn();
      } else {
        list_characters.get(i).equip(list_weapons.get(i));
        list_characters.get(i).waitTurn();
      }
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().toString());
    }

  }
}
