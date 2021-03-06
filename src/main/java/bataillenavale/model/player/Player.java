package bataillenavale.model.player;


import bataillenavale.model.Coordinate;
import bataillenavale.model.Epoque;
import bataillenavale.model.Flotte;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipFactory;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player extends Observable implements Serializable {

    protected Map mapPerso;
    protected Map mapAdver;
    protected Flotte flotte;
    private static final long serialVersionUID = 4687905241484586830L;


    public Player() {
        this.mapPerso = new Map();
        this.mapAdver = new Map();
    }

    public Flotte getFlotte() {
        return flotte;
    }

    public void setFlotte(Flotte flotte) {
        this.flotte = flotte;
    }

    public Map getMapPerso() {
        return this.mapPerso;
    }

    public Map getMapAdver(){
        return this.mapAdver;
    }

    public boolean putShip(Ship s) {
        return mapPerso.ajouterBateau(s);
    }

    public boolean flottePlace() {
        boolean res = true;
        ArrayList<Ship> ships = this.flotte.getShipList();
        for (Ship s : ships) {
            if (!s.getPlaced()) res = false;
        }
        return res;
    }

    public void fire(int x, int y, Map targetMap) {
        //System.out.println("perso:\n"+mapPerso+"\nadvers:\n"+mapAdver);
        ShipPiece sp = targetMap.getShip(x, y);


        switch (sp.getState()){
            case EMPTY:
                mapAdver.getShip(x,y).setState(StatePiece.FAIL);
                targetMap.getShip(x, y).setState(StatePiece.FAIL);
                break;
            case MISS:
                ShipPiece s = targetMap.getShip(x, y);
                mapAdver.setPiece(x, y, new ShipPiece(s.getShip(), s.getVie()));
                mapAdver.getShip(x,y).touchePiece();
                targetMap.getShip(x, y).touchePiece();
                break;
            case HIT:
                mapAdver.getShip(x, y).touchePiece();
                targetMap.getShip(x, y).touchePiece();
                break;
            case DEAD:
                mapAdver.getShip(x, y).touchePiece();
                targetMap.getShip(x, y).touchePiece();
                break;
            case FAIL:
                // On ne fait rien
                break;
        }
        
    }

    public void constructFlotte(Epoque e) {
        this.flotte = new Flotte(ShipFactory.getInstance().getShipsByEpoque(e));
    }

    public abstract void randomPlacementShip();

    public boolean checkVictory(Map mapAdver){
        ShipPiece[][] ships = mapAdver.getMapDispositionBateaux();

        int compt=0;

        for(int x = 0; x<mapAdver.getSize(); x++){
            for(int y = 0; y<mapAdver.getSize(); y++){
                //si une case est tuée
                if(ships[x][y].getState()==StatePiece.DEAD){
                    compt++;
                }
            }
        }

        int nombreDeCasesAViser = 0;
        List<Ship> shipList = flotte.getShipList();

        for(Ship s : shipList){
            nombreDeCasesAViser+=s.getSize();
        }

        if(compt==nombreDeCasesAViser){
            return true;
        }else{
            return false;
        }

    }
}
