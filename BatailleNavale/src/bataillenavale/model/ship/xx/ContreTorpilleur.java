package bataillenavale.model.ship.xx;

import bataillenavale.model.ship.EpoqueXX;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class ContreTorpilleur extends EpoqueXX implements Serializable{
    private static final long serialVersionUID = 64648945207350581L;

    // 3 CASES

    public ContreTorpilleur() {
        super("ContreTorpilleur",3);
    }
}
