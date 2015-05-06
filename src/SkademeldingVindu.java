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
    private JPanel n=new JPanel();
    private JPanel m=new JPanel();
    private JPanel s=new JPanel();
    private JLabel kundelabel=new JLabel("Kundenummer: ");
    private JLabel beskrivelselabel=new JLabel("Skriv en beskrivelse av hendelsen samt skaden/skadene: ");
    private JButton knapp= new JButton("trykk her!");
    private JTextField kundefield=new JTextField(10);
    private JTextArea beskrivelse= new JTextArea(1, 1);
    private JLabel vitnelabel=new JLabel("eventuelle vitner til hendelsen: ");
    private JTextField vitnefield=new JTextField(10);
    private JLabel typelabel=new JLabel("Hva gjelder skaden: ");
    private String[] typeStrings = { "Bil", "Båt", "Hus", "Fritidsbolig", "Reise", "Annet" };
    private JComboBox type = new JComboBox(typeStrings);
      JFileChooser fc = new JFileChooser();
    //int returnVal = fc.showDialog(FileChooserDemo2.this, "Attach");

    
    public SkademeldingVindu ()
    {
        super ("Send inn skademelding");
        
        p.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    // Create the layout
    BorderLayout layout = new BorderLayout();
    p.setLayout( layout );
    n.setLayout(new GridLayout(3,2));
    
    n.add(kundelabel);
    n.add(kundefield);
    n.add(vitnelabel);
    n.add(vitnefield);
    n.add(typelabel);
    n.add(type);
    
      p.add(n, BorderLayout.NORTH);
      p.add(m, BorderLayout.CENTER);
      p.add(s, BorderLayout.SOUTH);
      
            
              
       
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
