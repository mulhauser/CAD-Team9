package bataillenavale.model.ship.xx;

import bataillenavale.model.ship.EpoqueXX;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class Torpilleur extends EpoqueXX  implements Serializable {

    private static final long serialVersionUID = -9055019817157847217L;

    // 2 CASES
    public Torpilleur() {
        super("Torpilleur",2);
    }
}
