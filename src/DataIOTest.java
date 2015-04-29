/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataIOTest extends JFrame 
{
    private Kommandolytter lytteren;
    private Heltallsliste heltallsliste;
    private JTextArea lista, kopien;
    
    public DataIOTest()
    {
        super("Test av heltallsliste");
        lista = new JTextArea( 10, 45);
        lista.setEditable( false );
        lytteren = new Kommandolytter();
        lesFil();
        skrivListe();
    }
    private void visFeilmelding( String melding)
    {
        JOptionPane.showMessageDialog(this, melding, "Problem", JOptionPane.ERROR_MESSAGE);
    }
    
    private void lesFil()
  {
    try (ObjectInputStream innfil = new ObjectInputStream(
            new FileInputStream( "src/liste.data" )))
    {
      heltallsliste = (Heltallsliste) innfil.readObject();
    }
    catch(ClassNotFoundException cnfe)
    {
      lista.setText(cnfe.getMessage());
      lista.append("\nOppretter tom liste.\n");
      heltallsliste = new Heltallsliste();
    }
    catch(FileNotFoundException fne)
    {
      lista.setText("Finner ikke datafil. Oppretter tom liste.\n");
      heltallsliste = new Heltallsliste();
    }
    catch(IOException ioe)
    {
      lista.setText("Innlesingsfeil. Oppretter tom liste.\n");
      heltallsliste = new Heltallsliste();
    }
  }

  public void skrivTilFil()
  {
    try (ObjectOutputStream utfil = new ObjectOutputStream(
            new FileOutputStream("src/liste.data")))
    {
      utfil.writeObject(heltallsliste);
    }
    catch( NotSerializableException nse )
    {
      visFeilmelding("Objektet er ikke serialisert!");
    }
    catch( IOException ioe )
    {
      visFeilmelding("Problem med utskrift til fil.");
    }
    
  }
  public void skrivListe()
  {
      heltallsliste.skrivListe(lista);
  }
}