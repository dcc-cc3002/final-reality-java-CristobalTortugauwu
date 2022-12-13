package cl.uchile.dcc.finalreality.gamestate;

import cl.uchile.dcc.finalreality.GameController;

/**
 * Class to implement the states of the game, I couldn't finish it :C.
 */
public class GameState {
  private GameController context;

  public GameController getGameController() {
    return this.context;
  }

  protected void changeState(GameState state) {
    context.setState(state);
  }

  public void setGameController(GameController game) {
    this.context = game;
  }

  public void wrongState() {
    throw new AssertionError("wrong State");
  }

  public void emptyQueueAction() {
    wrongState();
  }

  public void chooseCharacterAction() {
    wrongState();
  }

  public void enemyTurnAction() {
    wrongState();
  }

  public void playerCharacterTurnAction() {
    wrongState();
  }

  public boolean isEmptyQueueState() {
    return false;
  }

  public boolean isChooseCharacterState() {
    return false;
  }

  public boolean isEnemyTurnState() {
    return false;
  }

  public boolean isPlayerCharacterTurnState() {
    return false;
  }

}
