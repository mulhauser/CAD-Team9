package bataillenavale.model;

import bataillenavale.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class Flotte {

    private List<Ship> shipList;

    public Flotte(List<Ship> shipList) {
        shipList.add((Ship) shipList);
    }

    public List<Ship> getShipList(){
        return this.shipList;
    }
}
