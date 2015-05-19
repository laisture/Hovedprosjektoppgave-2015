// Gjør nødvendige import setninger:
import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Filen inneholder all nødvendig informasjon om Forsikring
 * Hensikten med klassen er å opprette reise de fleste get metodene for forsikring
 * Siste edit: 19.05.15
 * @author Joakim
 */
public class Forsikring implements Serializable {

    private int årligPremie;
    private String opprettet; //Dato for oppretelse av avtale.
    private long opprettetlong; //Dato oppgitt i milisekunder etter 1.1.1970
    private int forsikringsbeløp;
    private String betingelser;
    private Boolean gyldig;
    private String type;
    
    public Forsikring(int p, int beløp, String b,String t)
    {
        årligPremie=p;
        forsikringsbeløp= beløp;
        betingelser= b;
        type=t;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date cal = new Date();
        opprettet= dateFormat.format(cal.getTime());
        opprettetlong = (long) (cal.getTime());
        gyldig=true;
       
        // Get metoder.
    }
    public int getPremie()
    {
        return årligPremie;
    }
    public Boolean getGyldig()
    {
        return gyldig;
    }
    public int getBeløp()
    {
        return forsikringsbeløp;
    }
    public String getDato()
    {
        return opprettet;
    }
    public long getOpprettetlong()
    {
        return opprettetlong;
    }
    public String getBetingelser()
    {
        return betingelser;
    }
    public String getType()
    {
        return type;
    }
    public void setGyldig(Boolean b)
    {
        gyldig=b;
    }
    public String toString()
    {//Tostring metode for å skrive ut melding om Forsikringen.
        String melding;
        melding="Forsikring opprettet: "+opprettet+"\n";
        melding+="Årlig premie: "+årligPremie+"\n";
        melding+="Forsikringsbeløp: "+forsikringsbeløp+"\n";
        melding+="Betingelser:"+"\n"+betingelser+"\n\n";
        if(gyldig)//Sjekker om forsikringen er gyldig eller ugyldig.
        {
            melding+= "Forsikringen er aktiv.\n";
        }
        else
        {
            melding+="Forsikringen er IKKE aktiv.\n";
        }
        return melding;
    }
            
}
