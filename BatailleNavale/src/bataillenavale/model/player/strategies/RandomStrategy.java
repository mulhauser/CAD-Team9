package bataillenavale.model.player.strategies;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class RandomStrategy extends AttackStrategies implements Serializable{

    public RandomStrategy(){
        super();
    }
    @Override
    public int[] getStrategyShoot(int size) {
        int[] res = new int[2];
        Random r = new Random();

        boolean tirOk = false;
        while(!tirOk){
            int x = r.nextInt(size);
            int y = r.nextInt(size);
            if(ajouteShoot(x, y)){
                res[0] = x;
                res[1] = y;
                tirOk = true;
            }
        }

        return res;
    }

    public String toString(){
        return "Random";
    }
}
