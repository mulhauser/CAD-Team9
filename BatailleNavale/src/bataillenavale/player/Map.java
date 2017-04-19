package bataillenavale.player;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Map {

    /*
    pour la mapDispositionBateau :
    le code est :
    0 = rien
    1 = petit bateau
    2 = moyen bateau
    3 = grand bateau
     */
    private int[][] mapDispositionBateaux;

    /**
     * pour la mapEtatBateau :
     * le code est :
     * 0 = raté
     * 1 = touché
     */
    private int[][] mapEtatBateaux;
    private int size;

    public Map(int s){
        this.size = s;
        this.mapDispositionBateaux = new int[this.size][this.size];
        for (int i = 0; i < mapDispositionBateaux.length; i++){
            for (int j = 0; j < mapDispositionBateaux[i].length; j++){
                mapDispositionBateaux[i][j] = 0;
                mapEtatBateaux[i][j] = 0;
            }
        }
    }
}
