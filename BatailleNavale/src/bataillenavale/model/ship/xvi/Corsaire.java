package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Corsaire extends EpoqueXVI implements Serializable {
    // 4 CASES
    public Corsaire() {
        super("Corsaire",4);
    }
}
