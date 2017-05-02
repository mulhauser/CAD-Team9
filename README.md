# CAD-Team9
Diagramme UML, etc : https://www.lucidchart.com/invitations/accept/4ac5469f-1d5e-4b8b-aebd-0011505baddc


Utilisation du fichier build.xml:

En faisant :      ant -buildfile build.xml
	- Les fichiers .class seront supprimés
	- Le projet sera compilé
	- Une archive du nom de cad-team9.jar sera crée
	- Les tests sont compilés puis éxécutés
	- Les fichiers .class seton à nouveau supprimés

Pour exécuter le fichier cad-team9.jar utiliser la commande : java -jar cad-team9.jar

Remarque concernant les tests :
L'exécution des test ne fonctionne pas avec ant, nous n'arrivons pas à régler ce problème.
Cependant les test fonctionne si on les éxécutent "manuellement" : 
La classe TestSuiteClass est une suite qui regroupe tous nos fichier de test.
En la compilant puis en l'éxécutant on constate que nos test fonctionnent bien mais via le script ant ils ne fonctionnent pas.
Dans notre fichier build.xml, nous utilisons pourtant pour la partie de l'exécution des tests le "template" que vous nous avez montré dans le cours sur les outils des méthodes agiles.


Jeu:

Lorsqu'il faut placer nos bateaux, le placement s'effectuera en choisissant l'orientation du bateau (horizontale ou verticale)
puis la position de la tête du bateau (partie haute si verticale, partie gauche si horizontale).
Vous avez la possibilité d'annuler le placement du dernier bateau que vous avez placé mais si vous avez placé plusieurs
bateaux et que vous souhaitez annuler le placement de tous ces bateaux, vous pourrez annuler seulement le dernier

Lorsque l'on joue si on joue l'epoque XX, il faudra toucher 2 fois chaque case du bateau car elles ont 2 vies chacune
Une case jaune: case non touchée
Une case orange: case touchée
Une case rouge: case morte
Une case bleue: case vide
Une case noire: tir loupé


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



Pour ajouter un moyen de sauvegarde:
- il suffit d'ajouter une classe qui hérite de la classe DAOSauvegarde et
d'implémenter les 3 méthodes getProfiles(), saveProfile(Profile p), profileExist(String nom)

