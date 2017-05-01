package bataillenavale.model.player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * Created by wolkowicz on 27/04/2017.
 */
public class PlayerTest {

    private Player player, playerNull, playerVide;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        player = null;
        playerNull = null;
        playerVide = null;
        assertNull(player);
        assertNull(playerNull);
        assertNull(playerVide);
    }



    /**
     * on test qu'un joueur ait bien le bon pseudo
     * @throws Exception
     */
    @Test
    public void getPseudoPlayer()  {
        //player =  new Human("michel");
        //assertEquals("michel", player.getPseudo());
    }



    /**
     * test si on peut creer un player avec un string null
     *
     * @throws NullPointerException
     */
    @Test
    public void getPseudoPlayerNull() throws NullPointerException{
        //playerNull = new Human(null);
        //assertNull(playerNull.getPseudo());
    }


    /**
     * test si on peut creer un player avec un pseudo ne contenant aucun char
     */
    @Test
    public void getPseudoPlayerVide(){
        //playerVide = new Human("");
        //assertEquals("", playerVide.getPseudo());

    }


    /**
     * test si la fonction setPseudo fonctionne correctement
     * @throws Exception
     */
    @Test
    public void setPseudo()   {
        //playerVide = new Human("");
        //playerVide.setPseudo("test1");
        //assertEquals("test1", playerVide.getPseudo());
    }


    /**
     * on test si on peut mettre un pseudo a vide apres que la player soit cree
     */
    @Test
    public void setPseudoNull(){
        //playerVide = new Human("");
        //playerVide.setPseudo(null);
        //assertNull(playerVide.getPseudo());
    }





}