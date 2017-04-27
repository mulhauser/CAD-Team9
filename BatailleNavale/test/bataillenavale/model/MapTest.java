package bataillenavale.model;


import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static bataillenavale.model.Epoque.XX;
import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 27/04/2017.
 */
public class MapTest {

    // CLASSE DE TEST A EXECUTER APRES LA CLASSE DE TEST SHIP

    private Map map = new Map();
    private static final int size = 10;
    ArrayList<Ship> ships;

    // assertEquals(expected, actual)


    @Before // creation de bateaux ici du 20eme siecle
    public void before() throws Exception {
      //  System.out.println("Setting it up!");
        ships = ShipFactory.getInstance().getShipsByEpoque(XX);
    }


    @After // destruction des bateaux crées
    public void after() throws Exception {
       // System.out.println("Running: tearDown");
        ships = null;
        assertNull(ships);
    }


    /**
     * verifie que la taille de la map est bien la bonne
     */
    @Test
    public void getSize(){
        System.out.println("Test de la taille de la map");
        assertEquals(size, map.getSize());
    }


    /**
     * verifie que les coordonnées d un bateau sont bien dans la map et n'en sortent pas
     */
    @Test
    public void verificationCoordinate(){
        System.out.println("Test de la vérification des coordonnées");
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                assertEquals(true, map.verificationCoordinate(i,j));
            }
        }
    }


    /**
     * on va tester le fait qu'il n'y ait bien pas de pièce de bateau dans une case ou il ne devrait pas en avoir
     */
    @Test
    public void getShipSansShip() {
        System.out.println("Test de la non présence d'une partie de bateau la où il n'est pas censé en avoir");
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(null, map.getShip(i, j));
            }
        }
    }


    /**
     * on va tester si un un bateau est correctement placé la ou il devrait sur la carte avec la mathode getShip()
     */
    @Test
    public void getShipAvecShip(){
        System.out.println("Test de la non présence d'une partie de bateau la où il est censé en avoir");
        //TEST A FAIRE APRES PLACEMENT BATEAU

    }


    /**
     * on va vférifier si apres la fonction placementBateau() (que l'on va "forcer") le bateau est correctement place
     */
    @Test
    public void placementBateau() {
        map.placementBateau(ships.get(0));
       // assertEquals();

    }







}