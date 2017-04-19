package bataillenavale.ship;

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
    public enum Orientation{
        TOP,
        BOTTOM,
        RIGHT,
        LEFT;
    }

    public Ship(int l, int s){
        this.live = l;
        this.size = s;
    }

    public int getSize(){
        return this.size;
    }
}
