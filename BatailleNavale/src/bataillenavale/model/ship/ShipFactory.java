package bataillenavale.model.ship;

import bataillenavale.model.Epoque;
import bataillenavale.model.ship.xx.*;

import java.util.ArrayList;
import java.util.List;

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
                shipList.add(new PorteAvion(5));
                shipList.add(new Croiseur(4));
                shipList.add(new ContreTorpilleur(3));
                shipList.add(new SousMarin(3));
                shipList.add(new Torpilleur(2));
                break;
            case XIX:

                break;
        }
        return shipList;
    }
}
