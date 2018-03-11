/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.util.Date;

/**
 *
 * @author hamza
 */

/*
Skabelon til at lave klasser, som du vil bruge som objekter i andre klasser.
1. Tænk over hvilket attributer/egenskaber dit objekt skal besidde - f.eks. en person (objekt/klassen) har en højde, vægt, hudfarve osv. (variabler)
2. Lav en konstruktør - højreklik - insert code - constructor
3. Når du har klaret ovenstående steps, skal du lave getters og setters, så dine variable fra step 1, 
kan hentes og ses fra andre klasser. - højreklik - insert code - getters and setters - vælg alle variable
4. Tænk over hvad dit objekt skal kunne - f.eks. en person skal kunne gå, hoppe, sove, sidde osv. (metoder).
*/
public class Transaktion {

    
    
    private String tidspunkt;
    private String handling;
    private Date dato;

    

    public Transaktion(String handling) {

        this.dato = new Date();
        this.tidspunkt = dato.toString();
        this.handling = handling;
        

    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }
    
    
    
    public String toString(){
        
        return dato+" - "+ handling;
        
    }
    
    

}
