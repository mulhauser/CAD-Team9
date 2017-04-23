package bataillenavale.model;

import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipPiece;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Map implements Serializable {

    /*
    pour la mapDispositionBateau :
    le code est :
    0 = rien
    2 = petit bateau
    3 = moyen bateau
    4 = grand bateau
     */
    private ShipPiece[][] mapDispositionBateaux;

    /*
     * pour la mapEtatBateau :
     * le code est :
     * 0 = raté
     * 1 = touché
     */
    //private int[][] mapEtatBateaux;
    private static final int size = 10;


    public Map() {
        this.mapDispositionBateaux = new ShipPiece[this.size][this.size];
        //this.mapEtatBateaux = new int[this.size][this.size];
        for (int i = 0; i < mapDispositionBateaux.length; i++) {
            for (int j = 0; j < mapDispositionBateaux[i].length; j++) {
                mapDispositionBateaux[i][j] = null;
                //mapEtatBateaux[i][j] = 0;
            }
        }
    }


    /**
     * va ajouter un bateau dans le tableau disposition
     * appelle une fonction qui vérifie puis une qui place
     * on peut seulement placer le bateau en vertical ou horizontal,
     * on n'utilise plus haut, bas gauche, droite
     *
     * @param s
     */
    public void ajouterBateau(Ship s, int x, int y, Ship.Orientation orientation) {
        //if (s.getSize() == 2) {
            // verificationDeplacement retourne true si tout est bien, sinon false
            if (verificationsPlacement(x, y, s.getSize(), orientation)) {
                // si les vérifications concernant le placement sont validés alors on peut placer le bateau
                // On modifie également les coordonnées du bateau et son orientation
                s.setCoordinate(new Coordinate(x, y));
                s.setOrientation(orientation);
                placementBateau(s);
                System.out.println("Placement OK");
            }
        //}
    }


    /**
     * fonction qui vérifie si le bateau peut être placé à l'endoit séléctionné
     *
     * @param x
     * @param y
     * @param size
     * @param orientation
     * @return
     */
    public boolean verificationsPlacement(int x, int y, int size, Ship.Orientation orientation) {
        boolean result = false;
        // On verifie que les coordonnées sont correctes
        if(verificationCoordinate(x, y)) {
            switch (orientation) {
                // On parcours le tableau de gauche à droite et de haut en bas
                /*case TOP:
                    // On vérifie si on dépasse pas la map
                    if (y - size + 1 >= 0) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = y; i > y - size; i--) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(x, i) != null) {
                                result = false;
                                break;
                            } else {
                                result = true;
                            }
                        }
                    }
                    break;*/
                case VERTICAL:
                    // On vérifie si on dépasse pas la map
                    if (y + size <= mapDispositionBateaux.length) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = y; i < y + size; i++) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(x, i) != null) {
                                result = false;
                                break;
                            } else {
                                result = true;
                            }
                        }
                    }
                    break;
                /*case LEFT:
                    if (x - size + 1 >= 0) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = x; i > x - size; i--) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(i, y) != null) {
                                result = false;
                                break;
                            } else {
                                result = true;
                            }
                        }
                    }
                    break;*/
                case HORIZONTAL:
                    if (x + size <= mapDispositionBateaux[y].length) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = x; i < x + size; i++) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(i, y) != null) {
                                result = false;
                                break;
                            } else {
                                result = true;
                            }
                        }
                    }
                    break;
            }
        }

        return result;
    }

    public boolean verificationCoordinate(int x, int y){
        return (x >= 0 && x < mapDispositionBateaux.length) && (y >= 0 && y < mapDispositionBateaux.length);
    }


    /**
     * On parcourt le tableau de gauche à droite et de haut en bas
     *
     * @param x la ligne, abscisse
     * @param y la colonne, ordonnée
     * @return le morceau de bateau à la position x, y
     */
    public ShipPiece getShip(int x, int y) {
        return mapDispositionBateaux[y][x];
    }


    public void placementBateau(Ship s) {
        int taille = s.getSize();
        Coordinate c = s.getCoordinate();
        Ship.Orientation o = s.getOrientation();
        List<ShipPiece> shipList = s.getPieceShipList();
        int j;
        switch (o) {
            /*case TOP:
                j = 0;
                for (int i = c.getY(); i > c.getY() - taille; i--) {
                    mapDispositionBateaux[i][c.getX()] = shipList.get(j);
                    j++;
                }
                break;*/
            case VERTICAL:
                j = 0;
                for (int i = c.getY(); i < c.getY() + taille; i++) {
                    mapDispositionBateaux[i][c.getX()] = shipList.get(j);
                    j++;
                }
                break;
            /*case LEFT:
                j = 0;
                for (int i = c.getX(); i > c.getX() - taille; i--) {
                    mapDispositionBateaux[c.getY()][i] = shipList.get(j);
                    j++;
                }
                break;*/
            case HORIZONTAL:
                j = 0;
                for (int i = c.getX(); i < c.getX() + taille; i++) {
                    mapDispositionBateaux[c.getY()][i] = shipList.get(j);
                    j++;
                }
                break;
        }
    }


    public ShipPiece[][] getMapDispositionBateaux() {
        return mapDispositionBateaux;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int y = 0; y < mapDispositionBateaux.length; y++){
            for(int x = 0; x < mapDispositionBateaux[y].length; x++){
                sb.append("|");
                if(mapDispositionBateaux[y][x] == null) sb.append(" X ");
                else sb.append(" O ");
                sb.append("|");
            }
            sb.append("\n--------------------------\n");
        }
        return sb.toString();
    }
    /*public int[][] getMapEtatBateaux() {
        return mapEtatBateaux;
    }*/
}
