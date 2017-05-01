package bataillenavale.model;

import bataillenavale.model.player.strategies.AttackStrategies;
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
    AttackStrategies strategie;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        partieXX = null;
        partieXVI = null;
        partieNull = null;
        partieVide = null;
        strategie = null;
        assertNull(partieXX);
        assertNull(partieXVI);
        assertNull(partieNull);
        assertNull(partieVide);
        assertNull(strategie);
    }


    /**
     * on test que l epoque soit la bonne
     */
    @Test
    public void partieEpoqueXX(){
        strategie = null;
        partieXX = new Partie(XX, strategie);
        assertEquals(XX, partieXX.getEpoque());
    }




    /**
     * on test que l epoque soit la bonne
     */
    @Test
    public void partieEpoqueXVI(){
        strategie = null;
        partieXVI = new Partie(XVI, strategie);
        assertEquals(XVI, partieXVI.getEpoque());
    }




/*
    /**
     * test si on peut savoir si on peut creer une partie sans joueur, et c'esdt le cas
     * du coup le joueur sera null mais pas vraiment, c'est le pseudo de celui-ci qui le sera
     * @throws NullPointerException
     *
    @Test
    public void partieNullTest() throws NullPointerException{
        strategie = null;
        partieNull = new Partie(XX, strategie);
       assertNull(partieNull.getHuman().getPseudo());
       // assertEquals("", partieNull.getHuman().getPseudo());
    }*/


/*
    /**
     * on test si c'est possible de faire des parties avec un pseudo vide
     *
    @Test
    public void partieSansPseudoTest(){
        strategie = null;
        partieVide = new Partie( "",  XVI, strategie);
        assertEquals("", partieVide.getHuman().getPseudo());
    }*/

}