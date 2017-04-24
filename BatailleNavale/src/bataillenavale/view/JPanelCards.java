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

    //une fois que la partie est créé (une fois qu'un a saisi un pseudo)
    private PlacementBateaux placement;

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
        placement = new PlacementBateaux(model, this);

        add(accueil, Accueil.id);
        add(partie, CreationPartie.id);
        add(placement, PlacementBateaux.id);

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
            case PlacementBateaux.id:
                currentPanel = placement;
                Main.getInstance().setPreferredSize(new Dimension(700, 600));
                //pour vérifier que le pseudo est modifié
                System.out.print(model.getHuman().getPseudo());
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public String getCurrentPanelId() {
        return currentPanelId;
    }

    public PlacementBateaux getPlacementPanel(){
        return this.placement;
    }
}
