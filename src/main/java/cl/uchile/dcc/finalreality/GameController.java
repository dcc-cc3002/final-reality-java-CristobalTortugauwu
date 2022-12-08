package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Iweapon;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private BlockingQueue<GameCharacter> turnsQueue;
    private ArrayList<PlayerCharacter> playersList;
    private ArrayList<Enemy> enemyList;

    public GameController(PlayerCharacter p1, PlayerCharacter p2, PlayerCharacter p3, PlayerCharacter p4) throws InvalidStatValueException {
        turnsQueue = new LinkedBlockingQueue<>();
        playersList = new ArrayList<PlayerCharacter>();
        enemyList = new ArrayList<Enemy>();
        for(int i =0; i<4; i++) {
            playersList.add(p1);
        }
        //we will add only enemy in the constructor
        Enemy enemy = new Enemy("enemy1",100 ,1000,10,turnsQueue);
        enemyList.add(enemy);
        for(int k = 0;k<4; k++) {
            PlayerCharacter k_pl = playersList.get(k);
            k_pl.addToQueue();
        }
        enemy.addToQueue();
    }

    public void createPlayer(String name, int hp, int defense, Iweapon weapon) throws InvalidStatValueException {
        //it's not allow to have more than four members
        if(this.playersList.size()==4)
            return;
        GameCharacter gc = new Knight(name,hp,defense,this.turnsQueue);
        ((Knight) gc).equip(weapon);
    }

    public void createEnemy(String name,int hp, int defense, int weight) {

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
