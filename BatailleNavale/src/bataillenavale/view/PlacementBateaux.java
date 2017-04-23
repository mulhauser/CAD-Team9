package bataillenavale.view;

import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 23/04/2017.
 */
public class PlacementBateaux extends JPanel implements Observer{

    public static final String id = "placement";

    public PlacementBateaux(final BatailleNavale model, final JPanelCards card){
        super(new BorderLayout());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
