/**
 * Filen inneholder all nødvendig informasjon om Bilforsikring
 * Hensikten med klassen er å opprette de fleste get metodene for bilforsikring, som blir brukt i forsikring.
 * Siste edit: 19.05.15
 * @author Kristan
 */
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
        bonus=20;
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
    public void bonus(Kunde k)
    {   
        Kunde kunde=k;
        int dager =  24* 3600 * 1000;
        long år = 365;
        long opprettet;
        opprettet=this.getOpprettetlong();
        long dagensDato = (long) (new Date().getTime())/dager;
        int teller = 0;
        Skademelding[] s=k.getSkademeldinger();
        Skademelding siste=null;
        
        for (int i=0; i<s.length;i++)
        {
            if(s[i].getType()=="bil")// Sjekker om skademeldingstypen er en bil
            {
                
                
                  if(siste==null || s[i].getOpprettetlong()>siste.getOpprettetlong()){
                      siste=s[i];
                      // gjør sånn at kun den siste skademeldingen med type bil blir sjekket for å beregne bonusen
                  }
                
            }
        }
        
        
        
        long forskjell = dagensDato-opprettet;
        while(forskjell >= 0)
        {
            forskjell -= år;
            if(forskjell >= 0) // bonus skal øke med 10 for hvert år personen har hatt forsikringen
            {
                teller++;
                bonus+=10;
        
        if (teller >= 5 && bonus==70) // Øker bonusen hvis antall år er med eller like 5, og hvis bonusen er
        { // 70, for så og øke bonusen til 75, som er max
            bonus=75;
        }
        if(s.length==1 && bonus==75) // reduserer bonusen ved skade på bilen til 60, hvis personen har 75 i bonus fra førav
        {
            bonus=60;
        }
        else if(bonus<75 && s.length>0) //reduserer bonusen med 30, hvis kunden har en bonus under 75, og skademeldinger sin lenge er større en 0.
        {
            bonus-=30;
        }
            }
        }
        
    }
}
