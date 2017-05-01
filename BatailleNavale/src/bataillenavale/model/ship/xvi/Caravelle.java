package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Caravelle extends EpoqueXVI  implements Serializable {
    // 3 CASES
    public Caravelle() {
        super("Caravelle", 3);
    }
}
