package bataillenavale.model.player;

import bataillenavale.model.player.strategies.AttackStrategies;
import bataillenavale.model.ship.Ship;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Bot extends Player {
    AttackStrategies strategy;

    public Bot(String p, AttackStrategies strategy) {
        super(p);
        this.strategy = strategy;
    }


    public  void putShip(Ship s, int x, int y, String direction){

    }

    @Override
    public void fire() {

    }
}
