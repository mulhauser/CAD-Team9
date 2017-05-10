package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Galere extends EpoqueXVI  implements Serializable {
    private static final long serialVersionUID = -3057546302131355408L;

    // 2 CASES
    public Galere() {
        super("Galere",2);
    }
}
