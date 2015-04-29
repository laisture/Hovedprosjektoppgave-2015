

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
    private int info;
    Helltallsnode neste;
    
    public Helltallsnode()
    {
        
    }
    
    public Helltallsnode( int data )
    {
        info = data;
        neste = null;
    }
    
    public void skrivTilFil( DataOutputStream fil ) throws IOException
    {
        fil.writeInt( info );
    }
    
    public void lesFraFil( DataInputStream fil ) throws IOException
    {
        info = fil.readInt();
    }
    public int getInfo()
    {
        return info;
    }
    public void setInfo( int nyVerdi )
    {
        info = nyVerdi;
    }
}