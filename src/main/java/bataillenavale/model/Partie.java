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

    private static final long serialVersionUID = -8074355707605676522L;
    protected static int id;
    protected Player human;
    protected Player bot;
    protected Epoque epoque;
    protected AttackStrategies strategy;

    public Partie(Epoque e, AttackStrategies strat){

        human = new Human();
        this.epoque = e;
        human.constructFlotte(e);
        bot = new Bot(strat);
        bot.constructFlotte(e);
        bot.randomPlacementShip();
        this.strategy = strat;
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

    public void setId(int id){
        this.id = id;
    }


}
