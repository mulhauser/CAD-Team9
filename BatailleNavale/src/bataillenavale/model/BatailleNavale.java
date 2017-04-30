package bataillenavale.model;

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
        this.profile = new Profile("ddfds");
    }

    public Partie getPartie(){
        return this.partie;
    }

    public boolean ajouterShip(Ship s){
        boolean res = partie.ajouterShip(s);
        if(res) {
            setChanged();
            notifyObservers();
        }
        return res;
    }

    public void supprimerShip(Ship s){
        partie.getHuman().getMapPerso().supprimerBateau(s);
        setChanged();
        notifyObservers();
    }

    public void ajouterTir(int fireX,int fireY){
        partie.getBot().fire(fireX,fireY);
        /*
        setChanged();
        notifyObservers();
        */
    }

    public Profile getProfile(){
        return this.profile;
    }

}
