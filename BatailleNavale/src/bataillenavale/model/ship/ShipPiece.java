package bataillenavale.model.ship;

import java.io.Serializable;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class ShipPiece implements Serializable{

    protected StatePiece state;
    protected Ship ship;
    private static final long serialVersionUID = 1438530730538256936L;

    public ShipPiece(Ship s){
        this.ship = s;
        this.state = StatePiece.MISS;
    }

    public ShipPiece(StatePiece s){
        this.ship = null;
        this.state = s;
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
