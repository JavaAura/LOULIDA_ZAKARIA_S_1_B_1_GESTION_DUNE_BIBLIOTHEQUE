package metier;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        System.out.println("Le livre '" + getTitre() + "' a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le livre '" + getTitre() + "' a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.printf("| %-30s | %-20s | ISBN: %-10s | %-15s | Livre   |\n", getTitre(), getAuteur(), isbn, getDatePublication());
    }
}
