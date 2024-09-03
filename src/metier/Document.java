package metier;

import java.time.LocalDate;

public abstract class Document {
    private static int compteurId = 0;

    private String id;
    private String titre;
    private String auteur;
    private LocalDate datePublication;
    private int nombreDePages;
    private boolean emprunte;
    public Document(String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        this.id = genererIdUnique();
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
    }

    private String genererIdUnique() {
        return "DOC" + (++compteurId);
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }

    public boolean isEmprunte() {
        return emprunte;
    }







    public abstract void emprunter();
    public abstract void retourner();
    public abstract void afficherDetails();
}
