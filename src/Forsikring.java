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

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Forsikring implements Serializable {

    private int årligPremie;
    private String opprettet; //Dato foroppretelse av avtale.
    private long opprettetlong; //Dato oppgitt i milisekunder etter 1.1.1970
    private int forsikringsbeløp;
    private String betingelser;
    private Boolean gyldig;
    
    public Forsikring(int p, int beløp, String b)
    {
        årligPremie=p;
        forsikringsbeløp= beløp;
        betingelser= b;
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date cal = new Date();
        opprettet= dateFormat.format(cal.getTime());
        opprettetlong = (long) (cal.getTime());
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
    public long getOpprettetlong()
    {
        return opprettetlong;
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
