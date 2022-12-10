package cl.uchile.dcc.finalreality.gameState;

public class EmptyQueueState extends GameState {

    @Override
    public void emptyQueueAction() {
        //If the queue is empty, we won't change to another state
        if((getGameController()).getQueue().isEmpty())
            this.changeState(new EmptyQueueState());
        else
            this.changeState(new ChooseCharacterState());
    }

    @Override
    public boolean isEmptyQueueState() {
        return true;
    }
}
