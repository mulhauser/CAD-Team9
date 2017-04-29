package bataillenavale.model;

import bataillenavale.model.player.Bot;
import bataillenavale.model.player.Human;
import bataillenavale.model.player.Player;
import bataillenavale.model.player.strategies.AttackStrategies;
import bataillenavale.model.ship.Ship;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Partie {

    private Player human;
    Player bot;
    private Epoque epoque;
    AttackStrategies strategy;

    public Partie(String pseudo, Epoque e, AttackStrategies strat){

        human = new Human(pseudo);
        this.epoque = e;
        human.constructFlotte(e);
        bot = new Bot("Bot", strat);
    }

    public Player getHuman(){
        return this.human;
    }

    public Epoque getEpoque(){
        return this.epoque;
    }

    public boolean ajouterShip(Ship s) {
        return human.putShip(s);
    }

    public void supprimerShip(Ship s) {
        human.getMapPerso().supprimerBateau(s);
    }
}
