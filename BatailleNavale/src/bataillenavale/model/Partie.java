package bataillenavale.model;

import bataillenavale.model.player.Bot;
import bataillenavale.model.player.Human;
import bataillenavale.model.player.Player;
import bataillenavale.model.player.strategies.AttackStrategies;
import bataillenavale.model.ship.Ship;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Partie implements Serializable{

    private static int id;
    private Player human;
    private Player bot;
    private Epoque epoque;
    private AttackStrategies strategy;

    public Partie(String pseudo, Epoque e, AttackStrategies strat){
        id++;
        human = new Human(pseudo);
        this.epoque = e;
        human.constructFlotte(e);
        bot = new Bot("Bot", strat);
        bot.constructFlotte(e);
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

    public Player getBot() {
        return this.bot;
    }

    public int getId(){
        return this.id;
    }

}
