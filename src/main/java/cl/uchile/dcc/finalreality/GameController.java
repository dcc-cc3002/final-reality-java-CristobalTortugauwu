package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.gameState.GameState;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jetbrains.annotations.NotNull;

public class GameController implements Observer {
  private BlockingQueue<GameCharacter> turnsQueue;
  private final ArrayList<PlayerCharacter> playersList;
  private final ArrayList<Enemy> enemyList;

  private GameState state;

  //We are going to assume when someone instantiates the Controller,
  // the client will know what weapons can be use in each character.
  // Finally, pk is related to the weapon wk (for all k belong in between 1-2)
  public GameController(ArrayList<Enemy> enemyList, ArrayList<PlayerCharacter> playersList,
                        @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    this.playersList = playersList;
    this.enemyList = enemyList;
    this.turnsQueue = turnsQueue;
  }

  public void init(String name, int hp, int defense, int mana, int kind, Iweapon weapon,
                   String name2, int hp2, int defense2, int mana2, int kind2, Iweapon
                   weapon2) throws InvalidStatValueException {
    turnsQueue = new LinkedBlockingQueue<>();
    this.createEnemy("enemy", 1000, 10, 100);
    this.createPlayer(name, hp, defense, mana, kind, weapon);
    this.createPlayer(name2, hp2, defense2, mana2, kind2, weapon2);
  }

  public ArrayList<PlayerCharacter> getPlayerCharacterList() {
    return this.playersList;
  }

  public ArrayList<Enemy> getEnemyList() {
    return this.enemyList;
  }

  public BlockingQueue<GameCharacter> getQueue() {
    return this.turnsQueue;
  }

  /**
   * This method creates an Engineer and add it to the controller Queue, and also
   * add the controller as an observer to the engineer.
   */
  public void createEngineer(String name, int hp, int defense, Iweapon weapon)
          throws InvalidStatValueException {

    if (this.getPlayerCharacterList().size() == 4) {
      System.out.println("the party is full");
      return;
    }
    //
    Engineer pc = new Engineer(name, hp, defense, this.getQueue());;
    try {
      pc.equip(weapon);
    }
    catch(AssertionError e) {
      System.out.println("weapon isn't compatible with this character");
    }
    //At this point, we're completely sure that we are free of errors, so we add
    //the controller as an observer to the playerCharacter
    pc.addObserver(this);
    this.getPlayerCharacterList().add(pc);
    pc.addToQueue();
 }

 /**
  * This method creates a BlackMage and add it to the controller Queue, and also
  * add the controller as an observer to the BlackMage.
  * @param name
  * @param hp
  * @param defense
  * @param weapon
  * @param mana
  * @throws InvalidStatValueException
  */
  public void createBlackMage(String name, int hp, int defense, int mana,
                             Iweapon weapon) throws InvalidStatValueException {

    if (this.getPlayerCharacterList().size() == 4) {
      System.out.println("the party is full");
      return;
    }
    //
    BlackMage pc = new BlackMage(name, hp, defense,mana, this.getQueue());;
    try {
      pc.equip(weapon);
    }
    catch(AssertionError e) {
      System.out.println("weapon isn't compatible with this character");
    }
    //At this point, we're completely sure that we are free of errors, so we add
    //the controller as an observer to the playerCharacter
    pc.addObserver(this);
    this.getPlayerCharacterList().add(pc);
    pc.addToQueue();
  }

  /**
   * This method creates a Knight and add it to the controller Queue, and also
   * add the controller as an observer to the Knight.
   * @param name
   * @param hp
   * @param defense
   * @param weapon
   * @throws InvalidStatValueException
   */
  public void createKnight(String name, int hp, int defense, Iweapon weapon)
        throws InvalidStatValueException {

    if (this.getPlayerCharacterList().size() == 4) {
      System.out.println("the party is full");
      return;
    }
    //
    Knight pc = new Knight(name, hp, defense, this.getQueue());;
    try {
      pc.equip(weapon);
    }
    catch(AssertionError e) {
      System.out.println("weapon isn't compatible with this character");
    }
    //At this point, we're completely sure that we are free of errors, so we add
    //the controller as an observer to the playerCharacter
    pc.addObserver(this);
    this.getPlayerCharacterList().add(pc);
    pc.addToQueue();
  }

  /**
   * This method creates a Thief and add it to the controller Queue, and also
   * add the controller as an observer to the Thief.
   *
   * @param name
   * @param hp
   * @param defense
   * @param weapon
   * @throws InvalidStatValueException
   */

  public void createThief(String name, int hp, int defense, Iweapon weapon)
        throws InvalidStatValueException {
    if(this.getPlayerCharacterList().size()==4) {
      System.out.println("the party is full");
      return;
    }
    //
    Thief pc = new Thief(name, hp, defense, this.getQueue());;
    try {
      pc.equip(weapon);
    }
    catch(AssertionError e) {
      System.out.println("weapon isn't compatible with this character");
    }
    //At this point, we're completely sure that we are free of errors, so we add
    //the controller as an observer to the playerCharacter
    pc.addObserver(this);
    this.getPlayerCharacterList().add(pc);
    pc.addToQueue();
  }

