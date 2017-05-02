package bataillenavale.model.ship;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class EpoqueXX extends Ship implements Serializable{

    private static final long serialVersionUID = -3897657025890832052L;

    public EpoqueXX(String n, int s) {
        super(n, s, 2);
    }
}
