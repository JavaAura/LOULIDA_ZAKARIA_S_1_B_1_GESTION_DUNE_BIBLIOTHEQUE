package metier;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;

    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, int numero) {
        super(titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void emprunter() {
        if(isEmprunte()) {

            System.out.println("Le magazine '" + getTitre() + "' est déja emprunté.");
        }else {
            setEmprunte(true);
            System.out.println("Le magazine '" + getTitre() + "' a été emprunté.");
        }
    }


    @Override
    public void retourner() {

        if(isEmprunte()) {
            setEmprunte(false);
            System.out.println("Le magazine '" + getTitre() + "' a été retourné.");
        }else {

            System.out.println("Cette magazine '" + getTitre() + "' n'est pas emprunté.");
        }

    }

    @Override
    public void afficherDetails() {
        System.out.printf("| %-30s | %-20s | Numéro: %-8d | %-15s | Magazine|\n", getTitre(), getAuteur(), numero, getDatePublication());
    }
}
