package bataillenavale.model.player.strategies;

import bataillenavale.model.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class AttackStrategies implements Serializable {

    public ArrayList<Coordinate> listShoot;

    public AttackStrategies(){
        listShoot = new ArrayList<>();
    }

    public abstract int[] getStrategyShoot();
}
