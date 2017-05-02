package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Corsaire extends EpoqueXVI implements Serializable {


    private static final long serialVersionUID = -1347287413945294208L;

    // 4 CASES
    public Corsaire() {
        super("Corsaire",4);
    }
}
