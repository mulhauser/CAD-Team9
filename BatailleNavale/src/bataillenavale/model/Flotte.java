package bataillenavale.model;

import bataillenavale.model.ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class Flotte implements Serializable{

    private static final long serialVersionUID = 3043014960662931231L;
    protected List<Ship> shipList;

    public Flotte(List<Ship> shipList) {
        this.shipList = new ArrayList<Ship>();
        this.shipList.addAll(shipList);
    }

    public ArrayList<Ship> getShipList(){
        return (ArrayList<Ship>) this.shipList;
    }
}
