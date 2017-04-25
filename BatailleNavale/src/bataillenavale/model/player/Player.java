package bataillenavale.model.player;


import bataillenavale.model.Epoque;
import bataillenavale.model.Flotte;
import bataillenavale.model.Map;
import bataillenavale.model.ship.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player implements Serializable {

    private String pseudo;
    private int score;
    private Map mapPerso;
    private Map mapAdver;
    private Flotte flotte;


    public Player(String p){
        this.pseudo = p;
        this.score = 0;
        this.mapPerso = new Map();
        this.mapAdver = new Map();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public  void putShip(Ship s, int x, int y, Ship.Orientation orientation){

    }

    public Map getMapPerso(){
        return this.mapPerso;
    }

    public void constructFlotte(Epoque e){
        ShipFactory shipFactory = ShipFactory.getInstance();
        List<Ship> shipList = shipFactory.getShipsByEpoque(e);
        flotte = new Flotte(shipList);
    }


    public abstract void fire();
}
