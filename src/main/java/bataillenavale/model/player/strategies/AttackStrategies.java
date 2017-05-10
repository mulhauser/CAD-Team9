package bataillenavale.model.player.strategies;

import bataillenavale.model.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class AttackStrategies implements Serializable {

    protected ArrayList<Coordinate> listShoot;
    protected int taille;
    private static final long serialVersionUID = 6379415461300379859L;

    public AttackStrategies(){
        this.listShoot = new ArrayList<>();
    }

    public boolean ajouteShoot(int x, int y){
        boolean res = false;
        if(!listShoot.contains(new Coordinate(x, y))){
            listShoot.add(new Coordinate(x, y));
            res = true;
        }
        return res;
    }

    public boolean isShootPossible(int x, int y){
        if(!listShoot.contains(new Coordinate(x, y))){
            return true;
        }else{
            return false;
        }
    }

    public abstract int[] getStrategyShoot(int size);
}
