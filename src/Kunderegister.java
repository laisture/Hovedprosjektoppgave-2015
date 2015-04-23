/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
import java.util.*;

public class Kunderegister {
    
    LinkedList<Kunde> register =new LinkedList<>();
   
    Reiseforsikring reise=new Reiseforsikring("europa", 100,199, "forsikring for å reise i europa");
    Husforsikring hus = new Husforsikring("a",1,"b","c",2,"d",3,4,5,6,"e");
    Båtforsikring båt = new Båtforsikring("a","b","c",1,2,"d",3,4,5,"e");
    Kunde k= new Kunde("test", "testsen", "testgate 1");
    
    public Kunderegister()
    {
         k.addForsikring(reise);
         register.add(k);
         k.addForsikring(hus);
         k.addForsikring(båt);
         
    }
    
    public void settInn(Kunde ny)
    {
        register.add(ny);
    }
    public Kunde finnKunde(int k)
    {
        Iterator<Kunde> iterator = register.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next().getForsikringsnummer()==k)
            {
                return (iterator.next());
            }
        }
        return null;
    }
    
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
    }
    
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
