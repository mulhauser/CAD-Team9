package bataillenavale.model.player;

import bataillenavale.model.Coordinate;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Human extends Player {

    public Human(String p) {
        super(p);
    }

    @Override
    public void fire(int fireX, int fireY) {
        Map mapPerso = getMapPerso();
        //si un bateau est placé à la position (fireX,fireY)
        ShipPiece[][] tabMap = mapPerso.getMapDispositionBateaux();
        if(mapPerso.getMapDispositionBateauxElement(fireX,fireY)){
            tabMap[fireY][fireX].setState(StatePiece.HIT);
        }else{
            tabMap[fireY][fireX].setState(StatePiece.MISS);
        }
    }

    @Override
    public void randomPlacementShip() {

    }
}
