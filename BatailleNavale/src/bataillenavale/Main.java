/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import bataillenavale.controler.MapControler;
import bataillenavale.model.Map;
import bataillenavale.model.ship.Galion;
import bataillenavale.model.ship.Ship;
import bataillenavale.view.ViewMain;

import javax.swing.*;

/**
 * @author mulhauser
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Map modele = new Map(5);
        Ship s1 = new Galion(3);
        Ship s2 = new Galion(3);
        Ship s3 = new Galion(3);
        modele.ajouterBateau(s1, 0,4, Ship.Orientation.TOP);
        //modele.ajouterBateau(s2, 0, 4, Ship.Orientation.TOP);
        //modele.ajouterBateau(s3, 4, 4, Ship.Orientation.LEFT);
        System.out.print(modele.toString());
    }

}
