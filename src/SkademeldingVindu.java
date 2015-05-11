/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.util.Locale.filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
//import java.net.URL; //Ikon

/**
 *
 * @author Joakim
 */

public class SkademeldingVindu  extends JFrame  {
    
    final Vindu frame= new Vindu();
    
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
    private JButton bbutton=new JButton("last opp bildet av hendelsen");
    private JComboBox type = new JComboBox(typeStrings);
    private Kommandolytter lytter;
    private BufferedImage bildet;
    private BufferedImage visbildet;
    
    private JFileChooser chooser = new JFileChooser();
    private FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
    
    
    public SkademeldingVindu ()
    {
        super ("Send inn skademelding");
        this.visbildet = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
        
        p.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
     chooser.setFileFilter(filter);
     
    
    {
        
    
    // Create the layout
    BorderLayout layout = new BorderLayout();
    p.setLayout( layout );
    n.setLayout(new GridLayout(3,2));
    m.setLayout(new GridLayout(2,1));
    s.setLayout(new GridLayout(3,1));
    lytter = new Kommandolytter();
    bbutton.addActionListener(lytter);
    knapp.addActionListener(lytter);
    
    n.add(kundelabel);
    n.add(kundefield);
    n.add(vitnelabel);
    n.add(vitnefield);
    n.add(typelabel);
    n.add(type);
    m.add(beskrivelselabel);
    m.add(beskrivelse);
    s.add(bbutton);
    
    s.add(knapp);
    
      p.add(n, BorderLayout.NORTH);
      p.add(m, BorderLayout.CENTER);
      p.add(s, BorderLayout.SOUTH);
      

          
       
        //Legger til ikon til vinduet
        String bildefil = "Ikon.png";
        URL kilde = SkademeldingVindu.class.getResource(bildefil);
        if(kilde!=null)
        {
            ImageIcon bilde = new ImageIcon(kilde);
        System.out.println(kilde);
            Image ikon = bilde.getImage();
            
            vindu.setIconImage(ikon);
        }
        vindu.add(p);
        vindu.setSize(400,400);
        
        
        
        
        
        
        
        vindu.setVisible(true);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    }
    public void Bildet()
    {
        chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
       
            try {
                bildet = ImageIO.read(chooser.getSelectedFile());
                
                Graphics2D graphics2D = visbildet.createGraphics();

                    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,

                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        
                    graphics2D.drawImage(bildet, 0, 0, 200, 200, null);

                s.add(new JLabel(new ImageIcon(visbildet)));
            } catch (IOException ex) {
                Logger.getLogger(SkademeldingVindu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 

    }
    public void SendSkademelding()
    {
       int k=Integer.parseInt(kundefield.getText());
       String t=(String)type.getSelectedItem();
       /*frame.sendSkademelding(k,beskrivelse.getText(),t,vitnefield.getText());*/
       
    }
    
    private class Kommandolytter implements ActionListener
    {
       
        public void actionPerformed( ActionEvent e )
        {
          if ( e.getSource() == bbutton )
           Bildet();
          else if (e.getSource()==knapp)
              SendSkademelding();
          
          
        }
    }
    
    
    
}
