package bataillenavale.model.player;

import bataillenavale.model.Coordinate;
import bataillenavale.model.Map;
import bataillenavale.model.player.strategies.AttackStrategies;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Bot extends Player {
    AttackStrategies strategy;

    public Bot(String p, AttackStrategies strategy) {
        super(p);
        this.strategy = strategy;
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
        ArrayList<Ship> ships = this.getFlotte().getShipList();
        int tailleMap = getMapPerso().getSize();
        for(Ship s : ships){
            // On tire au hasard l'orientation du bateau pour réduire l'intervalle de random de la position
            boolean place = false;
            while(!place) {
                Random r = new Random();
                int orientation = r.nextInt(2);
                int x, y;
                switch (orientation) {
                    // HORIZONTAL = 0
                    case 0:
                        x = r.nextInt(tailleMap - s.getSize() + 1);
                        y = r.nextInt(tailleMap);
                        s.setCoordinate(new Coordinate(x,y));
                        s.setOrientation(Ship.Orientation.HORIZONTAL);
                        if(this.putShip(s)) place = true;
                        break;
                    // VERTICAL = 1
                    case 1:
                        x = r.nextInt(tailleMap);
                        y = r.nextInt(tailleMap - s.getSize() + 1);
                        s.setCoordinate(new Coordinate(x,y));
                        s.setOrientation(Ship.Orientation.VERTICAL);
                        if(this.putShip(s)) place = true;
                        break;
                }
            }
        }
    }
}
