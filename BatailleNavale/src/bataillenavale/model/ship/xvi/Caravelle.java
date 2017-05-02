package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Caravelle extends EpoqueXVI  implements Serializable {

    private static final long serialVersionUID = -1034353031229226736L;

    // 3 CASES
    public Caravelle() {
        super("Caravelle", 3);
    }
}
