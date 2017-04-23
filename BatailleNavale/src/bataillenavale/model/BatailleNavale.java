package bataillenavale.model;

import bataillenavale.model.player.Human;
import bataillenavale.model.player.Player;
import bataillenavale.view.JPanelCards;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class BatailleNavale extends Observable {

    private Player human;
    private Player bot;

    public BatailleNavale(){
        this.human = new Human("");
    }

    public Player getHuman() {
        return this.human;
    }

    public void setHuman(Player human) {
        this.human = human;
    }

}
