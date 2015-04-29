
import java.io.Serializable;
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
    
    public Helltallsnode ( String d )
    {
        info = d;
        neste = null;
    }
    
    public String getInfo()
    {
        return info;
    }
    
    public void setInfo ( String nyVerdi )
    {
        info =  nyVerdi;
    }
}