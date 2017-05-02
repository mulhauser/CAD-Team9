# CAD-Team9
Diagramme UML, etc : https://www.lucidchart.com/invitations/accept/4ac5469f-1d5e-4b8b-aebd-0011505baddc


UTILISATION DU FICHIER BUILD.XML


En faisant :      ant -buildfile build.xml
	- Les fichiers .class seront supprimés
	- Le projet sera compilé
	- Une archive du nom de CAD_TEAM9.jar sera crée
	- (les test ça vient)
	- Les fichiers .class seton à nouveau supprimés

Pour ajouter une Epoque:
- créer un package "nomdevotrepackage" dans le package bataillenavale.model.ship
- créer une classe EpoqueNOMDEVOTREEPOQUE dans le package bataillenavale.model
    cette classe devra extends de la classe Ship et implementer l'interface Serializable : il faudra modifier
    seulement le 3eme parametres du super() qui représente le nombre de vie de chaque partie du bateau, le constructeur
    de cette classe prend 2 parametres
- ensuite dans le package "nomdevotrepackage" il faudra créer au maximum 5 classes avec le nom de chaque bateau
    ces classes devront extends de votre classe epoqueNOMDEVOTREEPOQUE créée précédemment et implémenter l'interface
    Serializable cette classe ne prend aucun parametre mais il faudra mettre le nom du bateau et sa taille dans le super()
- il faudra dans la classe ShipFactory ajouter un case dans le switch de la methode getShipByEpoque(Epoque e) et répéter
    le modele de construction de la liste de bateaux


Pour ajouter un moyen de sauvegarde, il suffit d'ajouter une classe qui hérite de la classe DAOSauvegarde et 
d'implémenter les 3 méthodes getProfiles(), saveProfile(Profile p), profileExist(String nom)

