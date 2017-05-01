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
        //si un bateau est placé à la position (fireX,fireY)
        if(mapPerso.getMapDispositionBateauxElement(fireX,fireY)){
            mapPerso.setMapDispositionBateauxElement(fireX,fireY);
        }
        /*
        if(mapPerso.getMapDispositionBateauxElement(fireX,fireY)){
            mapPerso.setMapDispositionBateauxElement(fireX,fireY,true);
        }else{
            mapPerso.setMapDispositionBateauxElement(fireX,fireY,false);
        }
        */
    }

    @Override
    public void randomPlacementShip() {

    }
}
