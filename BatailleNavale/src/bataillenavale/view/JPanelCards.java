package bataillenavale.view;

import bataillenavale.model.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class JPanelCards extends JPanel implements Observer{

    private final CardLayout cl;
    private Accueil accueil;

    private String currentPanelId = null;
    private JPanel currentPanel;

    private BatailleNavale model;

    public JPanelCards(BatailleNavale model) {
        super();
        this.model = model;
        this.cl = new CardLayout();
        this.setLayout(cl);
        model.addObserver(this);

        accueil = new Accueil(model, this);

        add(accueil, Accueil.id);

        currentPanelId = Accueil.id;
        currentPanel = accueil;
    }

    public void show(String id) {
        //switchJPanel(id);
        cl.show(this, id);
        //Main.getInstance().updateMenu();
        Main.getInstance().pack();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public String getCurrentPanelId() {
        return currentPanelId;
    }
}
