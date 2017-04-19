package bataillenavale.controler;

import bataillenavale.player.Map;
import bataillenavale.view.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mulhauser on 19/04/2017.
 */
public class MapControler implements ActionListener {

    Map m;
    Game g;

    public MapControler(Map m, Game g){
        m = m;
        g = g;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
