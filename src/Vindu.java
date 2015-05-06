

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.URL;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.event.*;

/**
 *
 * @author Jules
 */
public class Vindu extends JFrame implements Serializable 
{
    
    private Kunderegister register;
    private JFrame f=new JFrame();
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
    //login
    private JLabel utkunde=new JLabel("Du må søke etter en kunde før du kan tegne forsikring!");
    
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
    private JTextField priskmfield=new JTextField(20);
    private JLabel bilbeløplabel=new JLabel("forsikringsbeløp:");
    private JTextField bilbeløpfield=new JTextField(20);
    private JLabel bilbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea bilbettext=new JTextArea(10,40);
    private JButton lagbil=new JButton("tegn bilforsikring");

    //båteier
    private JPanel båtpanel1=new JPanel();
    private JPanel båtpanel2=new JPanel();
    private JPanel båtpanel3=new JPanel();
    
    private JLabel båteierlabel=new JLabel("Båt eier:");
    private JTextField båteierfield=new JTextField(20);
    private JLabel båtreglabel=new JLabel("registreringsnummer:");
    private JTextField båtregfield=new JTextField(20);
    private JLabel båttlabel=new JLabel("Båt type:");
    private JTextField båttfield=new JTextField(20);
    private JLabel båtmlabel=new JLabel("Båt modell:");
    private JTextField båtmfield=new JTextField(20);
    private JLabel båtårlabel=new JLabel("første registreringsår:");
    private JTextField båtårfield=new JTextField(4);
    private JLabel lengdelabel= new JLabel("Båtlengde (fot):");
    private JTextField lengdefield= new JTextField(4);
    private JLabel motortlabel= new JLabel("Motortype:");
    private JTextField motortfield= new JTextField(20);
    private JLabel motorslabel=new JLabel("Motorstyrke (HK):");
    private JTextField motorsfield=new JTextField(20);
    private JLabel båtbeløplabel=new JLabel("forsikringsbeløp:");
    private JTextField båtbeløpfield=new JTextField(20);
    private JLabel båtbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea båtbettext=new JTextArea(10,40);
    private JButton lagbåt=new JButton("tegn båtforsikring");
    
    
    //husforsikring
    private JPanel huspanel1=new JPanel();
    private JPanel huspanel2=new JPanel();
    private JPanel huspanel3=new JPanel();
    
