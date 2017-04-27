package bataillenavale.model.ship;

import bataillenavale.model.Epoque;
import bataillenavale.model.ship.xvi.*;
import bataillenavale.model.ship.xx.*;

import java.util.ArrayList;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class ShipFactory {

    private static ShipFactory instance = new ShipFactory();

    private ShipFactory(){

    }

    public static ShipFactory getInstance(){
        if(instance == null){
            instance = new ShipFactory();
        }
        return instance;
    }

    public ArrayList<Ship> getShipsByEpoque(Epoque e){
        ArrayList<Ship> shipList = new ArrayList<>();
        switch (e){
            case XX:
                shipList.add(new PorteAvion());
                shipList.add(new Croiseur());
                shipList.add(new ContreTorpilleur());
                shipList.add(new SousMarin());
                shipList.add(new Torpilleur());
                break;
            case XVI:
                shipList.add(new Fregate());
                shipList.add(new Corsaire());
                shipList.add(new Galion());
                shipList.add(new Caravelle());
                shipList.add(new Galere());
                break;
        }
        return shipList;
    }
}
