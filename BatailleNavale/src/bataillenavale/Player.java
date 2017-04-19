package bataillenavale;


import bataillenavale.Ship.Ship;

import java.util.ArrayList;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player {

    private String pseudo;
    private int score;
    private Map map;
    private ArrayList<Ship> fleet;

    public Player(String p, int size){
        this.pseudo = p;
        this.score = 0;
        this.map = new Map(size);
        this.fleet = new ArrayList<Ship>(4);
    }

    public abstract void putShip(Ship s);
    public abstract void fire();
}
