package automat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {

    private int børneBilletPris;    // Prisen for én børnebillet.
    private int voksenBilletPris;    // Prisen for én voksenbillet.
    private int tilBetaling;
    private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBørneBilletterSolgt; // Antal billetter automaten i alt har solgt
    private int antalVoksenBilletterSolgt; // Antal billetter automaten i alt har solgt
    public static boolean montørtilstand;
    private int indkomst;
    private ArrayList<Transaktion> transaktioner;
    private BilletautomatMenuer menu = new BilletautomatMenuer(this);
    private ArrayList<Billet> billetter = new ArrayList<Billet>();

    /**
     * Opret en billetautomat der sælger billetter til 10 kr.
     */
    public Billetautomat() {
        børneBilletPris = 12;
        voksenBilletPris = 24;
        balance = 0;
        transaktioner = new ArrayList<Transaktion>();

    }

    public ArrayList<Billet> getBilletter() {
        return billetter;
    }

    public void setBilletter(ArrayList<Billet> billetter) {
        this.billetter = billetter;
    }

    
    
    
    public int getBørneBilletPris() {

        return børneBilletPris;

    }

    public void setBørneBilletPris(int børneBilletPris) {
        this.børneBilletPris = børneBilletPris;
    }

    public int getVoksenBilletPris() {
        return voksenBilletPris;
    }

    /**
     * Giver prisen for en billet.
     */
    public void setVoksenBilletPris(int voksenBilletPris) {
        this.voksenBilletPris = voksenBilletPris;
    }

    public int getTilBetaling() {
        
        this.tilBetaling = 0;
        for (int i = 0; i < billetter.size(); i++) {
            
            this.tilBetaling +=  billetter.get(i).getPris();
            
        }
        
        return this.tilBetaling;
    }

    public void setTilBetaling(int nyTilBetaling) {

        this.tilBetaling = nyTilBetaling;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */
    public void indsætPenge(int beløb) {

        transaktioner.add(new Transaktion("Penge indsat: " + beløb + " kr"));
        balance = balance + beløb;
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     */
    public void udskrivBillet() {
        if (balance < tilBetaling) {
            System.out.println("Du mangler at indbetale nogle penge");
        } else if (balance >= tilBetaling) {
            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + tilBetaling + " kr.       #");
            System.out.println("#                     #");
            System.out.println("##########B##T#########");
            System.out.println("#Du har " + (balance - tilBetaling) + " kr til gode#");
            System.out.println("##########B##T#########");
            System.out.println();

            if (tilBetaling == 12) {
                antalBørneBilletterSolgt += 1;
            } else if (tilBetaling == 24) {
                antalVoksenBilletterSolgt += 1;
            }

            balance = balance - tilBetaling; // Billetter koster 10 kroner

            transaktioner.add(new Transaktion("Billet udskrevet"));
        }
    }

    public int returpenge() {
        int returbeløb = balance;
        balance = 0;
        System.out.println("Du får " + returbeløb + " kr retur");
        transaktioner.add(new Transaktion("Penge returneret: " + returbeløb + " kr"));
        return returbeløb;

    }

    public void montørLogin(String adgangskode) {

        if ("1234".equals(adgangskode)) {
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
        } else {
            montørtilstand = false;
            System.out.println("Montørtilstand deaktiveret");
        }

        transaktioner.add(new Transaktion("Montøren logget ind"));

    }

    public int getIndkomst() {
        if (montørtilstand) {

            this.indkomst = ((børneBilletPris * antalBørneBilletterSolgt) + (voksenBilletPris * antalVoksenBilletterSolgt));

            return indkomst;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    public int getAntalBilletterSolgt() {
        if (montørtilstand) {
            return antalBørneBilletterSolgt + antalVoksenBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    public void definerBilletPriser(int nyBørneBilletPris, int nyVoksenBilletPris) {
        if (montørtilstand) {
            this.børneBilletPris = nyBørneBilletPris;
            this.voksenBilletPris = nyVoksenBilletPris;
            System.out.println("Priserne er ændret til: "+ nyBørneBilletPris + "kr for børnebillet og " +nyVoksenBilletPris+"kr for voksen billet");
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    public void nulstil() {
        if (montørtilstand) {
            antalVoksenBilletterSolgt = 0;
            antalBørneBilletterSolgt = 0;
            System.out.println("Nulstilles.. vent venligst!"
                    + " \nFuldført");
            transaktioner.add(new Transaktion("System nulstillet"));

        } else {
            System.out.println("Afvist - log ind først");
            transaktioner.add(new Transaktion("Log ind afvist"));
        }
    }

    public void setAntalBilletterSolgt(int antalBørneBilletterSolgt, int antalVoksenBilletterSolgt) {
        if (montørtilstand) {
            this.antalBørneBilletterSolgt = antalBørneBilletterSolgt;
            this.antalVoksenBilletterSolgt = antalVoksenBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    public void visLog() {
        if (montørtilstand) {
            Date dato = new Date();
            System.out.println("\n======= Transaktioner pr. " + dato.toString() + "=======");

            for (int i = 0; i < transaktioner.size(); i++) {
                System.out.println(transaktioner.get(i));

            }
            
            System.out.println("=============================================================\n");
        }

    }

    public void tømAutomat() {
        if (montørtilstand) {
            System.out.println("Automaten tømmes. " + getIndkomst() + " kr. kommer ud");
            indkomst = 0;
            transaktioner.add(new Transaktion("Automaten blev tømt"));
        } else {
            System.out.println("Afvist - log ind først");
            transaktioner.add(new Transaktion("Log ind afvist"));
        }
    }

    public boolean erMontør() {
        return montørtilstand;
    }

    public ArrayList<Transaktion> getTransaktion() {

        return this.transaktioner;

    }

    public void setTransaktion(ArrayList Transaktioner) {

        this.transaktioner = Transaktioner;

    }

    public BilletautomatMenuer getMenu() {
        return menu;
    }

    public void setMenu(BilletautomatMenuer menu) {
        this.menu = menu;
    }

}
