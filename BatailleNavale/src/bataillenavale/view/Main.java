package bataillenavale.view;

import bataillenavale.controler.MenuListener;
import bataillenavale.model.BatailleNavale;

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
    private final BatailleNavale model;

    private Main(){
        super("Bataille navale");

        model = new BatailleNavale();

        //Create the panel that contains the "cards".
        cards = new JPanelCards(model);


        add(cards, BorderLayout.CENTER);

        // les menus
        //Create the menu bar.
        JMenuBar menuBar = new JMenuBar();

        //Build the first menu.
        JMenu menu = new JMenu("Fichier");
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);


        JMenuItem accueil = new JMenuItem("accueil");
        accueil.addActionListener(new MenuListener(model, cards, Accueil.id));
        menu.add(accueil);

        setJMenuBar(menuBar);
        setPreferredSize(new Dimension(250, 200));
        setLocationRelativeTo(null);
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