    private JLabel hadresselabel=new JLabel("Husadresse");
    private JTextField hadressefield=new JTextField(20);
    private JLabel byggårlabel=new JLabel("Byggeår");
    private JTextField byggårfield=new JTextField(20);
    private JLabel boligtypelabel=new JLabel("Bolig type:");
    private JTextField boligtypefield=new JTextField(20);
    private JLabel byggmlabel=new JLabel("Byggmateriale:");
    private JTextField byggmfield=new JTextField(20);
    private JLabel standardlabel=new JLabel("standard:");
    private JTextField standardfield=new JTextField(4);
    private JLabel kvadratlabel= new JLabel("Antall kvadratmeter:");
    private JTextField kvadratfield= new JTextField(4);
    private JLabel byggbeløplabel= new JLabel("forsikringsbeløp for byggnings");
    private JTextField byggbeløpfield= new JTextField(20);
    private JLabel innbobeløplabel=new JLabel("Motorstyrke (HK):");
    private JTextField innbofield=new JTextField(20);
    private JLabel husbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea husbettext=new JTextArea(10,40);
    private JButton laghus=new JButton("tegn båtforsikring");
    
    
    
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
        super("Main frame");
        // Leser kundedata fra fil
        lesFil();
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
      //ø.add(l);
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
      
      
      LagFaner();
      
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
      //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.addWindowListener( 
        new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                SkrivTilFil();
                System.exit(0);
            }
        });
    }
    
    public void LagFaner()
    {
        //bilpanel
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
        bilpanel2.add(regårfield);
        bilpanel2.add(kjørelabel);
        bilpanel2.add(kjørefield);
        bilpanel2.add(bilbeløplabel);
        bilpanel2.add(bilbeløpfield);
        bilpanel3.add(bilbetingelser);
        bilpanel3.add(bilbettext);
        bilpanel3.add(lagbil);
        lagbil.addActionListener(lytter);
    
        båtpanel.setLayout(new BorderLayout());
        båtpanel.add(båtpanel1, BorderLayout.NORTH);
        båtpanel.add(båtpanel2, BorderLayout.CENTER);
        båtpanel.add(båtpanel3, BorderLayout.SOUTH);
        båtpanel1.add(båteierlabel);
        båtpanel1.add(båteierfield);
        båtpanel1.add(båtreglabel);
        båtpanel1.add(båtregfield);
        båtpanel1.add(båttlabel);
        båtpanel1.add(båttfield);
        båtpanel2.add(båtmlabel);
        båtpanel2.add(båtmfield);
        båtpanel2.add(båtårlabel);
        båtpanel2.add(båtårlabel);
        båtpanel2.add(lengdelabel);
        båtpanel2.add(lengdefield);
        båtpanel2.add(motortlabel);
        båtpanel2.add(motortfield);
        båtpanel2.add(motorslabel);
        båtpanel2.add(motorsfield);
        båtpanel2.add(båtbeløplabel);
        båtpanel2.add(båtbeløpfield);
        båtpanel3.add(båtbetingelser);
        båtpanel3.add(båtbettext);
        båtpanel3.add(lagbåt);    
        //båtpanel
        båtpanel.setLayout(new BorderLayout());
        båtpanel.add(båtpanel1, BorderLayout.NORTH);
        båtpanel.add(båtpanel2, BorderLayout.CENTER);
        båtpanel.add(båtpanel3, BorderLayout.SOUTH);
        båtpanel1.add(båteierlabel);
        båtpanel1.add(båteierfield);
        båtpanel1.add(båtreglabel);
        båtpanel1.add(båtregfield);
        båtpanel1.add(båttlabel);
        båtpanel1.add(båttfield);
        båtpanel2.add(båtmlabel);
        båtpanel2.add(båtmfield);
        båtpanel2.add(båtårlabel);
        båtpanel2.add(båtårlabel);
        båtpanel2.add(lengdelabel);
        båtpanel2.add(lengdefield);
        båtpanel2.add(motortlabel);
        båtpanel2.add(motortfield);
        båtpanel2.add(motorslabel);
        båtpanel2.add(motorsfield);
        båtpanel2.add(båtbeløplabel);
        båtpanel2.add(båtbeløpfield);
        båtpanel3.add(båtbetingelser);
        båtpanel3.add(båtbettext);
        båtpanel3.add(lagbåt);   
    }
    public void Forsikringer()
    {
        
    }
    public void LagKunde()
    {
        String fornavn=fornavnfield.getText();
        String etternavn=etternavnfield.getText();
        String adresse=adressefield.getText();
        Boolean ok=register.nyKunde(fornavn,etternavn,adresse);
        if (ok)
        {
          
         output.setText("Kunde er opprettet");
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
          båteierfield.setText(k.getNavn());  
        }
        
    }
    public void finnKunde()
    {
        int kundeNr = Integer.parseInt(topfield.getText());
        Kunde kunden1 = register.finnKunde(kundeNr);
        if(kunden1 !=null)
        {
            
            ut.setText(kunden1.AlttoString());
            k=kunden1;
        }
        else
        {
            ut.setText("Finnes ingen kunder med dette kundenummeret");
        }
        topfield.setText("");
          
    }
    
    
    public void LagBil()
    {
        int regår=Integer.parseInt(regårfield.getText());
        int kjør=Integer.parseInt(kjørefield.getText());
        int priskm=Integer.parseInt("12");
        int bonus=Integer.parseInt("123");
        int bilbeløp=Integer.parseInt(bilbeløpfield.getText());
    
        Bilforsikring bil=new Bilforsikring(eierfield.getText(), regfield.getText(),btfield.getText(),bmfield.getText(),regår,kjør, priskm,bonus, bilbeløp, kjørefield.getText());
        Boolean ok=register.LagForsikring(k, bil);
        if(ok)
        {
            eierfield.setText("");
            regfield.setText("");
            btfield.setText("");
            bmfield.setText("");
            bilbeløpfield.setText("");
            kjørefield.setText("");
            regårfield.setText("");
        }
    
    }
    private class Kommandolytter implements ActionListener
    {
       
        public void actionPerformed( ActionEvent e )
        {
          if ( e.getSource() == lagkunde )
            LagKunde();
          else if(e.getSource() == søkButton  )
            søkKunde();
          else if(e.getSource()==topbutton )
            finnKunde();
          else if(e.getSource()==lagbil)
            LagBil();
          
          Bileier();
        }
    }
    
     private void visFeilmelding(String melding)
    {
      JOptionPane.showMessageDialog(this, melding,
              "Problem", JOptionPane.ERROR_MESSAGE);
    }
    /*
        Metoden blir kalt opp hver gang programmet starter og blir lagret i minne.
        Metoden har som ansvar for å lese filen liste.data, som skal inneholde all data om kundene i systemet.
        Hvis den er tom, dvs kunderegisteret ikke er blitt opprettet ennå, vil den automatisk bli opprettet første gang.
        I tillegg er det lagt til try/catch blokker for feilbehandling.
    */ 
    public void lesFil()
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream( "src/liste.data" )))
        {
            register = (Kunderegister) innfil.readObject();
        }
        catch(ClassNotFoundException cnfe)
        {
            ut.setText(cnfe.getMessage());
            ut.append("\nOppretter tom liste.\n");
            register = new Kunderegister();
        }
        catch(FileNotFoundException fne)
        {
            ut.setText("Finner ikke datafil. Oppretter tom liste.\n");
            register = new Kunderegister();
        }
       catch(IOException ioe)
        {
            ut.setText("Innlesingsfeil. Oppretter tom liste.\n");
            register = new Kunderegister();
        }
    }
    /*
        Denne metoden kjøres hver gang programmet avsluttes.
        All informasjon som ligger i Kunderegisteret blir lagret til fil.
        Passende try/catch blokker er lagt til for feilhåndtering.
    */
    public void SkrivTilFil()
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
             new FileOutputStream("src/liste.data")))
        {
            utfil.writeObject(register);
        }
        catch( NotSerializableException nse )
        {
            visFeilmelding("Objektet er ikke serialisert!");
        }
        catch( IOException ioe )
        {
            visFeilmelding("Problem med utskrift til fil.");
        }
    }
}
