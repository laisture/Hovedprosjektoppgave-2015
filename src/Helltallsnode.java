

import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */

public class Helltallsnode implements Serializable 
{
    private String info;
    Helltallsnode neste;
    
    public Helltallsnode()
    {
        
    }
    
    public Helltallsnode( String data )
    {
        info = data;
        neste = null;
    }
    
    public void skrivTilFil( DataOutputStream fil ) throws IOException
    {
        fil.writeChars( info );
    }
    
    public void lesFraFil( BufferedReader fil ) throws IOException
    {
        info = fil.readLine();
    }
    public String getInfo()
    {
        return info;
    }
    public void setInfo( String nyVerdi )
    {
        info = nyVerdi;
    }
}