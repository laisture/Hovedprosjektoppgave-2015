
import java.io.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jules
 */
public class Lagring 
{
    private Kunderegister kundene = new Kunderegister();
    
    public Lagring()
    {
        lesFil();
    }
    
    public void lesFil()
    {
        try(ObjectInputStream les = new ObjectInputStream(
            new FileInputStream("src/lagrefil.data")))
        {
            kundene = (Kunderegister) les.readObject();
        }
        catch(FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null,"Finner ikke fil");
        }
        catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null,"Finner ikke klassen ");
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(null,"Feil ved lesing av fil");
        }
    }
    
    public void skrivTilFil()
    {
        try(ObjectOutputStream skrive = new ObjectOutputStream(
            new FileOutputStream("src/lagrefil.data")))
        {
            skrive.writeObject(kundene);
        }
        catch(NotSerializableException nse)
        {
            JOptionPane.showMessageDialog(null,"Objektet er ikke serialisert");
        }
        catch(IOException ioe)
        {
            JOptionPane.showMessageDialog(null,"Feil ved skriving til fil");
        }
    }
}
