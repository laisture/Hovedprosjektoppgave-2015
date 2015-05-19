
import java.io.Serializable;


/**
 * Filen inneholder 
 * Hensikten med klassen er å opprette reise
 * @author Joakim
 */
public class Reiseforsikring extends Forsikring implements Serializable 
{
    
    private String område;
    public static String type="reise";
    
    public Reiseforsikring(String o,int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse,type);
        område=o;
    }
    
    public String toString()
    {
        String melding=super.toString();
        melding +="område for reiseforsikring: "+område+"\n";
        if(getBeløp()>0)
        {
            melding+="sum utbetalt: "+getBeløp()+"\n";
        }
        return melding;
    }
    //Lager ny reiseforsikring og sender med innformasjon om forsikringen til registeret.
}
