package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Fregate extends EpoqueXVI implements Serializable {
    private static final long serialVersionUID = 6053080121077483188L;

    // 5 CASES
    public Fregate() {
        super("Fregate",5);
    }
}
