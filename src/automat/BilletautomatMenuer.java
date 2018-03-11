/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hamza
 */
public class BilletautomatMenuer {

    private Billetautomat automat;

    public BilletautomatMenuer(Billetautomat automat) {
        this.automat = automat;

    }

    private int valg;
    public void visStartMenu(Scanner tastatur) {

        do {

            System.out.println("tryk 1 for køb af billetter\ntryk 2 for login som montør");

            try {
                valg = tastatur.nextInt();

            } catch (Exception e) {
                System.out.println("indtast venligst et tal");
                System.out.println("Prøv venligst");
                tastatur.nextLine();
            }

            if (valg == 1) {

                break;

            } else if (valg == 2) {
                if (!automat.montørtilstand) {
                    System.out.print("Skriv kode: ");
                    String kode = tastatur.next();
                    automat.montørLogin(kode);
                    BenytBilletautomat.valgt = true;
                    break;
                } else {
                    System.out.println("Allerede logget ind");
                    break;
                }

            }
        } while (true);

    }

    public void visBilletMenu(Scanner tastatur) {

        int voksenPris = 0;
        int børnePris = 0;
        int cykelPris = 0;

        System.out.println("vælg destination for rejsen\ntryk 1 for København H     tryk 2 for Oddense C     tryk 3 for Århus C");
        int startdestinationsValg = tastatur.nextInt();
        System.out.println("Hvor rejser du fra\ntryk 1 for København H     tryk 2 for Oddense C     tryk 3 for Århus C");
        int slutdestinationsvalg = tastatur.nextInt();

        if (startdestinationsValg == 1 && slutdestinationsvalg == 1) {
                 børnePris = 12; 
                 voksenPris = 24;
                 cykelPris = 12;
        } else if (startdestinationsValg == 1 && slutdestinationsvalg == 2) {
                 børnePris = 115; 
                 voksenPris = 189;
                 cykelPris = 36;
        } else if (startdestinationsValg == 1 && slutdestinationsvalg == 3) {
                 børnePris = 169; 
                 voksenPris = 259;
                 cykelPris = 36;
        } else if (startdestinationsValg == 2 && slutdestinationsvalg == 1) {
                 børnePris = 115; 
                 voksenPris = 189;
                 cykelPris = 36;
        } else if (startdestinationsValg == 2 && slutdestinationsvalg == 2) {
                 børnePris = 12; 
                 voksenPris = 24;
                 cykelPris = 12;
        } else if (startdestinationsValg == 2 && slutdestinationsvalg == 3) {
                 børnePris = 89; 
                 voksenPris = 135;
                 cykelPris = 36;
        } else if (startdestinationsValg == 3 && slutdestinationsvalg == 1) {
                 børnePris = 169; 
                 voksenPris = 259;
                 cykelPris = 36;
        } else if (startdestinationsValg == 3 && slutdestinationsvalg == 2) {
                 børnePris = 89; 
                 voksenPris = 135;
                 cykelPris = 36;
        } else if (startdestinationsValg == 3 && slutdestinationsvalg == 3) {
                 børnePris = 12; 
                 voksenPris = 24;
                 cykelPris = 12;
        }

        do {

            System.out.println("1. Tilføj børnebillet (" + børnePris + " kr)");
            System.out.println("2. Tilføj voksenbillet (" + voksenPris + " kr)");
            System.out.println("3. Tilføj cykelbillet (" + cykelPris + " kr)");
            System.out.println("4. Fortsæt til betaling");
            System.out.println("\n                      pris: " + automat.getTilBetaling()); //Husk at tilføje andre billetters betalinger
            int valg = tastatur.nextInt();

            if (valg == 1) {
                //automat.setAntalBørnebilletter(automat.getAntalBørnebilletter()+1);
                automat.getBilletter().add(new Billet("Barn", børnePris));

            } else if (valg == 2) {
                automat.getBilletter().add(new Billet("Voksen", voksenPris));

            } else if (valg == 3) {
                automat.getBilletter().add(new Billet("Cykel", cykelPris));

            } else if (valg == 4) {
                
                break;
                
            }

        } while (true);

    }

    public void visMontørMenu(Scanner tastatur) {

        System.out.println("-----Montør tilstand-----");
        System.out.println("Tast 11 for at se status (montør)");
        System.out.println("Tast 12 for at nulstille (montør)");
        System.out.println("Tast 13 for at sætte billetpris (montør)");
        System.out.println("Tast 14 for at logge ud af montørtilstand");
        System.out.println("Tast 15 for at tømme automaten");
        System.out.println("Tast 16 for at vise Transaktioner");
        
        valg = tastatur.nextInt();
            tastatur.nextLine();
        
        if (valg == 11) {
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
            } else if (valg == 16) {
                automat.visLog();
            } 
                
            
    }

    
    
    
    
    public void visKundeMenu(Scanner tastatur) {

        System.out.println("-----------------------------------------------");
        System.out.println("En billet koster " + automat.getTilBetaling() + " kroner");
        System.out.println("Balancen er på " + automat.getBalance() + " kroner");
        System.out.println();
        System.out.println("Tast 1 for at indbetale penge");
        System.out.println("Tast 2 for at udskrive din billet");
        System.out.println("Tast 3 for at få returpengene");
        System.out.println("Tast 4 for at gå tilbage til hovedmenu");
        System.out.println("tast 5 for at afslutte");
        
        valg = tastatur.nextInt();
            tastatur.nextLine();

            if (valg == 1) {
                System.out.print("Skriv beløb: ");
                int beløb = tastatur.nextInt();
                automat.indsætPenge(beløb);
                visKundeMenu(tastatur);
            } else if (valg == 2) {
                automat.udskrivBillet();
                visKundeMenu(tastatur);
            } else if (valg == 3) {
                int beløb = automat.returpenge();
                System.out.println("Du fik " + beløb + " kr retur\nTak for dit køb, på gensyn\n\n");
                visStartMenu(tastatur);
            } else if (valg == 4) {
                BenytBilletautomat.valgt = false;
                automat.getBilletter().clear();
            } else if (valg == 5) {
                System.out.println("\n\nTak for at benytte vores billetautomat, programmet afsluttes.");
                System.exit(0);
            } else {
                System.out.println("Ugyldigt valg, prøv igen");
                visKundeMenu(tastatur);
                

            }

    }

}
