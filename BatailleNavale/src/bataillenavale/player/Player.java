package bataillenavale.player;


import bataillenavale.ship.Ship;

import java.util.ArrayList;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player {

    private String pseudo;
    private int score;
    private Map mapPerso;
    private Map mapAdver;
    private ArrayList<Ship> fleet;


    public Player(String p, int size){
        this.pseudo = p;
        this.score = 0;
        this.mapPerso = new Map(size);
        this.mapAdver = new Map(size);
        this.fleet = new ArrayList<Ship>(4);
    }




    public  void putShip(Ship s, int x, int y, Ship.Orientation orientation){

    }







    public abstract void fire();
}
