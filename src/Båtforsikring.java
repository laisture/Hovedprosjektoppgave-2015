/**
 * Filen inneholder all nødvendig informasjon om båtforsikring.
 * Hensikten med klassen er å opprette de fleste get metodene for båtforsikring, som blir brukt i forsikring.
 * Siste edit: 19.05.15
 * @author Joakim
 */

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
    //Get moetoder
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
