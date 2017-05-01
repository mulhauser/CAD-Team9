package bataillenavale.model.ship.xx;

import bataillenavale.model.ship.EpoqueXX;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Croiseur extends EpoqueXX  implements Serializable {

    // 4 CASES
    public Croiseur() {
        super("Croiseur",4);
    }
}
