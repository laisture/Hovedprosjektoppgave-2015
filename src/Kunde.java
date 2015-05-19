
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;



public class Kunde implements Serializable {
    //diverse variabler med infoen som lagres på kunden:
    
    private String fornavn;
    private String etternavn;
    private String fakturaadresse;
    private int forsikringsnummer;
    private int premie;
    private Skademelding[] skademeldinger;
    private static int nestenummer = 1;
    private ArrayList <Forsikring> forsikringer;
    private Boolean totalkunde;
    private Boolean aktiv;
    //Konstruktør
    public Kunde(String f,String e, String a)
    {
        forsikringsnummer=nestenummer++;
        fornavn=f;
        etternavn=e;
        fakturaadresse=a;
        forsikringer = new ArrayList();
        aktiv=true;
        skademeldinger=new Skademelding[100];
    }
    //Metoden legger til forsikringsobjekt i kunden sin forsikringsliste.
    public Boolean addForsikring(Forsikring f)
    {
        forsikringer.add(f);
        oppdaterKunde(); // La til metode for å oppdatere kunden hvis forsikringene får endring
        return true;
    }
    //Metoden legger til ny skademelding til kunden
    public boolean addSkademelding(Kunde k, String m, String t, String v)
    {
        Skademelding s=new Skademelding(k,m,t,v);
        for (int i =0;i<skademeldinger.length;i++)
        {
            if(skademeldinger[i]==null)//Hvis skademeldingens indeks ikke er null, skal det legges til en ny skademelding.
            {
                skademeldinger[i]=s;
                return true;
                
            }
        }
        return false;
    }
    //Get og set metoder.
    public void setNestenummer(int i)
    {
        nestenummer=i;
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

    public int getPremie()
    {
        return premie;
    }
    //Henter antall skader fra skademeldinger.
    public int getAntallSkader()
    {
        int n=0;
        for (int i=0;i<skademeldinger.length;i++)
        {
            if(skademeldinger[i]!=null)
            {
                n++;
            }
        }
        return n;
    }
    //Get og andre metoder.
    public int getForsikringsnummer()
    {
        return(forsikringsnummer);
    }
    public Skademelding[] getSkademeldinger()
    {
        return skademeldinger;
    }
    public ArrayList getForsikringer()
    {
        return forsikringer;
    }
    public void ikkeAktiv()
    {
        aktiv=false;
    }
    public void Aktiv()
    {
        aktiv=true;
    }
    public Boolean getAktiv()
    {
        return aktiv;
    }
    public Boolean getTotalKunde()
    {
        return totalkunde;
    }
    //Metoden finner skademeldingsnummeret fra skademeldinger
    public int finnSkademeldingsplasering(int t)
    {
        for (int i=0; i<skademeldinger.length;i++)
        {
            if (skademeldinger[i].getSkadenummer()==t)
            {
                return (i);
            }
        }
        return -1;
    }
    public void setSkademelding(Skademelding s)
    {
        int i=finnSkademeldingsplasering(s.getSkadenummer());
        skademeldinger[i]=s;
    }
    //La til ny metode, brukes til å oppdatere om kunden er totalkunde hvis endring av forsikringer skjer. SLETT SENERE
    public void oppdaterKunde()
    {
        totalKunde(); // NY! Nå oppdateres totalkunde for Hver gang programmet legger til forsikring. SLETT Senere
        årligPremie(); //NY Må kalles på hver gang en forsikring blir lagt til . SLETT SENERE.
    }
    // Metoden går gjennom skaderegister på kunden og legger sammen totalbeløpet for de utbetalte erstatningene.
    // Fungerer ikke helt ennå.  Må sjekke om erstatning er skrevet ut.
    public int utbetalteErstatninger()//Henter utbetalte erstatninger hvis skademeldinger sin indeks er ulik null. og sender med utbetalt beløp.
    {
        int utbetalteErstatninger = 0;
        
        for(int i = 0; i < skademeldinger.length; i++)
        {
            if(skademeldinger[i]!=null)
            {
                utbetalteErstatninger += skademeldinger[i].getTakst();
            }
        }
        return utbetalteErstatninger;
    
    }
    public int Erstatning(String s)//Sjekker om kunden har skademeldinger, for så å regne ut erstatnings beløp.
    {
        int sum=0;
        
        for(int i = 0; i < skademeldinger.length; i++)
        {
            
            if(skademeldinger[i]!=null && skademeldinger[i].getType().trim().equals(s))
            {
                sum += skademeldinger[i].getTakst();
            }
        }
        return sum;
    }

    public void årligPremie()
    {
       premie = 0;
      for(Forsikring f : forsikringer)
       {
           if(f.getGyldig()) // NY La til if test for å sjekke om forsikren er aktiv eller ikke. SLETT SENERE
            premie += (f.getPremie());
       }
       if(totalkunde)
           premie *= 0.9;
    }
    /* Metoden har som oppgave å finne ut om kunden har minst 3 forskjellige forsikringer.
    Hvis dette er tilfellet er kunden en totalkunde og får 10 rabatt på forsikringspremien sin, metoden returner da true, hvis ikke false.*/
    public Boolean totalKunde()
    {
        
        ArrayList <Forsikring> f = new ArrayList<>();
        /* Går gjennom forsikringlisten som ligger i datafeltet og sammenligner med en lokal liste som finner unike forsikringstyper.
        Hvis unik forsikringstype blir funnet blir den lagret i den lokale variabelen, hvis 3 forskjellige forsikringstyper er funnet.
        returnerer den true, hvis ikke false*/
        
	for(Forsikring i : forsikringer)
        {
            boolean inneholder = false;
            for(Forsikring j : f)
            {
                if(j.getClass().equals(i.getClass()) || !i.getGyldig())
                {
                    inneholder = true;
                    break;
                }
            }
            if(!inneholder)
                f.add(i);
            if(f.size() >= 3)
            {
                totalkunde = true;
                return true;
            }
	}
        totalkunde = false;
	return false; 
    }
    public String toString()//Tostring metode som legger til kundens personlige opplysninger i melding.
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding+=forsikringsnummer+"\n\n";
        melding += fakturaadresse+"\n\nForsikringer:\n";
        ListIterator<Forsikring> iterator = forsikringer.listIterator();
        
        while(iterator.hasNext())
        {
            melding += iterator.next().toString() + "\n";
        }
        for (int i =0;i<skademeldinger.length;i++)
        {
            if(skademeldinger[i]!=null)
            {
                melding+=skademeldinger[i].toString();
            }
        }
        int e=utbetalteErstatninger(); //Sender med årlig premie og utbetalt erstatning i melding.
        oppdaterKunde();
        melding +="\n"+ "Årlig premie: "+premie;
        melding += "\n"+ "utbetalt erstatnign: "+e;
        
        return melding;
    }
    public String AlttoString()//Legger til fornavn, etternavn og fakturaadresse i melding.
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding += fakturaadresse+"\n";
        return melding;
    } 
  
}
