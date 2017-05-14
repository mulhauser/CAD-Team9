# CAD-Team9
Diagramme UML, etc : https://www.lucidchart.com/invitations/accept/4ac5469f-1d5e-4b8b-aebd-0011505baddc

Ce projet nécessite gradle 3.5 et java 1.8
# Nettoyage, Compilation, Execution
Il faut être dans le dossier CAD-Team9 pour exécuter toutes ces commandes gradle xxx
- nettoyer : gradle clean (supprime le dossier build)
- compilation : gradle fatJar (créer un dossier build et un fichier jar exécutable dans build/libs)
- exécution du jeu : java -jar build/libs/CAD-Team9-all-1.0.jar (ou en se plaçant dans le dossier build/libs/ java -jar CAD-Team9-all-1.0.jar)
- exécution des tests : gradle test, un dossier build est créé.
Pour voir le résultat des tests, il faut aller dans build/reports/tests/test/ et ouvrir dans votre navigateur internet le fichier index.html



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

#CAD-Team8 Modifications effectuées:

Ajout d'une stratégie : AdvancedStrategie
	=>Quadrillage du terrain pour trouver les bateaux puis exploration autour des cases de bateaux touchées.
	
Pour implémenter cette stratégie, une modification du modèle de stratégie à du être nécessaire.
La classe abstraite AttackStrategie a une méthode getStrategyShoot(int size) pour récupérer la position de tir choisie par l'IA.
Cependant, cela ne permettait pas de prendre en compte les informations sur les cases déjà touchées, et empêchait de finir de détruire les bateaux qui ont plus d'un de vie.
Nous l'avons donc modifié en getStrategyShoot(Map adverseMap) pour pouvoir avoir accès aux informations des cases déjà touchées.
Pour ce faire, il a fallu aussi modifié cette méthode dans les autres stratégies déjà implémentées.

Nous avons aussi modifié l'interface CréationNiveau pour ajouter cette stratégie, et l'IAFactory pour pouvoir l'ajouter au jeu.

