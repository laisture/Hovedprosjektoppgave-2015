//Dette er klassen for fritidsboligforsikring. i denne klassen lagres all nødvendig info om bilforsikringen.
// Dette er en subklasse av klassen Forsikring, og består for det meste av get metoder.

public class Fritidsforsikring extends Forsikring {
    
    private String fritidsadresse;
    private int byggeår;
    private String boligtype;
    private String byggmate;
    private String standard;
    private int kvadratm;
    //beløp for:
    private int byggbeløp;
    private int innbo;
    public static final String type="fritid";
    private boolean utleie;
    
    public Fritidsforsikring(String a, int b, String t, String m, String sta,int k, int bygg,int inb,Boolean u, int premie, int beløp, String beskrivelse )
    {
        super(premie,beløp,beskrivelse,type);
        fritidsadresse=a;
        byggeår=b;
        boligtype=t;
        byggmate=m;
        standard=sta;
        kvadratm=k;
        byggbeløp=bygg;
        innbo = inb;
        utleie=u;
        
    }
    // Get metoder.
    public String getFritidsadresse()
    {
        return fritidsadresse;
    }
    public int getByggeår()
    {
        return byggeår;
    }
    public String getBoligtype()
    {
        return boligtype;
    }
    public String getByggmater()
    {
        return byggmate;
    }
    public String getStandard()
    {
        return standard;
    }
    public int getKvaderatm()
    {
        return kvadratm;
    }
    public int getBygging()
    {
        return byggbeløp;
    }
}
