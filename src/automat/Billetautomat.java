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
    private ArrayList<Transaktion> Transaktioner;
    /**
     * Opret en billetautomat der sælger billetter til 10 kr.
     */
    public Billetautomat() {
        børneBilletPris = 12;
        voksenBilletPris = 24;
        balance = 0;
        Transaktioner = new ArrayList<Transaktion>();
      
    }

    /**
     * Giver prisen for en billet.
     */
    public int getBørneBilletPris() {

        return this.børneBilletPris;
    }

    public int getVoksenBilletPris() {

        return this.voksenBilletPris;
    }

    public void setBørneBilletPris(int nyBørnBilletPris) {

        this.børneBilletPris = nyBørnBilletPris;

    }

    public void setVoksenBilletPris(int nyVoksenBilletPris) {

        this.voksenBilletPris = nyVoksenBilletPris;

    }

    public int getTilBetaling() {

        return this.tilBetaling;

    }

    public void setTilBetaling(int nyTilBetaling) {

        this.tilBetaling = nyTilBetaling;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */
    public void indsætPenge(int beløb) {
        
        Transaktioner.add(new Transaktion("Penge indsat"));
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
        if (balance < 10) {
            System.out.println("Du mangler at indbetale nogle penge");
        } else if (balance >= 10) {
            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + tilBetaling + " kr.       #");
            System.out.println("#                     #");
            System.out.println("##########B##T#########");
            System.out.println("# Du har " + (balance - tilBetaling) + " kr til gode       #");
            System.out.println("##########B##T#########");
            System.out.println();

            if (tilBetaling == 12) {
                antalBørneBilletterSolgt += 1;
            } else if (tilBetaling == 24) {
                antalVoksenBilletterSolgt += 1;
            }

            balance = balance - tilBetaling; // Billetter koster 10 kroner
        }
    }

    public int returpenge() {
        int returbeløb = balance;
        balance = 0;
        System.out.println("Du får " + returbeløb + " kr retur");
        return returbeløb;
    }

    public void montørLogin(String adgangskode) {

        if ("1234".equals(adgangskode)) {
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
            System.out.println("Du kan nu angive billetpris");
        } else {
            montørtilstand = false;
            System.out.println("Montørtilstand deaktiveret");
        }
        
        
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

        } else {
            System.out.println("Afvist - log ind først");
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

    public void VisTransaktion() {
        if (montørtilstand) {
            
            System.out.println(Transaktioner);
        }
        

    }

    public void tømAutomat() {
        if (montørtilstand) {
            System.out.println("Automaten tømmes. " + getIndkomst() + " kr. kommer ud");
            indkomst = 0;
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    public boolean erMontør() {
        return montørtilstand;
    }

    public ArrayList<Transaktion> getTransaktion() {

        return this.Transaktioner;

    }
    public ArrayList<Transaktion> setTransaktion(ArrayList Transaktioner) {

        this.Transaktioner =  Transaktioner;
        return null;
    }
}