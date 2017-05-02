package bataillenavale.model.ship;

import java.io.Serializable;

/**
 * Created by mulhauser on 25/04/2017.
 */
public class EpoqueXVI extends Ship implements Serializable{
    private static final long serialVersionUID = -1334019152478766144L;

    public EpoqueXVI(String n, int s) {
        super(n, s, 1);
    }

}
