
import java.io.Serializable;


/**
 * Filen inneholder all nødvendig informasjon om Reiseforsikring
 * Hensikten med klassen er å opprette reise forsikring til kunden.
 * Siste edit: 19.05.15
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
    /*Lager ny reiseforsikring og sender med innformasjon om reise forsikringen 
    og sum til registeret.*/
}
