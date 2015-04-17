

public class Kunde {
    //diverse variabler med infoen som lagres på kunden:
    
    private String fornavn;
    private String etternavn;
    private String fakturaadresse;
    private int forsikringsnummer;
    private int premie;
    private Skademelding[] skademeldinger;
    private int nestenummer;
    private Forsikring[] forsikringer =new Forsikring[20];
    private Boolean totalkunde;
   
    //Konstruktør
    public Kunde(String f,String e, String a)
    {
        fornavn=f;
        etternavn=e;
        fakturaadresse=a;
        
        // <opprettingsdato>
    }
    public void addForsikring(Forsikring f)
    {
        for(int i =0; i<forsikringer.length;i++)
        {
            if (forsikringer[i]==null)
            {
                forsikringer[i]=f;
                return;
            }
        }
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
    public Forsikring[] getForsikringer()
    {
        return forsikringer;
    }
    public String toString()
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding += fakturaadresse+"\n\n";
        for (int i=0; i<forsikringer.length;i++)
        {
            if(forsikringer[i]!=null)
            {
                melding+=forsikringer[i].toString();
            }
        }
        return melding;
    }
    
    
    
    
}
