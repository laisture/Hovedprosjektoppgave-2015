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
    private int forsikringbeløp;
    private String betingelser;
    
    
    public Forsikring()
    {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Calendar cal = Calendar.getInstance();
       opprettet= dateFormat.format(cal.getTime());

        // <opprettingsdato>
    }
    public void utDato()
    {
        System.out.println(opprettet);
    }
    
}
