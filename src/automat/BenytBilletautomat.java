package automat;

//hello
import java.util.Scanner;

public class BenytBilletautomat {

    public static boolean valgt = false;
    public static boolean aktiv = true;

    public static void main(String[] arg) {

        Billetautomat automat = new Billetautomat();

        Scanner tastatur = new Scanner(System.in);  // forbered

        while (aktiv) {

            if (valgt == false) {
                automat.getMenu().visStartMenu(tastatur);

            }

            if (automat.erMontør()) {

                automat.getMenu().visMontørMenu(tastatur);

            } else {

                automat.getMenu().visBilletMenu(tastatur);
                automat.getMenu().visKundeMenu(tastatur);

            }

        }

    }
}
