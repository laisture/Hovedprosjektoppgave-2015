/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
import javax.swing.JTextArea;
import java.io.*;

public class Heltallsliste implements Serializable
{
    private Helltallsnode hode;
    
    public Heltallsliste()
    {
        hode = null;
    }
    
    public void skrivListe(JTextArea elementer)
   {
     elementer.setText("");
     if (hode == null)
       elementer.append( "Tom Heltallsliste\n" );
     else
     {
       Helltallsnode hjelp = hode;
       while (hjelp != null)
       {
         elementer.append(hjelp.getInfo() + " ");
         hjelp = hjelp.neste;
       }
       elementer.append("\n");
     }
   }
}

