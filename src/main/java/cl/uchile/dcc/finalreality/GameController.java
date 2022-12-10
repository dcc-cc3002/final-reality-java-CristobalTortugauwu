package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.gameState.GameState;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import org.jetbrains.annotations.NotNull;


import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private BlockingQueue<GameCharacter> turnsQueue;
    private final ArrayList<PlayerCharacter> playersList;
    private final ArrayList<Enemy> enemyList;

    private GameState state;

    //We are going to assume when someone instantiates the Controller, the client will know what weapons
    //can be use in each character. Finally, pk is related to the weapon wk (for all k belong in between 1-2)
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
        this.createEnemy("enemy",1000,10,100);
        this.createPlayer(name, hp, defense, mana, kind, weapon);
        this.createPlayer(name2,hp2, defense2, mana2, kind2, weapon2);
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

    public void createPlayer(String name, int hp, int defense, int mana,int character,
                             Iweapon weapon) throws InvalidStatValueException {
        if(this.getPlayerCharacterList().size()==4) {
            System.out.println("the party is full");
            return;
        }
        PlayerCharacter pc = selectPlayerCharacter(name, hp, defense, mana, character);
        pc.addToQueue();
        this.getPlayerCharacterList().add(pc);
        try {
            pc.equip(weapon);
        }
        catch(AssertionError e) {
            System.out.println("weapon isn't compatible with this character");
            this.getQueue().remove(pc);
            this.getPlayerCharacterList().remove(pc);
        }

    }
    public void createEnemy(String name,int hp, int defense, int weight) throws InvalidStatValueException {
        if(this.enemyList.size()==6)
            return;
        Enemy enemy = new Enemy(name, weight, hp , defense, this.getQueue());
        enemy.addToQueue();
        this.getEnemyList().add(enemy);
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


    //This method is used to give us abstraction in the method createPlayer, and the most
    //important part, is that it returns a PlayerCharacter
    public PlayerCharacter selectPlayerCharacter(String name, int hp, int defense, int mana,
                                                 int character) throws InvalidStatValueException {
        return switch (character)
                {
                    case 0 -> new BlackMage(name, hp, defense, mana, this.getQueue());
                    case 1 -> new Engineer(name, hp, defense, this.getQueue());
                    case 2 -> new Knight(name, hp, defense, this.getQueue());
                    case 3 -> new Thief(name, hp, defense, this.getQueue());
                    case 4 -> new WhiteMage(name, hp, defense, mana, this.getQueue());
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
}
