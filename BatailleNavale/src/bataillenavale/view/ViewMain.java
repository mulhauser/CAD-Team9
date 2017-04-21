package bataillenavale.view;

import bataillenavale.model.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class ViewMain extends JFrame implements Observer{
    Map mapPlayer;
    Map mapAdver;


    public ViewMain(Map m, Map m1){
        this.mapPlayer = m;

        // vues qui composent la fenetre
        ViewGrilleMe grilleMe = new ViewGrilleMe();
        ViewGrilleEnnemy grilleEnnemy = new ViewGrilleEnnemy();
        this.add(grilleMe, BorderLayout.SOUTH);
        this.add(grilleEnnemy, BorderLayout.NORTH);


        //m.addObserver(this);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,200);
        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
