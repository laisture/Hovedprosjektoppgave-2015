
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private String datoopprettet;
    
    public Skademelding(Kunde k, String s, String t,String v)
    {
        kunde=k;
        melding=s;
        type=t;
        vitne=v;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date cal = new Date();
        datoopprettet= dateFormat.format(cal.getTime());
        
    }
    
    public int getTakst()
    {
        return takst;
    }
    public String getType()
    {
        return type;
    }
    public String getDato()
    {
        return datoopprettet;
    }
    public Boolean harForsikring()
    {
       ArrayList f=kunde.getForsikringer();
       String forsikringKlasse="class "+type;
       String klasse;
       for(Object i : f)
        {
            klasse=i.getClass()+"";
                if(klasse.equals(forsikringKlasse))
                {
                    return true;
                    
                }
        }
       return false;
            
       
    }
}
