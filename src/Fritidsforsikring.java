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
    private int bygging;
    private int innbo;
    
    private boolean utleie;
    
    public Fritidsforsikring(String a, int b, String t, String m, int k, String sta, int bygg, int i,Boolean u, int premie, int beløp, String beskrivelse )
    {
        super(premie,beløp,beskrivelse);
        fritidsadresse=a;
        byggeår=b;
        boligtype=t;
        byggmate=m;
        standard=sta;
        bygging=bygg;
        kvadratm=k;
        innbo=i;
        utleie=u;
        
    }
    
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
        return bygging;
    }
    public int getInnbo()
    {
        return innbo;
    }
}
