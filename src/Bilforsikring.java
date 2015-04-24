/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
import java.util.Calendar;
import java.util.Date;

public class Bilforsikring extends Forsikring {
    private String navn;
    private String reginr;
    private String biltype;
    private int modell;
    private int regiår;
    private int kjørelengde;
    private int kilometer;
    private int bonus;
    
    public Bilforsikring(String n, String reg,String type, int m, int år, int lengde, int k, int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse);
        navn=n;
        reginr=reg;
        biltype=type;
        modell=m;
        regiår=år;
        kjørelengde=lengde;
        kilometer=k;
    }
    
    public String getNavn()
    {
        return navn;
    }
    public String getReginr()
    {
        return reginr;
    }
    public String getBiltype()
    {
        return biltype;
    }
    public int getModell()
    {
        return modell;
    }
    public int getRegiår()
    {
        return regiår;
    }
    public int getKjørelengde()
    {
        return kjørelengde;
    }
    public int getKilometer()
    {
        return kilometer;
    }
    public int getBonus()
    {
        return bonus;
    }
    /*
    Metoden har som oppgave å regne ut bonus hos forsikringskunden.
    
    */
    public void bonus()
    {   
        int dager =  24* 3600 * 1000;
        long år = 365; 
        long opprettet = super.getOpprettetlong()/dager;
        long dagensDato = (long) (new Date().getTime())/dager;
        int teller = 0;
        long forskjell = dagensDato-opprettet;
        while(forskjell >= 0)
        {
            forskjell -= år;
            if(forskjell >= 0)
                teller++;
        }
        bonus = teller * 5;
        if(bonus > 75)
        {
            bonus = 75;
        }
    }
}
