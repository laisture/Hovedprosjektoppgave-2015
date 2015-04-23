
import java.util.ArrayList;
import java.util.ListIterator;



public class Kunde {
    //diverse variabler med infoen som lagres på kunden:
    
    private String fornavn;
    private String etternavn;
    private String fakturaadresse;
    private int forsikringsnummer;
    private int premie;
    private Skademelding[] skademeldinger;
    private int nestenummer;
    private ArrayList <Forsikring> forsikringer;
    private Boolean totalkunde;
   
    //Konstruktør
    public Kunde(String f,String e, String a)
    {
        fornavn=f;
        etternavn=e;
        fakturaadresse=a;
        forsikringer = new ArrayList();
        
        // <opprettingsdato>
    }
    /*
    Metoden legger til forsikringsobject i kunden sin forsikringsliste.
    
    */
    public void addForsikring(Forsikring f)
    {
        forsikringer.add(f);
    }
    //Get metoder:
    public String getNavn()
    {
        return (fornavn+ " "+ etternavn);
    }
    public String getFornavn()
    {
         return (fornavn);
    }
    public String getEtternavn()
    {
        return (etternavn);
    }
    public int getForsikringsnummer()
    {
        return(forsikringsnummer);
    }
    public Skademelding[] getSkademeldinger()
    {
        return skademeldinger;
    }
    public ArrayList getForsikringer()
    {
        return forsikringer;
    }
    public Boolean totalKunde()
    {
        
        ArrayList <Forsikring> f = new ArrayList<>();
        /* Går gjennom forsikringlisten og lagrer de forskjellige forsikringene i en lokal variabel.
           Hvis tre forskjellige forsikringer blir funnet i listen returner den true, hvis ikke false.*/
        
	for(Forsikring i : forsikringer)
        {
            boolean inneholder = false;
            for(Forsikring j : f)
            {
                if(j.getClass().equals(i.getClass()))
                {
                    inneholder = true;
                    break;
                }
            }
            if(!inneholder)
                f.add(i);
	}
	return f.size() >= 3;
        /*
        String en="";
        String to="";
        String l="";
        for (int i=0; i<forsikringer.length;i++)
        {
            
        l=forsikringer[i].getClass()+"";
            
        if(en=="")
            {
                en=l;
                System.out.println(en);
                
            }
            else if (!l.equals(en) && to=="")
            {
                to=l;
                System.out.println(to);
                        
            }
            else if (!l.equals(en) && !l.equals(to))
            {
                totalkunde=true;
                return true;
            }
        }*/
        
    }
    public String toString()
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding += fakturaadresse+"\n\nForsikringer:\n";
        ListIterator<Forsikring> iterator = forsikringer.listIterator();
        
        while(iterator.hasNext())
        {
            melding += iterator.next().toString() + "\n";
        }
        
        return melding;
    }
    
    
    
    
}