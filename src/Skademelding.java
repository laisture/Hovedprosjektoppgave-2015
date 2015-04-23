/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
public class Skademelding {
    
    private Kunde kunde;
    private String melding;
    private String dato;
    private String type;
    private String vitne;
    private int takst;
    
    public Skademelding(Kunde k, String s, String t)
    {
        kunde=k;
        melding=s;
        type=t;
    }
    
   /* public Boolean harForsikring()
    {
        //<Metode for å sjekke om kunden har riktig forsikring>
    }
    */
    
}
