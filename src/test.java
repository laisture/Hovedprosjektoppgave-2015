
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Kunderegister register= new Kunderegister();
        SkademeldingVindu vindu = new SkademeldingVindu();
        Boolean ok = register.k.totalKunde();
        int årlig = register.k.årligPremie();
        System.out.println(ok);
        System.out.println(årlig);
        //System.out.println(register.toString());
    }
    
}
