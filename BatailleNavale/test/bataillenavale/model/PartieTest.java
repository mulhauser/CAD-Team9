package bataillenavale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static bataillenavale.model.Epoque.XVI;
import static bataillenavale.model.Epoque.XX;
import static org.junit.Assert.*;

/**
 * Created by wolkowicz on 27/04/2017.
 */
public class PartieTest {

    // CLASSE DE TEST A EXECUTEE APRES PLAYER

    Partie partieXX;
    Partie partieXVI;
    Partie partieNull;
    Partie partieVide;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        partieXX = null;
        partieXVI = null;
        partieNull = null;
        partieVide = null;
        assertNull(partieXX);
        assertNull(partieXVI);
        assertNull(partieNull);
        assertNull(partieVide);
    }


    /**
     * on test que l epoque soit la bonne
     */
    @Test
    public void partieEpoqueXX(){
        partieXX = new Partie( "michel",  XX);
        assertEquals(XX, partieXX.getEpoque());
    }


    /**
     * on test que le joueur soit le bon
     */
    @Test
    public void partiePseudoXX(){
        partieXX = new Partie( "michel",  XX);
        assertEquals("michel", partieXX.getHuman().getPseudo());
    }


    /**
     * on test que l epoque soit la bonne
     */
    @Test
    public void partieEpoqueXVI(){
        partieXVI = new Partie( "a",  XVI);
        assertEquals(XVI, partieXVI.getEpoque());
    }


    /**
     * on test que le joueur soit le bon
     */
    @Test
    public void partiePseudoXVI(){
        partieXVI = new Partie( "a",  XVI);
        assertEquals("a", partieXVI.getHuman().getPseudo());
    }


    /**
     * test si on peut savoir si on peut creer une partie sans joueur, et c'esdt le cas
     * du coup le joueur sera null mais pas vraiment, c'est le pseudo de celui-ci qui le sera
     * @throws NullPointerException
     */
    @Test
    public void partieNullTest() throws NullPointerException{
        partieNull = new Partie( null ,  XX);
       assertNull(partieNull.getHuman().getPseudo());
       // assertEquals("", partieNull.getHuman().getPseudo());
    }



    /**
     * on test si c'est possible de faire des parties avec un pseudo vide
     */
    @Test
    public void partieSansPseudoTest(){
        partieVide = new Partie( "",  XVI);
        assertEquals("", partieVide.getHuman().getPseudo());
    }

}