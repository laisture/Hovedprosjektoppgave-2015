/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
public class Båtforsikring extends Forsikring
     {
    private String navn;
    private String reginr;
    private String modell;
    private int lengde;
    private int årsmodell;
    private String motor;
    private int motorstyrke;
    
    public String getNavn()
    {
        return navn;
    }
    public String getReginr()
    {
       return reginr; 
    }
    public String getModell()
    {
        return modell;
    }
    public int getLengde()
    {
        return lengde;
    }
    public int getÅrsmodell()
    {
        return årsmodell;
    }
    public String getMotor()
    {
        return motor;
    }
    public int getMotorstyrke()
    {
        return motorstyrke;
    }
}
