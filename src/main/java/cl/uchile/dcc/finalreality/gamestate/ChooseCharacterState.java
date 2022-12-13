package cl.uchile.dcc.finalreality.gamestate;

import cl.uchile.dcc.finalreality.GameController;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * ChooseCharacterState class.
 */
public class ChooseCharacterState extends GameState {

  @Override
  public void chooseCharacterAction() {
    GameController context = this.getGameController();
    BlockingQueue<GameCharacter> queue = context.getQueue();
    ArrayList<Enemy> enemyList = context.getEnemyList();
    ArrayList<PlayerCharacter> pcList = context.getPlayerCharacterList();
    //We are completely sure that the queue isn´t empty, because in the previous
    //state we asked if the queue was empty.
    if (enemyList.contains(queue.peek())) {
      this.changeState(new EnemyTurnState());
    } else if (pcList.contains(queue.peek())) {
      this.changeState(new PlayerCharacterTurnState());
    }
  }

  @Override
  public boolean isChooseCharacterState() {
    return true;
  }
}
