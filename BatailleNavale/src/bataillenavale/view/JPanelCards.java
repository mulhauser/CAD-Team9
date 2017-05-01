package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.controler.SaveListener;
import bataillenavale.model.BatailleNavale;
import bataillenavale.view.partie.AccueilPartie;
import bataillenavale.view.partie.ChargePartie;
import bataillenavale.view.partie.CreationPartie;
import bataillenavale.view.profile.AccueilProfile;
import bataillenavale.view.profile.ChargeProfile;
import bataillenavale.view.profile.CreationProfile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mulhauser on 21/04/2017.
 */
public class JPanelCards extends JPanel {

    private final CardLayout cl;
    private JMenu menu;
    public static JFrame fenetre;
    private AccueilProfile accueilProfile;
    private CreationProfile newProfil;
    private ChargeProfile loadProfil;
    private AccueilPartie accueilPartie;
    private CreationPartie newPartie;
    private ChargePartie loadPartie;

    private PlacementBateaux placement;

    private String currentPanelId = null;
    private JPanel currentPanel;


    private PlateauJeu partieEnCours;

    public JPanelCards(JMenu menu, JFrame fenetre) {
        super();
        this.cl = new CardLayout();
        this.setLayout(cl);
        this.menu = menu;
        this.fenetre = fenetre;

        /* ON DOIT ENLEVER LE MODEL DE CETTE CLASSE, IL SERT A RIEN
        * ET UTILISER UN SETMODEL DANS LES AUTRES PANEL CREES CI-DESSOUS LORSQUE L'ON CHANGE DE PANEL (SI C'EST UTILE)
        * MODIFIER LE LANCEMENT DE BATAILLENAVALE LORSQUE L'ON CREE UNE PARTIE PAS DIRECTEMENT DANS LE MAIN
        * ENLEVER LE PSEUDO DANS PLAYER -> PROFILE, SEULEMENT UTILE POUR LA SAUVEGARDE
        *
        */
        // PROFILE
        accueilProfile = new AccueilProfile(this);
        newProfil = new CreationProfile(this);
        loadProfil = new ChargeProfile(this);

        // PARTIE
        accueilPartie = new AccueilPartie(this);
        newPartie = new CreationPartie(this);
        loadPartie = new ChargePartie(this);

        placement = new PlacementBateaux(this);
        partieEnCours = new PlateauJeu(this);


        add(accueilProfile, AccueilProfile.id);
        add(newProfil, CreationProfile.id);
        add(loadProfil, ChargeProfile.id);
        add(accueilPartie, AccueilPartie.id);
        add(newPartie, CreationPartie.id);
        add(loadPartie, ChargePartie.id);

        add(placement, PlacementBateaux.id);
        add(partieEnCours, PlateauJeu.id);


        currentPanelId = AccueilProfile.id;
        currentPanel = accueilProfile;
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
            case AccueilProfile.id:
                currentPanel = accueilProfile;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case CreationProfile.id:
                currentPanel = newProfil;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case ChargeProfile.id:
                currentPanel = loadProfil;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case AccueilPartie.id:
                currentPanel = accueilPartie;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case CreationPartie.id:
                currentPanel = newPartie;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case ChargePartie.id:
                currentPanel = loadPartie;
                Main.getInstance().setPreferredSize(new Dimension(250, 200));
                break;
            case PlacementBateaux.id:
                currentPanel = placement;
                Main.getInstance().setPreferredSize(new Dimension(700, 600));
                break;
            case PlateauJeu.id:
                currentPanel = partieEnCours;
                Main.getInstance().setPreferredSize(new Dimension(900, 600));
                break;
            case "Quit":
                System.exit(0);
        }
    }

    public String getCurrentPanelId() {
        return currentPanelId;
    }

    public PlacementBateaux getPlacementPanel() {
        return this.placement;
    }

    public PlateauJeu getPlateauJeu() {
        return this.partieEnCours;
    }


    public AccueilPartie getAccueilPartie() {
        return this.accueilPartie;
    }

    public CreationPartie getNewPartie() {
        return this.newPartie;
    }

    public ChargePartie getLoadPartie() {
        return this.loadPartie;
    }

    public AccueilProfile getAccueilProfile() {
        return this.accueilProfile;
    }

    public CreationProfile getNewProfil() {
        return this.newProfil;
    }

    public ChargeProfile getLoadProfil() {
        return this.loadProfil;
    }


    // Demarrage de l'application
    public void chargerMenuDepart() {

    }

    // Menu pour la partie creation, chargement de Profile
    public void chargerMenuProfil() {
        //System.out.println("test");
        menu.removeAll();
        JMenuItem newProfile = new JMenuItem("Créer Profil");
        newProfile.addActionListener(new MenuListener(this, CreationProfile.id));
        menu.add(newProfile);
        JMenuItem loadProfile = new JMenuItem("Charger Profil");
        loadProfile.addActionListener(new MenuListener(this, ChargeProfile.id));
        menu.add(loadProfile);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new MenuListener(this, "Quit"));
        menu.add(quitter);
    }

    // Menu pour la partie creation et chargement de Partie
    public void chargerMenuPartie() {
        menu.removeAll();
        JMenuItem newPartie = new JMenuItem("Créer Partie");
        newPartie.addActionListener(new MenuListener(this, CreationPartie.id));
        menu.add(newPartie);
        JMenuItem loadPartie = new JMenuItem("Charger Partie");
        loadPartie.addActionListener(new MenuListener(this, ChargePartie.id));
        menu.add(loadPartie);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new MenuListener(this, "Quit"));
        menu.add(quitter);
    }

    public void chargerMenuJouer(BatailleNavale model){
        menu.removeAll();
        JMenuItem savePartie = new JMenuItem("Sauvegarder Partie");
        savePartie.addActionListener(new SaveListener(model));
        menu.add(savePartie);
        JMenuItem accueilPartie = new JMenuItem("Accueil de votre Profil");
        accueilPartie.addActionListener(new MenuListener(this, AccueilPartie.id));
        menu.add(accueilPartie);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new MenuListener(this, "Quit"));
        menu.add(quitter);
    }

}
