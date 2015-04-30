


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.event.*;

/**
 *
 * @author Jules
 */
public class Vindu extends JFrame
{
    private Kunderegister register= new Kunderegister();
    private JFrame f=new JFrame();
   
    
    
    //panel
    private Kunde k;
    
    private JPanel panel=new JPanel();
    
    private JPanel top=new JPanel();
    private JPanel vest=new JPanel();
    private JPanel v=new JPanel();
    private JPanel ø=new JPanel();
    private JButton knapp=new JButton("test!");
    private JPanel midt=new JPanel();
    private JPanel mm=new JPanel();
    private JPanel mf=new JPanel();
    
    //topsøk
    private JLabel toplabel=new JLabel("Finn kunde:");
    private JTextField topfield=new JTextField(20);
    private JButton topbutton=new JButton("finn");
    
    private JTextArea ut=new JTextArea(20,40);
    //Forsikringstabber
    private JPanel bilpanel=new JPanel();
    private JPanel båtpanel=new JPanel();
    private JPanel huspanel=new JPanel();
    
    
    //bilpanel
    private JPanel bilpanel1=new JPanel();
    private JPanel bilpanel2=new JPanel();
    private JPanel bilpanel3=new JPanel();
    
    private JLabel eierlabel=new JLabel("Bil eier:");
    private JTextField eierfield=new JTextField(20);
    private JLabel reglabel=new JLabel("registreringsnummer:");
    private JTextField regfield=new JTextField(20);
    private JLabel btlabel=new JLabel("Bil type:");
    private JTextField btfield=new JTextField(20);
    private JLabel bmlabel=new JLabel("Bil merke:");
    private JTextField bmfield=new JTextField(20);
    private JLabel regårlabel=new JLabel("første registreringsår:");
    private JTextField regårfield=new JTextField(20);
    private JLabel kjørelabel= new JLabel("Kjørelengde per år (km): ");
    private JTextField kjørefield= new JTextField(20);
    private JLabel priskm= new JLabel("pris per km");
    
    private JLabel bilbeløplabel=new JLabel("forsikringsbeløp:");
    private JTextField bilbeløpfield=new JTextField(20);
    private JLabel bilbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea bilbettext=new JTextArea(10,40);
    private JButton lagbil=new JButton("tegn bilforsikring");

    
    
    //andre tab
    private JPanel kundepanel=new JPanel();
    private JPanel m2=new JPanel();
    private JPanel vest2=new JPanel();
    private JLabel fornavnlabel=new JLabel("Fornavn:");
    private JTextField fornavnfield=new JTextField(30);
    private JLabel etternavnlabel=new JLabel("Etternavn:");
    private JTextField etternavnfield=new JTextField(15);
    private JLabel adresselabel=new JLabel("Faktura adresse:");
    private JTextField adressefield=new JTextField(15);
    private JButton lagkunde=new JButton("registrer kunde");
    private JTextArea output=new JTextArea(20,40);
    
    //Søk
    private JPanel søk =new JPanel();
    private JPanel søkVest =new JPanel();
    private JPanel søkCenter =new JPanel();
    private JLabel søklabel =new JLabel("Søk:");
    private JTextField søkefelt=new JTextField(20);
    private JButton søkButton=new JButton("Finn kunde");
    private JTextArea output2=new JTextArea(40,40);
    
    private Kommandolytter lytter;
    
    public Vindu()
    {
      super("Hallo");
      panel.setLayout(new BorderLayout());
      vest.setLayout(new BorderLayout());
      kundepanel.setLayout(new BorderLayout());
      midt.setLayout(new BorderLayout());
      søk.setLayout(new BorderLayout());
       lytter = new Kommandolytter();
       
     
      
      JTabbedPane tabbedPane = new JTabbedPane();
      JTabbedPane forsikringer=new JTabbedPane();
    
     tabbedPane.addTab("ny forsikring",null, panel, "Does nothing");
     tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
      
      tabbedPane.addTab("ny kunde",null, kundepanel, "Does nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
     //Bil
     tabbedPane.addTab("Søk",null, søk, "Does nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);
      
     forsikringer.addTab("bil forsikring",null, bilpanel, "Does nothing");
     forsikringer.setMnemonicAt(0, KeyEvent.VK_1);
      
      forsikringer.addTab("båt forsikring",null, båtpanel, "Does nothing");
      forsikringer.setMnemonicAt(1, KeyEvent.VK_2);
     //Bil
     forsikringer.addTab("hus forsikring",null, huspanel, "Does nothing");
     forsikringer.setMnemonicAt(1, KeyEvent.VK_3);
     
      String[] a = {"Bilforsikring","Båtforsikring","en til"};
      
      JList<String> l = new JList<>(a);
        l.setVisibleRowCount(3);
        l.setFixedCellWidth(50);
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        l.setSelectedIndex(4);
        l.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if( !e.getValueIsAdjusting() )
                {
                    String velger = l.getSelectedValue();
                    // get info
                }
            }
        });
      output.setEditable(false);
      output.setPreferredSize(new Dimension(100,100));
      lagkunde.addActionListener(lytter);
      
