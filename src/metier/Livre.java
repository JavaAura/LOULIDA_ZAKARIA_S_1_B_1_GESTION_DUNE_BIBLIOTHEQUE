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
        if(isEmprunte()) {

            System.out.println("Le Livre '" + getTitre() + "' est déja emprunté.");
        }else {
            setEmprunte(true);
            System.out.println("Le Livre '" + getTitre() + "' a été emprunté.");
        }
    }

    @Override
    public void retourner() {

        if(isEmprunte()) {
            setEmprunte(false);
            System.out.println("Le Livre '" + getTitre() + "' a été retourné.");
        }else {

            System.out.println("Cette Livre '" + getTitre() + "' n'est pas emprunté.");
        }

    }

    @Override
    public void afficherDetails() {
        System.out.printf("| %-30s | %-20s | ISBN: %-10s | %-15s | Livre   |\n", getTitre(), getAuteur(), isbn, getDatePublication());
    }
}
