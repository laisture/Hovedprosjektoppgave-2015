/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Joakim
 */

//import setninger:

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Forsikring {

    private int årligPremie;
    private String opprettet;
    private int forsikringsbeløp;
    private String betingelser;
    private Boolean gyldig;
    
    public Forsikring(int p, int beløp, String b)
    {
        årligPremie=p;
        forsikringsbeløp= beløp;
        betingelser= b;
        
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
       opprettet= dateFormat.format(cal.getTime());
        
       gyldig=true;
       
        // <opprettingsdato>
    }
    
    public int getPremie()
    {
        return årligPremie;
    }
    public Boolean getGyldig()
    {
        return gyldig;
    }
    public int getBeløp()
    {
        return forsikringsbeløp;
    }
    public String getDato()
    {
        return opprettet;
    }
    public String getBetingelser()
    {
        return betingelser;
    }
    public void setGyldig(Boolean b)
    {
        gyldig=b;
    }
    public String toString()
    {
         String melding;
        melding="Forsikring opprettet: "+opprettet+"\n";
        melding+="Årlig premie: "+årligPremie+"\n";
        melding+= "Forsikringsbeløp: "+forsikringsbeløp+"\n";
        melding+="Betingelser:"+"\n"+betingelser+"\n\n";
        
        return melding;
    }
            
}
