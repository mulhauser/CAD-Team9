package bataillenavale.model.ship;

import javax.swing.plaf.nimbus.State;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class ShipPiece {

    private StatePiece state;
    private Ship ship;

    public ShipPiece(Ship s){
        this.ship = s;
        this.state = StatePiece.MISS;
    }

    public ShipPiece(){
        this.ship = null;
        this.state = StatePiece.FAIL;
    }

    public StatePiece getState(){
        return this.state;
    }

    public void setState(StatePiece sp){
        this.state = sp;
    }

    public Ship getShip(){
        return this.ship;
    }
}
