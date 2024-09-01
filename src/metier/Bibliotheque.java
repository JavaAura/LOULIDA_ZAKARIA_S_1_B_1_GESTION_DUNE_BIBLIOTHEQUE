package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bibliotheque {
    private ArrayList<Document> documents;
    private Map<String, Document> documentsMap;

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
        System.out.println("+--------------------------------+----------------------+------------------+-----------------+");
        System.out.printf("| %-30s | %-20s | %-16s | %-16s | %-16s |\n", "Titre", "Auteur", "Identifiant", "Date Publication","Type");
        System.out.println("+--------------------------------+----------------------+------------------+-----------------+");

        for (Document doc : documents) {
            doc.afficherDetails(); // This will call the specific afficherDetails() for Livre or Magazine
        }

        System.out.println("+--------------------------------+----------------------+------------------+-----------------+");
    }


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
