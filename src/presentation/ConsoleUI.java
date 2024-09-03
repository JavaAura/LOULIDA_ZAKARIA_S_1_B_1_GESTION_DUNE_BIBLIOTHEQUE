package presentation;

import metier.Bibliotheque;
import metier.Livre;
import metier.Magazine;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public ConsoleUI() {
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    public void demarrer() {
        int choix = -1; // Initialize with an invalid value
        do {
            afficherMenu();
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character left in the buffer

                switch (choix) {
                    case 1:
                        ajouterDocument();
                        break;
                    case 2:
                        emprunterDocument();
                        break;
                    case 3:
                        retournerDocument();
                        break;
                    case 4:
                        afficherTousLesDocuments();
                        break;
                    case 5:
                        rechercherDocument();
                        break;
                    case 6:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, réessayez.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre entre 1 et 6.");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        } while (choix != 6);
    }

    private void afficherMenu() {
        System.out.println("Menu:");
        System.out.println("1. Ajouter un document");
        System.out.println("2. Emprunter un document");
        System.out.println("3. Retourner un document");
        System.out.println("4. Afficher tous les documents");
        System.out.println("5. Rechercher un document");
        System.out.println("6. Quitter");
        System.out.print("Veuillez entrer votre choix (1-6) : ");
    }

    private void ajouterDocument() {
        System.out.println("Ajouter un document:");

        int type;
        do {
            System.out.print("Type (1: Livre, 2: Magazine) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre (1 ou 2).");
                scanner.next();
            }
            type = scanner.nextInt();
            scanner.nextLine();
        } while (type != 1 && type != 2);

        System.out.print("Titre : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();

        LocalDate datePublication;
        while (true) {
            System.out.print("Date de publication (AAAA-MM-JJ) : ");
            String dateStr = scanner.nextLine();
            try {
                datePublication = LocalDate.parse(dateStr);
                break;
            } catch (Exception e) {
                System.out.println("Date invalide. Veuillez entrer la date au format AAAA-MM-JJ.");
            }
        }

        int nombreDePages;
        while (true) {
            System.out.print("Nombre de pages : ");
            if (scanner.hasNextInt()) {
                nombreDePages = scanner.nextInt();
                scanner.nextLine();
                if (nombreDePages > 0) {
                    break;
                } else {
                    System.out.println("Le nombre de pages doit être supérieur à zéro.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
        }

        if (type == 1) {
            String isbn = InputValidator.obtenirISBNValide(scanner);
            bibliotheque.ajouterDocument(new Livre(titre, auteur, datePublication, nombreDePages, isbn));
        } else if (type == 2) {
            int numero = InputValidator.obtenirNumeroValide(scanner);
            bibliotheque.ajouterDocument(new Magazine(titre, auteur, datePublication, nombreDePages, numero));
        }
    }

    private void emprunterDocument() {
        System.out.print("Titre du document à emprunter : ");
        String titre = scanner.nextLine();
        bibliotheque.emprunterDocument(titre);
    }

    private void retournerDocument() {
        System.out.print("Titre du document à retourner : ");
        String titre = scanner.nextLine();
        bibliotheque.retournerDocument(titre);
    }

    private void afficherTousLesDocuments() {
        bibliotheque.afficherTousLesDocuments();
    }

    private void rechercherDocument() {
        System.out.print("Titre du document à rechercher : ");
        String titre = scanner.nextLine();
        bibliotheque.rechercherDocument(titre);
    }

    public static void main(String[] args) {
        ConsoleUI app = new ConsoleUI();
        app.demarrer();
    }
}