      m2.add(fornavnlabel);
      m2.add(fornavnfield);
      m2.add (etternavnlabel);
      m2.add(etternavnfield);
      m2.add(adresselabel);
      m2.add(adressefield);
      m2.add(lagkunde);
      m2.add(output);
     
      
      
      topbutton.addActionListener(lytter);
      v.add(knapp);
      ø.add(l);
      top.add(toplabel);
      top.add(topfield);
      top.add(topbutton);
      mm.add(ut);
      mf.add(forsikringer);
      midt.add(top, BorderLayout.NORTH);
      midt.add(mm, BorderLayout.CENTER);
      midt.add(mf, BorderLayout.SOUTH);
      vest.add(v, BorderLayout.WEST);
      vest.add(ø, BorderLayout.EAST);
      bilpanel.setLayout(new BorderLayout());
      bilpanel.add(bilpanel1, BorderLayout.NORTH);
      bilpanel.add(bilpanel2, BorderLayout.CENTER);
      bilpanel.add(bilpanel3, BorderLayout.SOUTH);
      bilpanel1.add(eierlabel);
      bilpanel1.add(eierfield);
      bilpanel1.add(reglabel);
    bilpanel1.add(regfield);
    bilpanel1.add(btlabel);
    bilpanel1.add(btfield);
    bilpanel2.add(bmlabel);
    bilpanel2.add(bmfield);
    bilpanel2.add(regårlabel);
    bilpanel2.add(regårlabel);
    bilpanel2.add(kjørelabel);
    bilpanel2.add(kjørefield);
    bilpanel2.add(bilbeløplabel);
    bilpanel2.add(bilbeløpfield);
    bilpanel3.add(bilbetingelser);
    bilpanel3.add(bilbettext);
    bilpanel3.add(lagbil);
    
    panel.add(vest, BorderLayout.WEST);
    panel.add(midt,BorderLayout.CENTER);
      
      kundepanel.add(vest2, BorderLayout.WEST);
      kundepanel.add(m2, BorderLayout.CENTER);
      


//Søk-fane 
        
      søkVest.add(søklabel);
      søkCenter.add(søkefelt);
      søkCenter.add(søkButton);
      søkCenter.add(output2);
      søk.add(søkVest,BorderLayout.WEST);
      søk.add(søkCenter,BorderLayout.CENTER);
      søkButton.addActionListener(lytter);
      
      
      
      f.add(tabbedPane);
      f.pack();
      f.setVisible(true);
      //f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
           
    public void LagKunde()
    {
        String fornavn=fornavnfield.getText();
        String etternavn=etternavnfield.getText();
        String adresse=adressefield.getText();
        Boolean ok=register.nyKunde(fornavn,etternavn,adresse);
        if (ok)
        {
         output.setText("Kunde er oprettet!");
        }
        else
        {
            output.setText("Kunde ble ikke opprettet");
        }
        fornavnfield.setText("");
        etternavnfield.setText("");
        adressefield.setText("");
    }
    
    public void søkKunde()
    {
        int kundeNr = Integer.parseInt(søkefelt.getText());
        Kunde kunden = register.finnKunde(kundeNr);
        if(kunden !=null)
        {
            output2.setText(kunden.toString());
            k=kunden;
        }
        else
        {
            output2.setText("Finnes ingen kunder med dette kundenummeret");
        }
        søkefelt.setText("");
        
    }
    public void Bileier()
    {
        if (k!=null)
        {
          eierfield.setText(k.getNavn());  
        }
        
    }
    public void finnKunde()
    {
      int kundeNr = Integer.parseInt(topfield.getText());
        Kunde kunden = register.finnKunde(kundeNr);
        if(kunden !=null)
        {
            
            ut.setText(kunden.AlttoString());
            k=kunden;
        }
        else
        {
            ut.setText("Finnes ingen kunder med dette kundenummeret");
        }
        topfield.setText("");
          
    }
    
  /*  public void LagBil()
    {
        Bilforsikring bil=New Bilforsikring(eierfield.getText(), reg.getText(),bt.getText(),Integer.parseInt(bm.getText()),Integer.parseInt(regårfield.getText()),Integer.parseInt(kjørefield), int k, int premie, int beløp, String beskrivelse)
    }*/
   private class Kommandolytter implements ActionListener
  {
       
   
    @Override
    public void actionPerformed( ActionEvent e )
    {
        System.out.println("test");
      if ( e.getSource() == lagkunde )
        LagKunde();
      else if(e.getSource() == søkButton  )
          søkKunde();
      else if(e.getSource()==topbutton )
          finnKunde();
      /*else if(e.getSource()==lagbil)
          LagBil();
      */
      
      Bileier();
    }

        
  }  
}
