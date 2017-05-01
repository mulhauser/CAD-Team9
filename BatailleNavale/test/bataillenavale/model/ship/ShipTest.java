package bataillenavale.model.ship;

import bataillenavale.model.Coordinate;
import bataillenavale.model.ship.xvi.Corsaire;
import bataillenavale.model.ship.xx.Croiseur;
import bataillenavale.model.ship.xx.PorteAvion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static bataillenavale.model.Epoque.XX;
import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 29/04/2017.
 */
public class ShipTest {

   // ArrayList<Ship> ships;
    Ship ship;



    // probleme avec le constructeur de shoip toujours pour l'image codé en dur
    // probleme avec la shipfactory pour l'image , codé en dur
    @Before
    public void setUp() throws Exception {
        //ships = ShipFactory.getInstance().getShipsByEpoque(XX);
        ship = new Croiseur();
    }

    @After
    public void tearDown() throws Exception {
        ship = null;
        assertNull(ship);
    }





    @Test
    public void nomShipTest(){
       // Ship pa = ships.get(0);
        assertEquals("Croiseur",ship.getNom());
    }



    @Test
    public void getSize() {
        //Ship pa = ships.get(0); // le 1ere est censé etre un porte avion donc taille 5
        assertEquals(4, ship.getSize());
    }

    @Test
    public void getPieceShipList() {
        List<ShipPiece> pieceShipList = new ArrayList<>();
        //Ship pa = ships.get(0);
        for (int i = 0; i < ship.getSize(); i++) {
            pieceShipList.add(new ShipPiece(ship));
        }
        assertEquals(pieceShipList, ship.getPieceShipList());
    }

    @Test
    public void setOrientationVertical() {
        ship.setOrientation( Ship.Orientation.VERTICAL);
        assertEquals(Ship.Orientation.VERTICAL, ship.getOrientation());
    }

    @Test
    public void setOrientationHorizontal() {
        ship.setOrientation( Ship.Orientation.HORIZONTAL);
        assertEquals(Ship.Orientation.HORIZONTAL, ship.getOrientation());
    }

    @Test
    public void setCoordinate(){
        Coordinate c = new Coordinate(0,0);
        ship.setCoordinate(c);
        assertEquals(c, new Coordinate(0,0));
    }




    @Test
    public void getNom() {
        String nom = ship.getNom();
        assertEquals("Croiseur", nom);
    }

    @Test
    public void setNom(){
       String nom = "test";
       ship.setNom(nom);
       assertEquals(nom, ship.getNom());
    }


    /**
     * cas ou le bateau est détruit
     * @throws Exception
     */
    @Test
    public void isDestroyShipDestry() {
        List<ShipPiece> sp = ship.getPieceShipList();
        for (ShipPiece s : sp){
            s.setState(StatePiece.HIT);
        }
        assertEquals(true, ship.isDestroy());
    }


    /**
     * cas ou le bateau n'est pas détruit
     * @throws Exception
     */
    @Test
    public void isDestroyNOTShipDestry()  {
        List<ShipPiece> sp = ship.getPieceShipList();
        for (ShipPiece s : sp){
            s.setState(StatePiece.MISS);
        }
        assertEquals(false, ship.isDestroy());
    }


    /**
     * cas ou le bateau n'est pas entierement détruit
     * @throws Exception
     */
    @Test
    public void isDestroyNEARLYShipDestry() {
        List<ShipPiece> sp = ship.getPieceShipList();
        for (ShipPiece s : sp){
            s.setState(StatePiece.HIT);
        }
        sp.get(0).setState(StatePiece.MISS);
        assertEquals(false, ship.isDestroy());
    }




}