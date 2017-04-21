/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import bataillenavale.controler.MapControler;
import bataillenavale.model.Map;
import bataillenavale.view.ViewMain;

import javax.swing.*;

/**
 * @author mulhauser
 */
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Map modele = new Map(5);
        ViewMain vue = new ViewMain(modele, null);
        MapControler controleur =  new MapControler(modele, vue);


    }

}
