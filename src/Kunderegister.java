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
    
   LinkedList<Kunde> register =new LinkedList<Kunde>();
   
    
    public Kunderegister()
    {
        Kunde ny = new Kunde("ola", "nordmann", "gate 1");
        Kunde ny1 = new Kunde("test", "nordmann", "gate 2");
        register.add(ny);
        register.add(ny1);
    }
    
    public void settInn(Kunde ny)
    {
        register.add(ny);
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
