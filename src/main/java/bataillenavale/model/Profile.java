package bataillenavale.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Profile implements Serializable{

    protected final int id;
    protected static final AtomicInteger count = new AtomicInteger(0);
    protected String pseudo;
    protected HashMap<Integer, Partie> parties;
    private static final long serialVersionUID = -1537951485391807260L;

    public Profile(String p){
        this.id = count.incrementAndGet();
        this.pseudo = p;
        this.parties = new HashMap<>();
    }

    public void ajouterPartie(Partie p){
        p.setId(parties.size());
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
