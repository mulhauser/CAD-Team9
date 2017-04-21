package bataillenavale.model.ship;

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
    private int live;
    private boolean alive = true;
    private int size;
    private Orientation orientation;

    public enum Orientation{
        TOP,
        BOTTOM,
        RIGHT,
        LEFT;
    }

    private List<ShipPiece> pieceShipList;

    public Ship(int l, int s){
        this.live = l;
        this.size = s;
        pieceShipList = new ArrayList<>(size);
    }

    public int getSize(){
        return this.size;
    }

    public List<ShipPiece> getPieceShipList(){
        return this.pieceShipList;
    }
}
