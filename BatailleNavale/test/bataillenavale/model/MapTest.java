package bataillenavale.model;


import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipFactory;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;
import bataillenavale.model.ship.xvi.Caravelle;
import bataillenavale.model.ship.xx.Croiseur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
      //  System.out.println("Test de la taille de la map");
        assertEquals(size, map.getSize());
    }




    /**
     * on va tester le fait qu'il n'y ait bien pas de pièce de bateau dans une case ou il ne devrait pas en avoir
     */
    @Test
    public void getShipSansShip() {
       // System.out.println("Test de la non présence d'une partie de bateau la où il n'est pas censé en avoir");
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(StatePiece.EMPTY, map.getShip(i, j).getState());
            }
        }
    }


    /**
     * on va tester si un un bateau est correctement placé la ou il devrait sur la carte avec la mathode getShip()
     */
    @Test
    public void getShipAvecShip(){
       // System.out.println("Test de la non présence d'une partie de bateau la où il est censé en avoir");
        //TEST A FAIRE APRES PLACEMENT BATEAU

    }


    /**
     * on test si c'est possible d'ajouter un ship hors de la map
     *
     */
    @Test
    public void verificationCoordinateFalse(){
        boolean b = map.verificationCoordinate(map.getMapDispositionBateaux().length +1, map.getMapDispositionBateaux().length +1);
        assertEquals(false,b);
    }


    /**
     * on test si c'est possible d'ajouter un ship a la limite de la map
     * ce qui ne doit pas être possible
     */
    @Test
    public void verificationCoordinateTrueLimit(){
        boolean b = map.verificationCoordinate(map.getMapDispositionBateaux().length , map.getMapDispositionBateaux().length );
        assertEquals(false,b);
    }

    /**
     * on test si on peut ajouter un bateau a 0
     */
    @Test
    public void verificationCoordinateTrueZero(){
        boolean b = map.verificationCoordinate(0, 0 );
        assertEquals(true,b);
    }


    /**
     * on test si on peut ajouter un bateau a 0
     */
    @Test
    public void verificationCoordinatePartout(){
        for(int i= 0; i < map.getMapDispositionBateaux().length; i++){
            for(int j = 0; j < map.getMapDispositionBateaux().length; j++) {
                assertEquals(true, map.verificationCoordinate(i, j));
            }
        }

    }


    /**
     * on test si on peut placer un bateau dans un endroit ou on est censé pouvoir la placer
     * le bateau est un croiseur et dans une position verticale
     */
    @Test
    public void verificationPlacementCorrectVertical(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.VERTICAL);
        s.setCoordinate(new Coordinate(5,5));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(true, b);
    }


    /**
     * on test si on peut placer un bateau dans un endroit ou on est censé pouvoir la placer
     * le bateau est un croiseur et dans une position horizontale
     */
    @Test
    public void verificationPlacementCorrectHorizontale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        s.setCoordinate(new Coordinate(5,5));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(true, b);
    }


    /**
     * on test si on peut placer un bateau en position de départ en bas de la map et qui va sortir de la map
     * le debut du bateau est tout en bas , puis le reste en dehors
     * pas possible normalement
     */
    @Test
    public void verificationPlacementIMPOSSIBLEVertical(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.VERTICAL);
        s.setCoordinate(new Coordinate(map.getSize()-1,map.getSize()-1));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(false, b);
    }



    /**
     * on test si on peut placer un bateau en position de départ en bas de la map et qui va sortir de la map
     * le debut du bateau est tout en bas , puis le reste en dehors
     * pas possible normalement
     */
    @Test
    public void verificationPlacementIMPOSSIBLEHorizontale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        s.setCoordinate(new Coordinate(map.getSize()-1,map.getSize()-1));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(false, b);
    }


    /**
     * on test si c'est possible de placer un bateau totalement hors de la map
     * normalement non
     */
    @Test
    public void verificationPlacementHorsMapCompletementHorizontale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        s.setCoordinate(new Coordinate(map.getSize()+1,map.getSize()+1));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(false, b);
    }


    /**
     * on test si c'est possible de placer un bateau totalement hors de la map
     * normalement non
     */
    @Test
    public void verificationPlacementHorsMapCompletementVerticale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.VERTICAL);
        s.setCoordinate(new Coordinate(map.getSize()+1,map.getSize()+1));
        boolean b = map.verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation());
        assertEquals(false, b);
    }


    /**
     * on test si c'est possible de placer un bateau exactement sur  un autre
     * dans la position verticale
     */
    @Test
    public void verificationPlacementBateauDejaPlaceIdentiqueVerticale() {
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.VERTICAL);
        s.setCoordinate(new Coordinate(5, 5));

        Ship s2 = new Caravelle();
        s2.setOrientation(Ship.Orientation.VERTICAL);
        s2.setCoordinate(new Coordinate(5, 5));

        map.ajouterBateau(s);

        boolean b = map.verificationsPlacement(s2.getCoordinate().getX(), s2.getCoordinate().getY(), s2.getSize(), s2.getOrientation());
        assertEquals(false, b);
    }



    /**
     * on test si c'est possible de placer un bateau exactement sur  un autre
     * dans la position Horizontale
     */
    @Test
    public void verificationPlacementBateauDejaPlaceIdentiqueHorizontale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        s.setCoordinate(new Coordinate(5, 5));

        Ship s2 = new Croiseur();
        s2.setOrientation(Ship.Orientation.HORIZONTAL);
        s2.setCoordinate(new Coordinate(5, 5));

        map.ajouterBateau(s);

        boolean b = map.verificationsPlacement(s2.getCoordinate().getX(), s2.getCoordinate().getY(), s2.getSize(), s2.getOrientation());
        assertEquals(false, b);
    }


    /**
     * on test si c'est possible de placer un bateau sur une case ou se trouve deja un bateau
     * normalement le test retourne non
     */
    @Test
    public void verificationPlacementBateauDejaPlaceDifferentHorizontale(){
        Ship s = new Croiseur();
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        s.setCoordinate(new Coordinate(0, 0));

        Ship s2 = new Croiseur();
        s2.setOrientation(Ship.Orientation.VERTICAL);
        s2.setCoordinate(new Coordinate(0, 0));

        map.ajouterBateau(s);

        boolean b = map.verificationsPlacement(s2.getCoordinate().getX(), s2.getCoordinate().getY(), s2.getSize(), s2.getOrientation());
        assertEquals(false, b);
    }


    /**
     * test d ajout d un bateau horizontalement
     * on verifie si la position sur la grille n'est plus null
     */
    @Test
    public void ajouterBateauHorizontal(){
        Ship s = new Croiseur();
        s.setCoordinate(new Coordinate(2,2));
        s.setOrientation(Ship.Orientation.VERTICAL);
        map.ajouterBateau(s);
        for(int i = s.getCoordinate().getX(); i < s.getCoordinate().getX() + s.getSize(); i++){
            assertNotNull(map.getMapDispositionBateaux()[s.getCoordinate().getY()][i]);
        }
    }


    /**
     * test d ajout d un bateau verticalement
     * on verifie si la position sur la grille n'est plus null
     */
    @Test
    public void ajouterBateauVertical(){
        Ship s = new Croiseur();
        s.setCoordinate(new Coordinate(2,2));
        s.setOrientation(Ship.Orientation.VERTICAL);
        map.ajouterBateau(s);
        for(int i = s.getCoordinate().getY(); i < s.getCoordinate().getY() + s.getSize(); i++){
            assertNotNull(map.getMapDispositionBateaux()[i][s.getCoordinate().getX()]);
        }
    }




    /**
     * on test que quand on supprime un bateau VERTICAL il soit bien supprimé
     */
    @Test
    public void supprimerBateauVertical(){
        Ship s = new Croiseur();
        s.setCoordinate(new Coordinate(2,2));
        s.setOrientation(Ship.Orientation.VERTICAL);
        map.ajouterBateau(s);
        map.supprimerBateau(s);
        ShipPiece[][] sp = map.getMapDispositionBateaux();
        for(int yi = 2; yi < 2+s.getSize(); yi++){
            assertEquals(StatePiece.EMPTY,  sp[yi][2].getState());
        }
    }


    /**
     * on test que quand on supprime un bateau HORIZONTAL il soit bien supprimé
     */
    @Test
    public void supprimerBateauHorizontal(){
        Ship s = new Croiseur();
        s.setCoordinate(new Coordinate(2,2));
        s.setOrientation(Ship.Orientation.HORIZONTAL);
        map.ajouterBateau(s);
        map.supprimerBateau(s);
        ShipPiece[][] sp = map.getMapDispositionBateaux();
        for(int yi = 2; yi < 2+s.getSize(); yi++){
            assertEquals(StatePiece.EMPTY,  sp[yi][2].getState());
        }
        for(int xi = 2; xi < 2+s.getSize(); xi++){
            assertEquals(StatePiece.EMPTY,  sp[2][xi].getState());
        }
    }



}