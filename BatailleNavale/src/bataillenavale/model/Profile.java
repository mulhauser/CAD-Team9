package bataillenavale.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Profile implements Serializable{

    private static int id;
    private static String pseudo;
    private HashMap<Integer, Partie> parties;

    public Profile(String p){
        id++;
        this.pseudo = p;
        parties = new HashMap<>();
    }

    public void ajouterPartie(Partie p){
        this.parties.put(p.getId(),p);
    }

    public void supprimer(Partie p){
        this.parties.remove(p.getId());
    }

    public HashMap getParties(){
        return this.parties;
    }

    public int getId(){
        return this.id;
    }

    public String getPseudo(){
        return this.pseudo;
    }



}
