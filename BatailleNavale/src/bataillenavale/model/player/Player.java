package bataillenavale.model.player;


import bataillenavale.model.Epoque;
import bataillenavale.model.Flotte;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipFactory;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player extends Observable implements Serializable {

    private String pseudo;
    private int score;
    private Map mapPerso;
    //private Map mapAdver;
    private Flotte flotte;


    public Player(String p){
        this.pseudo = p;
        this.score = 0;
        this.mapPerso = new Map();
        //this.mapAdver = new Map();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Flotte getFlotte() {
        return flotte;
    }

    public void setFlotte(Flotte flotte) {
        this.flotte = flotte;
    }

    public Map getMapPerso(){
        return this.mapPerso;
    }

    public boolean putShip(Ship s){
        return mapPerso.ajouterBateau(s);
    }


    /*
    public void constructFlotte(Epoque e){
        ShipFactory shipFactory = ShipFactory.getInstance();
        List<Ship> shipList = shipFactory.getShipsByEpoque(e);
        flotte = new Flotte(shipList);
    }
    */

    public abstract void fire();

    public void constructFlotte(Epoque e) {
        this.flotte = new Flotte(ShipFactory.getInstance().getShipsByEpoque(e));
    }
}
