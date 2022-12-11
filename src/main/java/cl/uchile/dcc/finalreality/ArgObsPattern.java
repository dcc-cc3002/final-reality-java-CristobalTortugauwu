package cl.uchile.dcc.finalreality;


/**
 * This class exists because we will use it to update the information that changes
 * in the observable, so that the observers subscribed will be updated.
 */
public class ArgObsPattern {

    private String action;

    private int hp;

    private int mana;

    public ArgObsPattern(String action, int new_hp, int new_mana) {
        this.action = action;

        this.hp = new_hp;

        this.mana = new_mana;

        //Quizás tengamos que agregar una nueva variable, por los efectos
    }

    public String getAction() {
        return action;
    }

    public int getNewHp() {
        return hp;
    }

    public int getNewMana() {
        return mana;
    }
}
