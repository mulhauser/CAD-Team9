package bataillenavale.Ship;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Ship {

    private int live;
    private boolean alive = true;
    private int size;

    public Ship(int l, int s){
        this.live = l;
        this.size = s;
    }
}
