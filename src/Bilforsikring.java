//Dette er klassen for bilforsikring. i denne klassen lagres all nødvendig info om bilforsikringen.
//her lagres også metode for å regne ut bonusordningen. Dette er en subklasse av klassen Forsikring.

import java.util.Date;
import java.text.SimpleDateFormat;

public class Bilforsikring extends Forsikring {
    private String navn;
    private String reginr;
    private String biltype;
    private String modell;
    private int regiår;
    private int kjørelengde;
    private int kilometer;
    private int bonus;
    public static final String type="bil";
    
    
    public Bilforsikring(String n, String reg,String t, String m, int år, int lengde, int k, int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse,type);
        navn=n;
        reginr=reg;
        biltype=t;
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
    public String getModell()
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
    // Metoden har som oppgave å regne ut bonus hos forsikringskunden. Maks bonus er 75 prosentpoeng.
    // Comment: Må kunne lagre opparbeidet bonus en plass?
//    public void bonus(Kunde k)
//    {   
//        Kunde kunde=k;
//        int dager =  24* 3600 * 1000;
//        long år = 365; 
//        long opprettet = Skademelding.getOpprettetlang()/dager;
//        long dagensDato = (long) (new Date().getTime())/dager;
//        int teller = 0;
//        Skademelding[] s=k.getSkademeldinger();
//        Skademelding siste=null;
//        
//        for (int i=0; i<s.length;i++)
//        {
//            if(s[i].getType()=="bil")
//            {
//                if (siste==null || opprettet>siste)
//                {
//                  siste=s[i];
//                }
//            }
//        }
//        
//        if (opprettet == dagensDato )
//        {
//            bonus+=20;
//        }
//        
//        long forskjell = dagensDato-opprettet;
//        while(forskjell >= 0)
//        {
//            forskjell -= år;
//            if(forskjell >= 0) // bonus skal øke med 10 for hvert år personen har hatt forsikringen
//            {
//                teller++;
//                bonus+=10;
//            }
//        }
//        if (teller >= 5 && bonus==70) // Øker bonusen hvis antall år 
//        {
//            bonus=75;
//        }
//        else
//        {
//           bonus=70;
//        }
//        if(s.length>0 && bonus==75 && teller<6) 
//        {
//            bonus=60;
//        }
//        else if(bonus<75 & s.length>0)
//        {
//            bonus-=30;
//        }
//        
//    }
}
