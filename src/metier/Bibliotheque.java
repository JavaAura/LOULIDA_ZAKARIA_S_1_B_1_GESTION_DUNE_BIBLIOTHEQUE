package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private HashMap<String, Document> documentsMap;




    //ArrayList vs. LinkedList
    /*
    * The LinkedList class is a collection which can contain many objects of the same type, just like the ArrayList.
    * the difference is aaraylist If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.
    *The LinkedList stores its items in "containers."
    *  The list has a link to the first container and each container has a link to the next container in the list.
    *  To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.
     */

    //HashMap Vs Hashset
    /* A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).
    *One object is used as a key (index) to another object (value).
    * It can store different types: String keys and Integer values, or the same type, like: String keys and String values:
    **Hashset
    * A HashSet is a collection of items where every item is unique, and it is found in the java.util package:
    * */
    public Bibliotheque() {
        documents = new ArrayList<>();
        documentsMap = new HashMap<>();
    }

    public void ajouterDocument(Document doc) {
        documents.add(doc);
        documentsMap.put(doc.getTitre(), doc);
    }

    public void emprunterDocument(String titre) {
        Document doc = documentsMap.get(titre);
        if (doc != null) {
            doc.emprunter();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void retournerDocument(String titre) {
        Document doc = documentsMap.get(titre);
        if (doc != null) {
            doc.retourner();
        } else {
            System.out.println("Document non trouvé.");
        }
    }

    public void afficherTousLesDocuments() {
        if (documents.isEmpty()){

            System.out.println("+------------------+-----------------+-----------------+Aucun document disponible.+--------------------------------+----------------------+");

        }else {
        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");
        System.out.printf("| %-30s | %-20s | %-16s | %-16s | %-16s |\n", "Titre", "Auteur", "Identifiant", "Date Publication","Type");
        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");

        for (Document doc : documents) {
            doc.afficherDetails(); // This will call the specific afficherDetails() for Livre or Magazine
        }
        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");
    }
    }
    //there another way to loop through collections, like ArrayList and HashSet.
    // it's an object who have this  hasNext() and next() methods :


//    public void afficherTousLesDocuments() {
//        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");
//        System.out.printf("| %-30s | %-20s | %-16s | %-16s | %-16s |\n", "Titre", "Auteur", "Identifiant", "Date Publication","Type");
//        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");
//
//        Iterator<Document> iterator = documents.iterator(); // Create an iterator for the documents list
//        while (iterator.hasNext()) {
//            Document doc = iterator.next(); // Get the next document
//            doc.afficherDetails(); // Call the specific afficherDetails() method for each document
//        }
//
//        System.out.println("+--------------------------------+----------------------+------------------+-----------------+-----------------+");
//    }
    public void rechercherDocument(String query) {
        boolean found = false;
        for (Document doc : documents) {
            if (doc.getTitre().toLowerCase().contains(query.toLowerCase())) {
                doc.afficherDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun document trouvé pour la recherche : " + query);
        }
    }

}
