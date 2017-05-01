package bataillenavale.model.ship;

import java.io.Serializable;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class ShipPiece implements Serializable{

    protected StatePiece state;
    protected Ship ship;
    protected int vie;
    private static final long serialVersionUID = 1438530730538256936L;

    public ShipPiece(Ship s, int v){
        this.ship = s;
        this.state = StatePiece.MISS;
        this.vie = v;
    }

    public ShipPiece(StatePiece s){
        this.ship = null;
        this.state = s;
    }

    public int getVie(){
        return this.vie;
    }

    public void touchePiece(){
        if(vie > 0){
            vie--;
            if(vie == 0) this.state = StatePiece.DEAD;
            else this.state = StatePiece.HIT;
        }else{
            vie = 0;
            this.state = StatePiece.DEAD;
        }

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
