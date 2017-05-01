package bataillenavale.model;

import bataillenavale.model.player.strategies.IAFactory;
import bataillenavale.model.ship.Ship;

import java.util.Observable;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class BatailleNavale extends Observable {

    protected Partie partie;
    protected Profile profile;

    public BatailleNavale(){
        //disons que par défaut l'époque est moderne et le pseudo ne vaut rien

        ///this.partie = new Partie(Epoque.XX, IAFactory.getInstance().getStrategy("random"));
    }

    public void newProfile(String p){
        this.profile = new Profile(p);
    }

    public void setProfile(Profile p){
        this.profile = p;
    }

    // On passera en parametre les param necessaire plus tard
    public void newPartie(Epoque e, String strat){
        this.partie = new Partie(e, IAFactory.getInstance().getStrategy(strat));
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

    public void ajouterTirHumain(int fireX,int fireY){
        partie.getHuman().fire(fireX,fireY,partie.getBot().getMapPerso());
        /*setChanged();
        notifyObservers();*/
    }

    public void ajouterTirBot(int fireX,int fireY){
        partie.getBot().fire(fireX,fireY,partie.getHuman().getMapPerso());
        /*setChanged();
        notifyObservers();*/
    }

    public Profile getProfile(){
        return this.profile;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }
}
