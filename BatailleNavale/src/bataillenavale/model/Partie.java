package bataillenavale.model;

import bataillenavale.model.player.Bot;
import bataillenavale.model.player.Human;
import bataillenavale.model.player.Player;
import bataillenavale.model.player.strategies.AttackStrategies;

import java.util.Observable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Partie extends Observable{

    Player human;
    Player bot;
    Epoque epoque;
    AttackStrategies strategy;


    public Partie(String pseudo, Epoque e, AttackStrategies strat){
        human = new Human(pseudo);
        this.epoque = e;
        bot = new Bot("bot", strat);
        this.strategy = strat;
        human.constructFlotte(e);
        bot.constructFlotte(e);
    }
}
