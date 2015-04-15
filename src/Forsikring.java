/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Joakim
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Forsikring {

    private int årligPremie;
    private String opprettet;
    private int forsikringsbeløp;
    private String betingelser;
    
    
    public Forsikring(int p, int beløp, String b)
    {
        årligPremie=p;
        forsikringsbeløp= beløp;
        betingelser= b;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Calendar cal = Calendar.getInstance();
       opprettet= dateFormat.format(cal.getTime());

        // <opprettingsdato>
    }
    
    public int getPremie()
    {
        return årligPremie;
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
            
}
