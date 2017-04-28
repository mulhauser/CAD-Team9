package bataillenavale.model;

import bataillenavale.model.player.Profile;
import bataillenavale.model.player.strategies.IAFactory;
import bataillenavale.model.ship.Ship;

import java.util.Observable;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class BatailleNavale extends Observable {

    private Partie partie;
    private Profile profile;

    public BatailleNavale(){
        //disons que par défaut l'époque est moderne et le pseudo ne vaut rien

        this.partie = new Partie("fsd", Epoque.XX, IAFactory.getInstance().getStrategy("random"));
        this.profile = new Profile();
    }

    public Partie getPartie(){
        return this.partie;
    }

    public void ajouterShip(Ship s){

        if(partie.ajouterShip(s)) {
            setChanged();
            notifyObservers(s.getCoordinate());
        }
    }

    public Profile getProfile(){
        return this.profile;
    }

}
