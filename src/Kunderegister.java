/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
import java.io.Serializable;
import java.util.*;

public class Kunderegister implements Serializable  {
    
    LinkedList<Kunde> register =new LinkedList<>();
   
    
    
    public Kunderegister()
    {
        
        
         
    }
    public void Start()
    {
        Kunde k=new Kunde("","","");
        int i=register.size();
        k.setNestenummer(i+1);
    }
    
     public Skademelding[] getSkademeldinger()
    {
        ArrayList<Skademelding> skademeldinger=new ArrayList();
        
        Skademelding[] kundeskade;
        for (Kunde kunde : register)
        {
            kundeskade=kunde.getSkademeldinger();
            for(int i=0; i<kundeskade.length;i++)
            {
                if(kundeskade[i]!=null)
                {
                    skademeldinger.add(kundeskade[i]);
                }
            }
        }
        Skademelding[] skade = new Skademelding[skademeldinger.size()];
        skade = skademeldinger.toArray(skade);
        return skade;
        
    }
    public void settInn(Kunde ny)
    {
        register.add(ny);
        
    }
    public Boolean nyKunde(String f, String e, String a)
    {
        Kunde b=new Kunde(f,e,a);
        settInn(b);
        return true;
    }
    public Kunde finnKunde(int k)
    {
//       
        for (Kunde kunde : register)
        {
            if (kunde.getForsikringsnummer()==k)
            {    
                return kunde;
            }
        }
        return null;
    }
    public Boolean LagForsikring(Kunde k, Forsikring f)
    {
        Boolean ok=k.addForsikring(f);
        return ok;
    }
    /*
    public Kunde finnKunde(String n)
    {
        Iterator<Kunde> iterator = register.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next().getEtternavn()==n || iterator.next().getFornavn()==n || iterator.next().getNavn()==n)
            {
                return (iterator.next());
            }
        }
        return null;
    }*/
    
    
    public String toString()
    {
        String personer= "";
        Iterator<Kunde> iterator = register.iterator();
        while (iterator.hasNext())
        {
            personer+= iterator.next().toString() + "\n";
        }
        return personer;
    }
   
    // <Metorder for: Oppretting av kunder og forsikringer. >
    //<Metoder for søke gjennom kunder og forsikringer>
    //<Metode for å langre>
    
}
