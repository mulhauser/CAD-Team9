package bataillenavale.controler;

import bataillenavale.model.Map;
import bataillenavale.view.ViewMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 19/04/2017.
 */
public class MapControler implements ActionListener {

    Map m;
    ViewMain g;

    public MapControler(Map m, ViewMain g){
        m = m;
        g = g;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
