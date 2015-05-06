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
   
    Reiseforsikring reise=new Reiseforsikring("europa", 100,199, "forsikring for å reise i europa");
    Husforsikring hus = new Husforsikring("a",1,"b","c",2,"d",3,4,5,6,"e");
    Båtforsikring båt = new Båtforsikring("a","b","c",1,2,"d",3,4,5,"e");
    Bilforsikring bil = new Bilforsikring("f","d","dd","test",4,5,6,7,4,"f");
    Kunde k= new Kunde("test", "testsen", "testgate 1");
    Kunde k2= new Kunde("tes", "testse", "testgate ");
    
    public Kunderegister()
    {
        k2.addForsikring(reise);
        register.add(k);
        register.add(k2);
        k2.addForsikring(hus);
        k2.addForsikring(båt);
        //hus.setGyldig(false);
        k2.addForsikring(bil);
        //bil.bonus();
         
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
