package automat;

//hello
import java.util.Scanner;

public class BenytBilletautomat {

    private static boolean billettypeValgt = false;

    public static void main(String[] arg) {
        Billetautomat automat = new Billetautomat();
        Scanner tastatur = new Scanner(System.in);  // forbered

        while (true) {

            if (!billettypeValgt) {
                int billettypeValg = 0;
                System.out.println("Vælg billettype:");
                System.out.println("1 Børnebillet  (12,00 kr)");
                System.out.println("2 Voksenbillet (24,00 kr)");

                int x = 1;
                do {

                    try {
                        billettypeValg = tastatur.nextInt();
                        x=2;
                    } catch (Exception e) {
                        System.out.println("hov, du indtastet ikke et tal");
                        tastatur.nextLine();
                    }
                } while (x == 1);

                if (billettypeValg == 1) {
                    automat.setTilBetaling(automat.getBørneBilletPris());

                } else if (billettypeValg == 2) {
                    automat.setTilBetaling(automat.getVoksenBilletPris());

                    billettypeValgt = true;

                    System.out.println("-----------------------------------------------");
                    System.out.println("En billet koster " + automat.getTilBetaling() + " kroner");
                    System.out.println("Balancen er på " + automat.getBalance() + " kroner");
                    System.out.println();
                    System.out.println("Tast 1 for at indbetale penge");
                    System.out.println("Tast 2 for at udskrive din billet");
                    System.out.println("Tast 3 for at få returpengene");
                    System.out.println("Tast 4 for at vælge en anden billettype");
                    System.out.println("tast 5 for at afslutte");
                    System.out.println("Tast 10 for at logge ind som montør");
                    if (automat.erMontør()) {
                        System.out.println("-----Montør tilstand-----");
                        System.out.println("Tast 11 for at se status (montør)");
                        System.out.println("Tast 12 for at nulstille (montør)");
                        System.out.println("Tast 13 for at sætte billetpris (montør)");
                        System.out.println("Tast 14 for at logge ud af montørtilstand");
                        System.out.println("tast 15 for at udbetale indkomst");
                    }
                    int valg = tastatur.nextInt();
                    tastatur.nextLine();

                    if (valg == 1) {
                        System.out.print("Skriv beløb: ");
                        int beløb = tastatur.nextInt();
                        automat.indsætPenge(beløb);
                    } else if (valg == 2) {
                        automat.udskrivBillet();
                    } else if (valg == 3) {
                        int beløb = automat.returpenge();
                        System.out.println("Du fik " + beløb + " kr retur");
                    } else if (valg == 4) {
                        billettypeValgt = false;
                    } else if (valg == 5) {
                        System.out.println("\n\nTak for at benytte vores billetautomat, programmet afsluttes.");
                        break;
                    } else if (valg == 10) {
                        if (!Billetautomat.montørtilstand) {
                            System.out.print("Skriv kode: ");
                            String kode = tastatur.next();
                            automat.montørLogin(kode);
                        } else {
                            System.out.println("Allerede logget ind");
                        }
                    } else if (valg == 11) {
                        System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
                        System.out.println("Total indkomst: " + automat.getIndkomst() + " kr");
                    } else if (valg == 12) {
                        automat.nulstil();
                    } else if (valg == 13) {
                        System.out.print("Skriv beløb for børn: ");
                        int beløbBørn = tastatur.nextInt();

                        System.out.print("Skriv beløb for voksne: ");
                        int beløbvoksne = tastatur.nextInt();
                        automat.definerBilletPriser(beløbBørn, beløbvoksne);
                    } else if (valg == 14) {
                        automat.montørLogin("");

                    } else if (valg == 15) {
                        automat.tømAutomat();
                    } else {
                        System.out.println("Ugyldigt valg, prøv igen");
                    }
                }
            }
        }
    }
}
