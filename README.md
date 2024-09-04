# Bibliothèque Municipale - Système de Gestion

## Contexte du Projet

La bibliothèque municipale souhaite automatiser ses tâches via un **système de gestion informatisé**. Ce projet consiste à développer une **application console** en Java 8 permettant de gérer efficacement l'inventaire des livres et magazines ainsi que les emprunts et retours.

## Fonctionnalités Principales

- Ajouter un document (livre ou magazine)
- Emprunter un document
- Retourner un document
- Afficher tous les documents
- Rechercher un document
- Quitter l'application

## Structure de l'Application

L'application suit une **architecture en couches** :

1. **Couche de présentation** :
    - Classe `ConsoleUI` pour l'interface utilisateur, qui permet de naviguer via un menu interactif.

2. **Couche métier** :
    - Classe abstraite `Document` avec des classes filles `Livre` et `Magazine`.
    - Classe `Bibliotheque` pour la gestion des documents (ajout, recherche, emprunt, retour).

3. **Couche utilitaire** :
    - Classe `DateUtils` pour la manipulation des dates.

## Contenu des Classes

### Classe Abstraite `Document`

- **Attributs** : `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`
- **Méthodes abstraites** : `emprunter()`, `retourner()`, `afficherDetails()`

### Classe `Livre` (hérite de `Document`)

- Attribut supplémentaire : `isbn`
- Implémente les méthodes abstraites

### Classe `Magazine` (hérite de `Document`)

- Attribut supplémentaire : `numero`
- Implémente les méthodes abstraites

### Classe `Bibliotheque`

- Gère les opérations sur les documents : ajout, emprunt, retour, recherche.

## Spécifications Techniques

- **Stockage** des documents avec `ArrayList<Document>`.
- **Recherche rapide** à l'aide de `HashMap<String, Document>`.
- Utilisation de la **Java Time API** pour la gestion des dates.
- Implémentation des **expressions lambda** pour certaines opérations.

## Interface Utilisateur

L'application présente un **menu interactif** avec les options suivantes :


- Ajouter un document
- Emprunter un document
- Retourner un document
- Afficher tous les documents
- Rechercher un document
- Quitter