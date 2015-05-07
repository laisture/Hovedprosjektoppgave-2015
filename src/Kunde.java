
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
        return true;
    }
    public void addSkademelding(Kunde k, String m, String t, String v)
    {
        Skademelding s=new Skademelding(k,m,t,v);
        for (int i =0;i<skademeldinger.length;i++)
        {
            if(skademeldinger[i]==null)
            {
                skademeldinger[i]=s;
                i=skademeldinger.length+1;
            }
        }
    }
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
    // Metoden går gjennom skaderegister på kunden og legger sammen totalbeløpet for de utbetalte erstatningene.
    // Fungerer ikke helt ennå.  Må sjekke om erstatning er skrevet ut.
    public int utbetalteErstatninger()
    {
        int utbetalteErstatninger = 0;
        
        for(int i = 0; i < skademeldinger.length; i++)
        {
            utbetalteErstatninger += skademeldinger[i].getTakst();
        }
        return utbetalteErstatninger;
    }/*
    public int årligPremie()
    {
       premie = 0;
       Iterator<Forsikring> iterator = forsikringer.iterator();
       while(iterator.hasNext())
       {
           premie += (iterator.next().getPremie());
       }
       return premie;   
    }*/
    //Ny årligPremie() metode, fordi årlig premie skal hentes fra premien sin getmetode.
    // Metoden må kalles på hver gang forsikringer blir lagt til eller fjernet.
    public void årligPremie()
    {
       premie = 0;
       Iterator<Forsikring> iterator = forsikringer.iterator();
       while(iterator.hasNext())
       {
           premie += (iterator.next().getPremie());
       } 
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
    public String toString()
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding+=forsikringsnummer+"\n\n";
        melding += fakturaadresse+"\n\nForsikringer:\n";
        ListIterator<Forsikring> iterator = forsikringer.listIterator();
        
        while(iterator.hasNext())
        {
            melding += iterator.next().toString() + "\n";
        }
        
        return melding;
    }
    public String AlttoString()
    {
        String melding =fornavn+" "+etternavn+ "\n";
        melding += fakturaadresse+"\n\nForsikringer:\n";
        return melding;
    } 
  
}