  /**
   * This method creates a BlackMage and add it to the controller Queue, and also
   * add the controller as an observer to the BlackMage.
   * @param name
   * @param hp
   * @param defense
   * @param weapon
   * @param mana
   * @throws InvalidStatValueException
   */
  public void createWhiteMage(String name, int hp, int defense, int mana,
                            Iweapon weapon) throws InvalidStatValueException {
    if(this.getPlayerCharacterList().size()==4) {
      System.out.println("the party is full");
      return;
    }
    //
    WhiteMage pc = new WhiteMage(name, hp, defense,mana, this.getQueue());;
    try {
      pc.equip(weapon);
    }
    catch(AssertionError e) {
      System.out.println("weapon isn't compatible with this character");
    }
    //At this point, we're completely sure that we are free of errors, so we add
    //the controller as an observer to the playerCharacter
    pc.addObserver(this);
    this.getPlayerCharacterList().add(pc);
    pc.addToQueue();
  }

  /**
   * This method creates an enemy, it's add the controller as an observer, and also
   * adds the new enemy to the queue.
   * @param name
   * @param hp
   * @param defense
   * @param weight
   * @throws InvalidStatValueException
   */
  public void createEnemy(String name,int hp, int defense, int weight) throws InvalidStatValueException {
    if(this.enemyList.size()==6)
      return;
    Enemy enemy = new Enemy(name, weight, hp , defense, this.getQueue());
    enemy.addObserver(this);
    this.getEnemyList().add(enemy);
    enemy.addToQueue();
  }

  public void attackByPlayerCharacter(PlayerCharacter attacker, GameCharacter target) throws InvalidStatValueException {
  if(this.handleError(attacker,target))
    return;
  //First we see if the playerCharacter belongs to the party (i.e., isn't death), and the enemy is alive
  if(this.getPlayerCharacterList().contains(attacker) && this.getEnemyList().contains((Enemy)target)) {
    ArrayList<Enemy> list = this.getEnemyList();
    int ind_pc = list.indexOf(target);
    attacker.attack(target);
    list.set(ind_pc,(Enemy) target);
  }
  //do nothing
  }

  public void attackByEnemy(Enemy attacker, GameCharacter target) throws InvalidStatValueException {
    if(this.handleError(attacker,target))
        return;
    //First we see if the playerCharacter belongs to the party (i.e., isn't death), and the enemy is alive
    if(this.getPlayerCharacterList().contains((PlayerCharacter) target) && this.getEnemyList().contains(attacker)) {
        ArrayList<PlayerCharacter> list = this.getPlayerCharacterList();
        int ind_pc = list.indexOf(target);
        attacker.attack(target);
        list.set(ind_pc,(PlayerCharacter) target);
    }
    //do nothing
  }
  public void useMagic(GameCharacter attacker, GameCharacter target) {
      //We know that only mages are allowed to use magic
  }

  public void waitTurnByEnemy(Enemy enemy) {
      if(this.getEnemyList().contains(enemy));

  }
  public void waitTurnByPlayerCharacter(PlayerCharacter pc) {

  }

  public void onPlayerWin() {
      // TODO: Handle the player winning the game
  }

  public void onEnemyWin() {
      // TODO: Handle the enemy winning the game
  }


  /**
   *This method is used in the init method, if someone wants to create a certain type of character
   * he/she has to use the following ints in the character input:
   *             case 0 -> createBlackMage(name, hp, defense, mana,weapon);
   *             case 1 -> createEngineer(name, hp, defense, weapon);
   *             case 2 -> createKnight(name, hp, defense, weapon);
   *             case 3 -> createThief(name, hp, defense, weapon);
   *             case 4 -> createWhiteMage(name, hp, defense, mana, weapon);
   *             default -> throw new IllegalStateException("Unexpected value: " + character);
   *
  **/
  public void createPlayer(String name, int hp, int defense, int mana,
                           int character, Iweapon weapon) throws InvalidStatValueException {
      switch (character) {
          case 0 -> createBlackMage(name, hp, defense, mana,weapon);
          case 1 -> createEngineer(name, hp, defense, weapon);
          case 2 -> createKnight(name, hp, defense, weapon);
          case 3 -> createThief(name, hp, defense, weapon);
          case 4 -> createWhiteMage(name, hp, defense, mana, weapon);
          default -> throw new IllegalStateException("Unexpected value: " + character);
      };
  }

  //If this method returns true, it's because it did find an error
  public boolean handleError(GameCharacter attacker, GameCharacter target) {
      //If the target is already death, it can't be attacked.
      if(attacker.getCurrentHp()==0) {
          System.out.println("you can not attack");
          return true;
      }
      //if the attacker doesn't have hp, he also can not attack and his turn ends.
      if(target.getCurrentHp()==0) {
          System.out.println("select another target");
          return true;
      }
      return false;
  }



  public void setState(GameState state) {
      this.state = state;
      this.state.setGameController(this);
  }

  /**
   * The most important method right now XD
   * @param o     the observable object.
   * @param arg   an argument passed to the {@code notifyObservers}
   *                 method.
   */
  @Override
  public void update(Observable o, Object arg) {
      if(arg instanceof ArgObsPattern){
          ArgObsPattern newArg = (ArgObsPattern) arg;
          if(newArg.getAction().equals("attack")) {
              //Here we will reduce the hp of the GameCharacter that was attacked

          }
          else if(newArg.getAction().equals(("spell"))) {
              //in this section, we will reduce the mana of the playerCharacter that used the
              //spell and reduce his mana, and also we will reduce the enemy's hp.
          }
      }
  }
}
