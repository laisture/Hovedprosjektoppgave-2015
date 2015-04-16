/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
public class Fritidsforsikring extends Forsikring {
    
    private String fritidsadresse;
    private int byggeår;
    private String boligtype;
    private String byggmater;
    private String standard;
    private int kvaderatm;
    private int bygging;
    private int innbo;
    private boolean utleie;
    
    public String getFritidsadresse()
    {
        return fritidsadresse;
    }
    public int getByggeår()
    {
        return byggeår;
    }
    public String getBoligtype()
    {
        return boligtype;
    }
    public String getByggmater()
    {
        return byggmater;
    }
    public String getStandard()
    {
        return standard;
    }
    public int getKvaderatm()
    {
        return kvaderatm;
    }
    public int getBygging()
    {
        return bygging;
    }
    public int getInnbo()
    {
        return innbo;
    }
}
