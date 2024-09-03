package presentation;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class InputValidator {

    public static boolean validerISBN(String isbn) {
        String regex = "^\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(isbn);
        return matcher.matches();
    }

    public static boolean validerNumero(String numero) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    public static String obtenirISBNValide(Scanner scanner) {
        while (true) {
            System.out.print("ISBN : ");
            String isbn = scanner.nextLine();
            try {
                if (validerISBN(isbn)) {
                    return isbn;
                } else {
                    System.out.println("ISBN invalide. Veuillez entrer un ISBN au format correct.");
                }
            } catch (PatternSyntaxException e) {
                System.out.println("Erreur dans le pattern ISBN : " + e.getMessage());
            }
        }
    }

    public static int obtenirNumeroValide(Scanner scanner) {
        while (true) {
            System.out.print("Numéro : ");
            String numeroStr = scanner.nextLine();
            try {
                if (validerNumero(numeroStr)) {
                    return Integer.parseInt(numeroStr);
                } else {
                    System.out.println("Numéro invalide. Veuillez entrer un numéro valide.");
                }
            } catch (PatternSyntaxException e) {
                System.out.println("Erreur dans le pattern de numéro : " + e.getMessage());
            }
        }
    }
}
