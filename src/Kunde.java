

public class Kunde {
    //diverse variabler med infoen som lagres på kunden:
    
    private String fornavn;
    private String etternavn;
    private String fakturaadresse;
    private int forsikringsnummer;
    private int premie;
    private Skademelding[] skademeldinger;
    private int nestenummer;
    private Forsikring[] forsikringer;
   
    //Konstruktør
    public Kunde(String f,String e, String a)
    {
        fornavn=f;
        etternavn=e;
        fakturaadresse=a;
        
        // <opprettingsdato>
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
    public Skademmelding[] getSkademeldinger()
    {
        return skademeldinger;
    }
    public Forsikring[] getForsikringer()
    {
        return forsikringer;
    }
    
    
    
    
}
