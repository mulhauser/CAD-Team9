package bataillenavale.model.player;

import bataillenavale.model.Map;

import java.io.Serializable;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Human extends Player implements Serializable {

    public Human() {
        super();
    }

    @Override
    public void fire(int fireY, int fireX) {
        Map mapPerso = getMapPerso();
        //pour un bateau placé à la position (fireX,fireY)
        if(mapPerso.getMapDispositionBateauxElement(fireX,fireY)){
            //true si un bateau est présent ici ou un tir raté
            mapPerso.setMapDispositionBateauxElement(fireX,fireY,true);
        }else{
            mapPerso.setMapDispositionBateauxElement(fireX,fireY,false);
        }

    }

    @Override
    public void randomPlacementShip() {

    }
}
