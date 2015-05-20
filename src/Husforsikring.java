
/**
 * Filen inneholder all nødvendig informasjon om husforsikring
 * Hensikten med klassen er å opprette de fleste get metodene for husforsikring, som blir brukt i forsikring.
 * Siste edit: 19.05.15
 * @author Julian
 */
public class Husforsikring extends Forsikring {
    
   
    private String adresse;
    private int byggeår;
    private String boligtype;
    private String byggmaterial;
    private String standard;
    private int kvadratmeter;
    private int byggebeløp;
    private int innbobeløp;
    public static final String type="hus";
    
    public Husforsikring(String a, int b, String t, String m, int k, String sta, int bygg, int premie, int beløp, String beskrivelse )
    {
        super(premie,beløp,beskrivelse,type);
        adresse=a;
        byggeår=b;
        boligtype=t;
        byggmaterial=m;
        standard=sta;
        byggebeløp=bygg;
        kvadratmeter=k;
       
        
    }
    //Get metoder.
    public String getAdresse()
    {
        return adresse;
    }
    public int getByggeår()
    {
        return byggeår;
    }
    public String getBoligtype()
    {
        return boligtype;
    }
    public String getByggmaterial()
    {
        return byggmaterial;
    }
    public String getStandard()
    {
        return standard;
    }
    public int getKvadratmeter()
    {
        return kvadratmeter;
    }
    public int getByggebeløp()
    {
        return byggebeløp;
    }
    public int getInnbobeløp()
    {
        return innbobeløp;
    }
}
