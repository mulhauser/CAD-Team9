package bataillenavale.model.ship.xx;

import bataillenavale.model.ship.EpoqueXX;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class PorteAvion extends EpoqueXX  implements Serializable {
    private static final long serialVersionUID = 3264679071371832679L;

    // 5 CASES
    public PorteAvion() {
        super("PorteAvion",5);
    }
}
