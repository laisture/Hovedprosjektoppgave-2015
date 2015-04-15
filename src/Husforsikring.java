/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
public class Husforsikring extends Forsikring {
    
    private String fakturadresse;
    private String adresse;
    private int byggeår;
    private String boligtype;
    private String byggmaterial;
    private String standard;
    private int kvadratmeter;
    private int byggebeløp;
    private int innbobeløp;
    
    public String getFakturadresse()
    {
        return fakturadresse;
    }
    public String getAdresse()
    {
        return adresse;
    }
    public int getByggeår()
    {
        return byggeår;
    }
    public String getBoligtype()
    {
        return boligtype;
    }
    public String getByggmaterial()
    {
        return byggmaterial;
    }
    public String getStandard()
    {
        return standard;
    }
    public int getKvadratmeter()
    {
        return kvadratmeter;
    }
    public int getByggebeløp()
    {
        return byggebeløp;
    }
    public int getInnbobeløp()
    {
        return innbobeløp;
    }
}
