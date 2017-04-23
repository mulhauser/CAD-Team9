package bataillenavale.model.ship;

import bataillenavale.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Ship {

    /**
     * taille petit = 2
     * taille moyen 3
     * taille grand 4
     */
    //private int live;
    //private boolean alive = true;
    private int size;
    private Coordinate coordinate;
    private Orientation orientation;

    public enum Orientation{
        TOP,
        VERTICAL,
        HORIZONTAL,
        LEFT
    }

    private List<ShipPiece> pieceShipList;

    public Ship(int s){
        //this.live = l;
        this.size = s;
        pieceShipList = new ArrayList<ShipPiece>(size);
        for(int i = 0; i < this.size; i++){
            pieceShipList.add(new ShipPiece(this));
        }
    }

    public int getSize(){
        return this.size;
    }

    public List<ShipPiece> getPieceShipList(){
        return this.pieceShipList;
    }

    public void setOrientation(Orientation o){
        this.orientation = o;
    }

    public Orientation getOrientation(){
        return this.orientation;
    }

    public void setCoordinate(Coordinate c){
        this.coordinate = c;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public boolean isDestroy(){
        boolean res = true;
        for(ShipPiece sp : pieceShipList){
            if(sp.getState() == StatePiece.MISS){
                res = false;
                break;
            }
        }
        return res;
    }
}
