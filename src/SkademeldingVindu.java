/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.net.*;
import java.awt.*;
//import java.net.URL; //Ikon

/**
 *
 * @author Joakim
 */

public class SkademeldingVindu  extends JFrame  {
    
    private JFrame vindu =new JFrame ("Send inn ");
    private JPanel p= new JPanel();
    private JPanel s=new JPanel();
    private JPanel b=new JPanel();
    private JLabel kundelabel=new JLabel("Kunde");
    private JLabel m=new JLabel("Skriv en beskrivelse av hendelsen samt skaden/skadene: ");
    private JButton knapp= new JButton("trykk her!");
    private JTextField kundefield=new JTextField(10);
    private JTextArea beskrivelse= new JTextArea(1, 1);
    
      JFileChooser fc = new JFileChooser();
    //int returnVal = fc.showDialog(FileChooserDemo2.this, "Attach");

    
    public SkademeldingVindu ()
    {
        super ("Send inn skademelding");
        
        p.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    // Create the layout
    BorderLayout layout = new BorderLayout();
    p.setLayout( layout );
   
        
        p.add(kundelabel);
        p.add(kundefield);
        s.add(m);
        s.add(beskrivelse);
        b.add(knapp);
       
        //Legger til ikon til vinduet
        String bildefil = "Ikon.png";
        URL kilde = SkademeldingVindu.class.getResource(bildefil);
        System.out.println(kilde);
        if(kilde!=null)
        {
            ImageIcon bilde = new ImageIcon(kilde);
            Image ikon = bilde.getImage();
            
            vindu.setIconImage(ikon);
        }
        vindu.add(p);
        vindu.setSize(400,400);
        
        
        
        
        
        
        
        vindu.setVisible(true);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
