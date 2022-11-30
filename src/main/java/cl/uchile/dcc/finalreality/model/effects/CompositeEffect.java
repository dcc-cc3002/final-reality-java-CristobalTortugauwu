package cl.uchile.dcc.finalreality.model.effects;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import java.util.List;

public class CompositeEffect implements Effect{

    private List<Effect> effects = new List<Effect>;

    public List<Effect> getList() {
        return this.effects;
    }

    //Quiero que los efectos sean únicos, para que no se acumulen (?) ayudaaaa
    public void applyEffect(GameCharacter gc) {
        for(Effect i : this.getList())
              i.applyEffect(gc);
    }

    public void addEffect(Effect effect) {
        effects.add(effect);
    }

    public void removeEffect(Effect effect) {
        effects.remove(effect);
    }
}
