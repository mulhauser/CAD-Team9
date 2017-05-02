package bataillenavale.model.ship.xvi;

import bataillenavale.model.ship.EpoqueXVI;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Galion extends EpoqueXVI implements Serializable {
    private static final long serialVersionUID = 7722988607744535674L;

    // 3 CASES
    public Galion(  ) {
        super("Galion",3);
    }
}
