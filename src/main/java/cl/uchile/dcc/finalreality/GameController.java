package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class GameController {
    private final BlockingQueue<GameCharacter> turnsQueue;
    private final ArrayList<PlayerCharacter> playersList;
    private final ArrayList<Enemy> enemyList;

    //We are going to assume when someone instantiates the Controller, the client will know what weapons
    //can be use in each character. Finally, pk is related to the weapon wk (for all k belong in between 1-2)
    public GameController(ArrayList<Enemy> enemyList, ArrayList<PlayerCharacter> playersList,
                          @NotNull BlockingQueue<GameCharacter> turnsQueue) {
        this.playersList = playersList;
        this.enemyList = enemyList;
        this.turnsQueue = turnsQueue;
    }

    public void init() throws InvalidStatValueException {
        //getPlayerCharacterList().add(p1);
        //getPlayerCharacterList().add(p2);
        //we will add only enemy in the constructor
        Enemy enemy = new Enemy("enemy1",100 ,1000,10,this.turnsQueue);

        //this.createPlayer("enemy1",100,1000,10);
        /**
        playersList.get(0).equip(w1);
        playersList.get(1).equip(w2);
        for(int k = 0;k<2; k++) {
            playersList.get(k).addToQueue();
        }
        */

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
        try {
            pc.equip(weapon);
        }
        catch(AssertionError e) {
            System.out.println("weapon isn't compatible with this character");
            this.getPlayerCharacterList().remove(pc);
        }
        pc.addToQueue();
        this.getPlayerCharacterList().add(pc);

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
    public void createEnemy(String name,int hp, int defense, int weight) throws InvalidStatValueException {
        if(this.enemyList.size()==6)
            return;
        Enemy enemy = new Enemy(name, weight, hp , defense, this.getQueue());
        enemy.addToQueue();
        this.getEnemyList().add(enemy);
    }

    public void attack(GameCharacter attacker, GameCharacter target) {
        //Ataca al target
    }

    public void useMagic(GameCharacter attacker, GameCharacter target) {
      //Uses spell on a target
    }

    public void waitTurn(GameCharacter character) {
        // TODO: Call the waitTurn method of the character
    }

    public void onPlayerWin() {
        // TODO: Handle the player winning the game
    }

    public void onEnemyWin() {
        // TODO: Handle the enemy winning the game
    }

}
