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

    private CreationPartie partie;

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
        partie = new CreationPartie(model, this);

        add(accueil, Accueil.id);
        add(partie, CreationPartie.id);

        currentPanelId = Accueil.id;
        currentPanel = accueil;
    }

    public void show(String id) {
        switchJPanel(id);
        cl.show(this, id);
        //Main.getInstance().updateMenu();
        Main.getInstance().pack();
    }

    private void switchJPanel(String id) {
        currentPanelId = id;
        switch (id) {
            case Accueil.id:
                currentPanel = accueil;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case CreationPartie.id:
                currentPanel = partie;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public String getCurrentPanelId() {
        return currentPanelId;
    }
}
