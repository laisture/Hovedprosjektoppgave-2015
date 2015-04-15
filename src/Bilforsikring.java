/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dreadleet
 */
public class Bilforsikring extends Forsikring {
    private String navn;
    private String reginr;
    private String biltype;
    private int modell;
    private int regiår;
    private int kjørelengde;
    private int kilometer;
    private int bonus;
    
    public Bilforsikring(String n, String reg,String type, int m, int år, int lengde, int k, int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse);
        navn=n;
        reginr=reg;
        biltype=type;
        modell=m;
        regiår=år;
        kjørelengde=lengde;
        kilometer=k;
        
    }
    
    public String getNavn()
    {
        return navn;
    }
    public String getReginr()
    {
        return reginr;
    }
    public String getBiltype()
    {
        return biltype;
    }
    public int getModell()
    {
        return modell;
    }
    public int getRegiår()
    {
        return regiår;
    }
    public int getKjørelengde()
    {
        return kjørelengde;
    }
    public int getKilometer()
    {
        return kilometer;
    }
    public int getBonus()
    {
        return bonus;
    }
    
}
