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

    //ajout de la grille de la partie en cours
    private PlateauJeu partieEnCours;

    public JPanelCards(BatailleNavale model) {
        super();
        this.model = model;
        this.cl = new CardLayout();
        this.setLayout(cl);
        model.addObserver(this);


        /* ON DOIT ENLEVER LE MODEL DE CETTE CLASSE, IL SERT A RIEN
        * ET UTILISER UN SETMODEL DANS LES AUTRES PANEL CREES CI-DESSOUS LORSQUE L'ON CHANGE DE PANEL (SI C'EST UTILE)
        * MODIFIER LE LANCEMENT DE BATAILLENAVALE LORSQUE L'ON CREE UNE PARTIE PAS DIRECTEMENT DANS LE MAIN
        * ENLEVER LE PSEUDO DANS PLAYER -> PROFILE, SEULEMENT UTILE POUR LA SAUVEGARDE
        *
        */
        accueil = new Accueil(model, this);
        partie = new CreationPartie(model, this);
        placement = new PlacementBateaux(model, this);
        partieEnCours = new PlateauJeu(model, this);


        add(accueil, Accueil.id);
        add(partie, CreationPartie.id);
        add(placement, PlacementBateaux.id);
        add(partieEnCours, PlateauJeu.id);


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
                //System.out.print(model.getPartie().getHuman().getPseudo());
                break;
                //ajout de la grille de jeu lorsque la partie commence
            case PlateauJeu.id:
                currentPanel = partieEnCours;
                Main.getInstance().setPreferredSize(new Dimension(900, 600));
                break;
            case "Quit":
                System.exit(0);
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

    public PlateauJeu getPlateauJeu() {return this.partieEnCours;}
}
