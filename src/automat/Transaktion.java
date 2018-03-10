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


public class Transaktion {
    
    private String tidspunkt;
    private String handling;
    private int beløb;
    private Date dato;
    
    public Transaktion(String handling){
        
        this.dato = new Date();
        this.tidspunkt = dato.toString();
        this.handling = handling;
        
    
    }
    
    
}
