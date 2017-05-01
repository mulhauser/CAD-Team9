package bataillenavale.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by wolkowicz on 30/04/2017.
 */
public class ProfileTest {

    Profile p1, p2;


    @Before
    public void setUp() throws Exception {
        p1 = new Profile("michel");
        p2 = new Profile("coucou");

    }

    @After
    public void tearDown() throws Exception {
        p1 = null;
        p2 = null;
        assertNull(p1);
        assertNull(p2);
    }








    /**
     * on test si deux id sont bien incrementees de 1 a chaques creation
     * @throws Exception
     */
    @Test
    public void getId() {
        Profile pa = new Profile("aze");
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Profile pb = new Profile("eza");
        assertEquals(pa.getId()+1, pb.getId());
    }




    /**
     * on test que quand un profil se cree, il n'y ait pas de partie dedans
     */
    @Test
    public void testnombrePartieInitialZERO(){
        assertEquals(0, p1.getParties().size());
    }


    /**
     * on regarde si apres deux ajouts le nombre de partie est bien de deux
     */
    @Test
    public void testNombrePartieApresAjout1(){
        //p1.ajouterPartie(new Partie("michel", XX, null));
        //p1.ajouterPartie(new Partie("michel", XX, null));
        assertEquals(2, p1.getParties().size());

    }


    /**
     * on test si c'est possible de creer deux profiles de meme noms
     * ?????? normalement pas de soucis mais pas forcement bon
     */
    @Test
    public void testCreationProfileDeMemeNom(){
        Profile p3 = new Profile("michel");
        // quelques trucs interessant a faire ici genre plusieurs scenar sur recuperation d une partie chez quelqu un puis qqun d autre
    }


    /**
     * on test si apres ajout puis suppression de partie pour un joueur la taille de la hashmap de partie est bien de 0
     */
    @Test
    public void supprimer() /*throws NullPointerException*/{
        //p1.ajouterPartie(new Partie("michel", XX, null));
        p1.supprimer((Partie) p1.getParties().get(p1.getId()));
        assertEquals(0, p1.getParties().size());
    }





    @Test
    public void getPseudo() {
        assertEquals("michel", p1.getPseudo());
    }


}