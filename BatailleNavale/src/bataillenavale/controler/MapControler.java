package bataillenavale.controler;

import bataillenavale.model.Map;
import bataillenavale.view.PlateauJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 19/04/2017.
 */
public class MapControler implements ActionListener {

    Map m;
    PlateauJeu g;

    public MapControler(Map m, PlateauJeu g){
        m = m;
        g = g;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
