<h1 align=center>Patrons de conception</h1>

## 4.6 Exercices
### Exercice 4.1 (Builder,Composite,Iterator)
Dans cet exercice, vous réaliserez un annuaire des personnels d’une organisation.
Un personnel possède un nom, un prénom, une date de naissance, des numéros de téléphone (fixe pro,
fixe perso, portable, . . .) et des fonctions (par exemple directeur de XXX, chargé de mission XXX, . . .).
L’annuaire reflétera la structure hiérarchique de l’organisation (par exemple, département/service/équipe). Chaque niveau peut comporter des individus ou des sous-hiérarchies. Les différents niveaux de
structuration ne sont pas connus à priori.
On veut pouvoir afficher les personnels de l’organisation de deux manières : hiérarchiques (en profondeur) et par groupe (en largeur).
1. Représentez les personnels par une classe immuable Personnel. Le nom, le prénom et les fonctions
seront implémentés par des chaînes de caractères, la date de naissance par java.time.LocalDate
et les numéros de téléphone par une collection d’un type que vous définirez. L’initialisation d’un
personnel respectera le pattern Builder
2. Définissez la notion de groupe de personnels en vous appuyant sur le pattern Composite
3. Implémentez les deux types d’affichage en définissant deux stratégies de parcours de la structure. Ces
dernières se baseront sur le pattern Iterator. Plus précisément, vous vous appuierez sur les interfaces
java.util.iterator et java.lang.iterable.


### Exercice 4.2 (Command)
Dans cet exercice, on souhaite réaliser une calculatrice fonctionnant en mode RPN (Reverse Polish Notation). Cette notation post-fixée permet de représenter des formules arithmétiques sans parenthèses. Par
exemple, l’expression « 2 × (3 + 4) » pourra s’écrire « 234 + × ».
Cette calculatrice devra supporter les opérations de base (+, -, *, /) sur des nombres entiers.
L’interface utilisateur utilisera un interpréteur en mode texte. L’utilisateur saisira au clavier soit un nombre,
soit une opération, soit undo pour annuler la saisie précédente, soit exit pour sortir. Chaque saisie se
terminera par entrée.
L’implémentation pourra utiliser une pile de la façon suivante :
— les opérandes sont empilées lors de leur saisie,
— les opérations sont effectuées immédiatement en considérant les opérandes se trouvant au sommet
de la pile,
— le résultat d’une opération est empilé.
Après chaque saisie, l’interpréteur affichera le contenu de la pile.
Pour la conception, vous pourrez consulter Example calculator design.
1. Implémentez un interpréteur générique Interpreteur qui supporte uniquement les commandes
undo et quit. La commande quit stoppe le programme. La commande undo supprime la dernière
commande de l’historique. Vous utiliserez le pattern Command pour implémenter les actions.
2. Dérivez la classe MoteurRPN de l’interpréteur. Elle devra permettre de :
— enregistrer une opérande,
— appliquer une opération sur les opérandes,
— retourner l’ensemble des opérandes stockées.
Vous utiliserez le pattern Command pour implémenter les actions.
3. Implémenter la classe SaisieRPN qui gère les interactions avec l’utilisateur et invoque le moteur
RPN. La classe java.util.Scanner permet de gérer les saisies.
4. Implémenter le programme principal CalculatriceRPN.
