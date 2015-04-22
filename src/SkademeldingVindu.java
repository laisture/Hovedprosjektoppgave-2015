/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
//import java.net.URL; //Ikon

/**
 *
 * @author Joakim
 */
public class SkademeldingVindu  extends JFrame  {
    
    private JFrame vindu =new JFrame ("Frame");
    private JPanel p= new JPanel(new GridLayout());
    private JLabel l=new JLabel("Kunde");
    private JButton knapp= new JButton("trykk her!");
    private JTextField kunde=new JTextField(10);
    
    
    public SkademeldingVindu ()
    {
        
        p.add(l);
        p.add(kunde);
        p.add(knapp);
       
        /*Legger til ikon til vinduet
        String bildefil = "Ikon.png";
        URL kilde = SkademeldingVindu.class.getResource(bildefil);
        System.out.println(kilde);
        if(kilde!=null)
        {
            ImageIcon bilde = new ImageIcon(kilde);
            Image ikon = bilde.getImage();
            setIconImage(ikon);
        }*/
        vindu.add(p);
        vindu.setSize(400,400);
        vindu.setVisible(true);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
