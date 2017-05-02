package bataillenavale.model.ship.xx;

import bataillenavale.model.ship.EpoqueXX;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class SousMarin extends EpoqueXX  implements Serializable {

    private static final long serialVersionUID = 165708230963072644L;

    // 3 CASES
    public SousMarin() {
        super("SousMarin",3);
    }
}
