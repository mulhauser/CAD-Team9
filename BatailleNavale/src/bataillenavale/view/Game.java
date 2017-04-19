package bataillenavale.view;

import bataillenavale.player.Map;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Game extends JFrame implements Observer{
    Map mapPlayer;
    Map mapAdver;


    public Game(Map m, Map m1){
        this.mapPlayer = m;
        JPanel lesBoutons = new JPanel();

        m.addObserver(this);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,200);
        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
