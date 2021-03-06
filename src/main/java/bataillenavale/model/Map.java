package bataillenavale.model;

import bataillenavale.model.ship.Ship;
import bataillenavale.model.ship.ShipPiece;
import bataillenavale.model.ship.StatePiece;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mulhauser on 12/04/2017.
 */
public class Map implements Serializable {


    protected ShipPiece[][] mapDispositionBateaux;
    private static final long serialVersionUID = 8268151079120855484L;
    protected static final int size = 10;


    public Map() {
        this.mapDispositionBateaux = new ShipPiece[this.size][this.size];
        //this.mapEtatBateaux = new int[this.size][this.size];
        for (int i = 0; i < mapDispositionBateaux.length; i++) {
            for (int j = 0; j < mapDispositionBateaux[i].length; j++) {
                mapDispositionBateaux[i][j] = new ShipPiece(StatePiece.EMPTY);
                //mapEtatBateaux[i][j] = 0;
            }
        }
    }


    public void supprimerBateau(Ship s){
        int x = s.getCoordinate().getX();
        int y = s.getCoordinate().getY();
        int taille = s.getSize();
        Ship.Orientation orientation = s.getOrientation();

        switch (orientation){
            case HORIZONTAL:
                for(int xi = x; xi < x+taille; xi++){
                    mapDispositionBateaux[y][xi] = new ShipPiece(StatePiece.EMPTY);
                }
                s.setPlaced(false);
                break;
            case VERTICAL:
                for(int yi = y; yi < y+taille; yi++){
                    mapDispositionBateaux[yi][x] = new ShipPiece(StatePiece.EMPTY);
                }
                s.setPlaced(false);
                break;
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
    public boolean ajouterBateau(Ship s) {
        boolean ajout = false;
        //if (s.getSize() == 2) {
        // verificationDeplacement retourne true si tout est bien, sinon false
        if (verificationsPlacement(s.getCoordinate().getX(), s.getCoordinate().getY(), s.getSize(), s.getOrientation())) {
            // si les vérifications concernant le placement sont validés alors on peut placer le bateau
            // On modifie également les coordonnées du bateau et son orientation
            s.setCoordinate(new Coordinate(s.getCoordinate().getX(), s.getCoordinate().getY()));
            placementBateau(s);
            ajout = true;
            s.setPlaced(true);
        }
        //}
        return ajout;
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
        if (verificationCoordinate(x, y)) {
            switch (orientation) {
                // On parcours le tableau de gauche à droite et de haut en bas
                case VERTICAL:
                    // On vérifie si on dépasse pas la map
                    if (y + size <= mapDispositionBateaux.length) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = y; i < y + size; i++) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(x, i).getState() != StatePiece.EMPTY) {
                                result = false;
                                break;
                            } else {
                                result = true;
                            }
                        }
                    }
                    break;
                case HORIZONTAL:
                    if (x + size <= mapDispositionBateaux[y].length) {
                        // On vérifie ensuite si il n'y a pas déjà un bateau sur les cases
                        for (int i = x; i < x + size; i++) {
                            // Si il y a déjà un bateau on met à false et on arrête la boucle
                            if (this.getShip(i, y).getState() != StatePiece.EMPTY) {
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

    public boolean verificationCoordinate(int x, int y) {
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
            case VERTICAL:
                j = 0;
                for (int i = c.getY(); i < c.getY() + taille; i++) {
                    mapDispositionBateaux[i][c.getX()] = shipList.get(j);
                    j++;
                }
                break;
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

    public int getSize() {
        return this.size;
    }

    public void setPiece(int x, int y, ShipPiece sp){
        this.mapDispositionBateaux[y][x] = sp;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int y = 0; y < mapDispositionBateaux.length; y++) {
            for (int x = 0; x < mapDispositionBateaux[y].length; x++) {
                sb.append("|");
                if (mapDispositionBateaux[y][x].getState() == StatePiece.EMPTY) sb.append(" X ");
                else sb.append(" O ");
                sb.append("|");
            }
            sb.append("\n----------------------------------------------------\n");
        }
        return sb.toString();
    }

    //permet de rérifier un seul élément dans la map, retourne true si un bateau est présent aux coordonnées x,y
    //false sinon
    public boolean getMapDispositionBateauxElement(int x, int y){
        if(mapDispositionBateaux[x][y]==null){
            return false;
        }else{
            return true;
        }
    }

    //public void setMapDispositionBateauxElement(int x, int y, boolean hit){
    public void setMapDispositionBateauxElement(int x, int y, boolean touche){
        if(touche){
            if(this.mapDispositionBateaux[x][y].getState()==StatePiece.HIT){
                //si le bateau a déja été touché à la case la
                System.out.println("Bateau déjà touché en X : "+x+", Y : "+y);
            }else if(this.mapDispositionBateaux[x][y].getState()==StatePiece.FAIL){
                //si tire dans l'eau pour la seconde fois ou plus
                System.out.println("Déjà plouf en X : "+x+", Y : "+y);
            }else{
                //si nouveau tire ok
                System.out.println("Touché en X : "+x+", Y : "+y);
                this.mapDispositionBateaux[x][y].setState(StatePiece.HIT);
            }
        }else {
            //si tire dans l'eau pour la premiere fois
            System.out.println("Plouf en X : "+x+", Y : "+y);
            this.mapDispositionBateaux[x][y] = new ShipPiece(StatePiece.FAIL);
        }
    }

}
