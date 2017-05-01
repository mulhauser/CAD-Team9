package bataillenavale.view;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private static Main instance = null;

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    private final JPanelCards cards;
    private final JMenuBar menuBar;
    private final JMenu menu;

    private Main(){
        super("Bataille navale");

        //Create the panel that contains the "cards".
        // les menus
        //Create the menu bar.

        //Profile p = new Profile("remy");
        //DAOFactory.getInstance().getDAOSauvegarde().saveProfile(p);
        //System.out.println(liste.keySet());
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Fichier");
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        // Voir pour modifier selon la page où l'on est
        /*JMenuItem accueil = new JMenuItem("Accueil");
        accueil.addActionListener(new MenuListener(model, cards, Accueil.id));
        menu.add(accueil);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new MenuListener(model, cards, "Quit"));
        menu.add(quitter);*/

        setJMenuBar(menuBar);

        cards = new JPanelCards(menu, this);

        add(cards, BorderLayout.CENTER);

        //setPreferredSize(new Dimension(250, 200));

        this.setPreferredSize(new Dimension(250, 200));
        // modifie la position d'apparition de la fenetre, à voir plus tard si besoin
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
    }
    
    /*public void updateMenu() {
        switch (cards.getCurrentPanelId()) {
            case JPanelJouer.id:
                save.setEnabled(true);
                break;
            default:
                save.setEnabled(false);
                break;
        }
    }*/

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        //Utilisation d'un Singleton
        Main.getInstance();
    }


}
