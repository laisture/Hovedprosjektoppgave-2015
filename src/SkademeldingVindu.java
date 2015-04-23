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
    
    private JFrame vindu =new JFrame ("Send inn ");
    private JPanel p= new JPanel();
    private JPanel s=new JPanel();
    private JPanel b=new JPanel();
    private JLabel k=new JLabel("Kunde");
    private JLabel m=new JLabel("Skriv en beskrivelse av hendelsen samt skaden/skadene: ");
    private JButton knapp= new JButton("trykk her!");
    private JTextField kunde=new JTextField(10);
    private JTextArea beskrivelse= new JTextArea(1, 1);
    JPanel container = new JPanel();
   

    
    public SkademeldingVindu ()
    {
        
        p.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    // Create the layout
    GroupLayout layout = new GroupLayout( p );
    p.setLayout( layout );
    layout.setAutoCreateGaps( true );
        
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        p.add(k);
        p.add(kunde);
        s.add(m);
        s.add(beskrivelse);
        b.add(knapp);
       
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
        
        layout.setHorizontalGroup( layout.createSequentialGroup()
                                       .addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
                                                          .addComponent( k )
                                                          
                                       )
                                       .addGroup( layout.createParallelGroup( GroupLayout.Alignment.LEADING )
                                                          .addComponent( kunde )
                                                          
                                                           )
    );
         layout.setVerticalGroup( layout.createSequentialGroup()
                                     .addGroup( layout.createParallelGroup( GroupLayout.Alignment.BASELINE )
                                                        .addComponent( k )
                                                        .addComponent( kunde ) )
                                     
                                    
    );
        
        
        vindu.add(container);
        container.add(p);
        container.add(b);
        container.add(s);
        vindu.setSize(300,400);
        vindu.setVisible(true);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
