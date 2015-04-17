/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
public class Reiseforsikring extends Forsikring
{
    
    private String område;
    private int sum;
    
    public Reiseforsikring(String o, int premie, int beløp, String beskrivelse)
    {
        super(premie,beløp,beskrivelse);
        område=o;
    }
    
    
}
