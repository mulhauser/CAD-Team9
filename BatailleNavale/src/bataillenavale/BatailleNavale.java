/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

import bataillenavale.controler.MapControler;
import bataillenavale.player.Map;
import bataillenavale.view.Game;

/**
 * @author mulhauser
 */
public class BatailleNavale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Map modele = new Map(5);
        Game vue = new Game(modele, null);
        MapControler controleur =  new MapControler(modele, vue);


    }

}
