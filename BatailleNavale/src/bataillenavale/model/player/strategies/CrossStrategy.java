package bataillenavale.model.player.strategies;

import java.io.Serializable;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class CrossStrategy extends AttackStrategies implements Serializable{

    public CrossStrategy(){
        super();
    }

    @Override
    public int[] getStrategyShoot(int size) {
        return new int[0];
    }

    public String toString(){
        return "Cross";
    }
}
