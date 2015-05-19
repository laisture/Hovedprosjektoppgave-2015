//Dette er klassen for båtforsikring. i denne klassen lagres all nødvendig info om bilforsikringen.
// Dette er en subklasse av klassen Forsikring, og består for det meste av get metoder.


public class Båtforsikring extends Forsikring
     {
    private String navn;
    private String reginr;
    private String modell;
    private int lengde;
    private int årsmodell;
    private String motor;
    private int motorstyrke;
    
    
    public Båtforsikring(String n, String reg, String m, int l, int år, String moto, int motorsty, int premie, int beløp, String beskrivelse )
    {
        super(premie,beløp,beskrivelse,"båt");
        navn = n;
        reginr = reg;
        modell = m;
        lengde = l;
        årsmodell = år;
        motor = moto;
        motorstyrke = motorsty;
    }
    
    public String getNavn()
    {
        return navn;
    }
    public String getReginr()
    {
       return reginr; 
    }
    public String getModell()
    {
        return modell;
    }
    public int getLengde()
    {
        return lengde;
    }
    public int getÅrsmodell()
    {
        return årsmodell;
    }
    public String getMotor()
    {
        return motor;
    }
    public int getMotorstyrke()
    {
        return motorstyrke;
    }
}
