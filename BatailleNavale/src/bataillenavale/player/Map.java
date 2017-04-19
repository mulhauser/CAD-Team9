package bataillenavale.player;

import bataillenavale.ship.Ship;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Map extends AbstractModel {

    /*
    pour la mapDispositionBateau :
    le code est :
    0 = rien
    1 = petit bateau
    2 = moyen bateau
    3 = grand bateau
     */
    private int[][] mapDispositionBateaux;

    /*
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


    /**
     * va ajouter un bateau dans le tableau disposition
     * appèle une fonction qui vérifie puis une qui place
     * @param s
     */
    public void ajouterBateau(Ship s, int x, int y, Ship.Orientation orientation){
        if(s.getSize() == 2){
            // verificationDeplacement retourne true si tout est bien, sinon false
            if(verificationsDepacement(x, y, s.getSize(), orientation)){
               // mapDispositionBateaux[x][y]
            }
        }
    }



    /**
     * fonction qui vérifie si le bateau peut être placé à l'endoit séléctionné
     * @param x
     * @param y
     * @param size
     * @param orientation
     * @return
     */
    public boolean verificationsDepacement(int x, int y, int size, Ship.Orientation orientation){
        boolean result = false;
        switch (orientation){
            case TOP:
                if(y + size > mapDispositionBateaux.length){
                    result = false;
                }else{
                    result = true;
                }
                break;
            case BOTTOM:
                if(y - size < mapDispositionBateaux.length){
                    result = false;
                }else{
                    result = true;
                }
                break;
            case LEFT:
                if(x - size < mapDispositionBateaux.length){
                    result = false;
                }else{
                    result = true;
                }
                break;
            case RIGHT:
                if(x + size < mapDispositionBateaux.length){
                    result = false;
                }else{
                    result = true;
                }
                break;
        }

        return true;
    }




    public void placementBateau(int x, int y, int size, Ship.Orientation orientation){
        // ajouter un switch sur la taille
        switch (orientation){
            case TOP:

                break;
            case BOTTOM:

                break;
            case LEFT:

                break;
            case RIGHT:
                for(int i = x; i < x + size; i++){
                    mapDispositionBateaux[i][y] = 3;
                }
                break;
        }
    }




    public int[][] getMapDispositionBateaux() {
        return mapDispositionBateaux;
    }

    
    public int[][] getMapEtatBateaux() {
        return mapEtatBateaux;
    }
}
