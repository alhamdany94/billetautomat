/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;


/*Skabelon til at lave klasser, som du vil bruge som objekter i andre klasser.
1. Tænk over hvilket attributer/egenskaber dit objekt skal besidde - f.eks. en person (objekt/klassen) har en højde, vægt, hudfarve osv. (variabler)
2. Lav en konstruktør - højreklik - insert code - constructor
3. Når du har klaret ovenstående steps, skal du lave getters og setters, så dine variable fra step 1, 
kan hentes og ses fra andre klasser. - højreklik - insert code - getters and setters - vælg alle variable
4. Tænk over hvad dit objekt skal kunne - f.eks. en person skal kunne gå, hoppe, sove, sidde osv. (metoder).
*/
public class Billet {
    
    private String billettype;
    private int pris;

    public Billet(String billettype, int pris) {
        this.billettype = billettype;
        this.pris = pris;
        
    }

    public String getBillettype() {
        return billettype;
    }

    public void setBillettype(String billettype) {
        this.billettype = billettype;
    }

    

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
    
}


