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
import java.text.DecimalFormat;

public class DataIOTest extends JFrame 
{
    private JTextArea utskrift;
    
    public DataIOTest()
    {
        super("")
        utskrift = new JTextArea(10, 40);
        add(new JScrollPane(utskrift));
        pack();
        setVisible(true);
    }
    
    public void skrivDatafil(String filnavn)
    {
        try (DataOutputStream ut = 
                new DataOutputStream(new FilOutputStream(filnavn)))
        {
            //data som skal skrives til fil
            //....
            
            //utskrift
            {
                ut. 
            }
        }
        catch ( IOException e)
        {
            system.out.println("Filproblem");
        }
    }
    public void visDatafil (String filnavn)
    {
        
        
        // leser data inn igjen fra fila og skriver ut i tekstområdet
        try (DataInputStream inn = new DataInputStream( new FilInputStream(filnavn)))
        {
            while(true)
            {
                utskrift.append()
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Finner ikke fil" + filnavn);
            return;
        }
        catch (EOFException e)
        {
            //hele filen er lest
            utskrift.append();
        }
        catch (IOException e)
        {
            System.out.println("Problem med lesing fra fil");
        }
    }
}
