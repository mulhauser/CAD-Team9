package bataillenavale.model.player;

import bataillenavale.model.Coordinate;
import bataillenavale.model.player.strategies.AttackStrategies;
import bataillenavale.model.ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Bot extends Player implements Serializable{
    AttackStrategies strategy;
    private static final long serialVersionUID = 4026994099299480429L;

    public Bot(AttackStrategies strategy) {
        super();
        this.strategy = strategy;
    }

    public AttackStrategies getStrategy(){
        return strategy;
    }

    public void setStrategy(AttackStrategies strategy){
        this.strategy = strategy;
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
