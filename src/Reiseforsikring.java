
import java.io.Serializable;


/**
 *
 * @author Joakim
 */
public class Reiseforsikring extends Forsikring implements Serializable 
{
    
    private String område;
    private int sum;
    
    public Reiseforsikring(String o, int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse);
        område=o;
    }
    
    public String toString()
    {
        String melding=super.toString();
        melding +="område for reiseforsikring: "+område+"\n";
        if(sum>0)
        {
            melding+="sum utbetalt: "+sum+"\n";
        }
        return melding;
    }
}
