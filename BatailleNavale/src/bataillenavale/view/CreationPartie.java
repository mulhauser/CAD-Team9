package bataillenavale.view;

import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class CreationPartie extends JPanel implements Observer {

    public static final String id = "creation";
    public CreationPartie(final BatailleNavale model, final JPanelCards card){
        super(new BorderLayout());
        model.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
