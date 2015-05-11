/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.*;

public class Kunderegister implements Serializable  {
    
    LinkedList<Kunde> register =new LinkedList<>();
   
    
    
    public Kunderegister()
    {
        nyKunde("ola","nordmann","testgate 1");
       SendSkademelding(1,"Dette er en test", "bil", "test");
         
    }
    public void Start()
    {
        Kunde k=new Kunde("","","");
        int i=register.size();
        k.setNestenummer(i+1);
    }
    
    public void SendSkademelding(int k, String m, String t, String v)
    {
        
        Kunde kunde=finnKunde(k);
        kunde.addSkademelding(kunde,m,t,v);
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
     public Object[][] get2dSkade()
     {
         
         Skademelding[] skader=getSkademeldinger();
         Object[][] s=new Object[skader.length][5];
         
         for (int i=0; i<skader.length;i++)
         {
             
             if(skader[i]!=null)
             {
                s[i][0]=skader[i].getKunde().getForsikringsnummer();
                s[i][1]=skader[i].getType();
                s[i][2]=skader[i].getDato();
                s[i][3]=skader[i].getTakst();
                s[i][4]=skader[i].getMelding();
             //s[i][5]=skader[i].getBildet();
         
             }
         }
         
         return s;
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
    
}
