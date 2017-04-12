package bataillenavale;


/**
 * Created by mulhauser on 12/04/2017.
 */
public abstract class Player {

    private String pseudo;
    private int score;

    public Player(String p){
        this.pseudo = p;
        this.score = 0;
    }

    public void putShip(Ship s, Map m){

    }
}
