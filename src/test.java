
import java.awt.EventQueue;
import javax.swing.JFrame;
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
        //Kunderegister register= new Kunderegister();
        //SkademeldingVindu vinduetd = new SkademeldingVindu();
       // Boolean ok = register.k.totalKunde();
        
        EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
                            JFrame frame = new Vindu();
                            
			}
		});
    }
    
}
