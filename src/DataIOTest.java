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

public class DataIOTest extends JFrame 
{
    private Helltallsnode hode;
    
    public DataIOTest()
    {
        hode = null;
    }
    
   public void skrivTilfil( String filnavn )
    {
     try( DataOutputStream fil = new DataOutputStream(
			                          new FileOutputStream( filnavn ) ) )
    {
			Helltallsnode løper = hode;
      while ( løper != null )
      {
        løper.skrivTilFil( fil );
        løper = løper.neste;
      }
    }
    catch ( IOException ioe )
    {
      System.out.equals( "Fikk ikke skrevet datafil." );
    }
  }

  public void lesFraFil( String filnavn )
  {

    try( BufferedReader fil = new BufferedReader( new FileReader( filnavn ) ) )
    {
      while ( true )
      {
				Helltallsnode ny = new Helltallsnode();
        ny.lesFraFil( fil );
      }
    }
    catch ( FileNotFoundException fnfe )
    {
      System.err.println( "Finner ikke fil " + filnavn );
    }
    catch ( EOFException eofe )
    {

    }
    catch ( IOException ioe )
    {
      System.err.println( "Får ikke lest fil " + filnavn );
    }
    
  }
  public void skrivListe(JTextArea elementer)
  {
     elementer.setText("");
     if ( hode==null )
       elementer.append( "Tom Heltallsliste\n" );
     else
     {
       Helltallsnode hjelp = hode;
       while ( hjelp!=null)
       {
         elementer.append( hjelp.getInfo()+ " " );
         hjelp = hjelp.neste;
       }
       elementer.append( "\n" );
     }
  }
}