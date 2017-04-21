package bataillenavale.model;

import bataillenavale.model.ship.Ship;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class Case {

    public enum StateCase{
        SHIP, EMPTY;
    }

    private Ship ship;

    public Case(Ship s){
        this.ship = s;
    }



}
