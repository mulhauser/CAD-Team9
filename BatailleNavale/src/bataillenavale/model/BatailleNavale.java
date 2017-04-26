package bataillenavale.model;

import bataillenavale.model.player.Human;
import bataillenavale.model.player.Player;
import bataillenavale.model.player.Profile;
import bataillenavale.view.JPanelCards;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class BatailleNavale extends Observable {

    private Partie partie;
    private Profile profile;

    public BatailleNavale(){
        //disons que par défaut l'époque est moderne et le pseudo ne vaut rien
        this.partie = new Partie("", Epoque.XX);
        this.profile = new Profile();
    }

    public Partie getPartie(){
        return this.partie;
    }

    public Profile getProfile(){
        return this.profile;
    }

}
