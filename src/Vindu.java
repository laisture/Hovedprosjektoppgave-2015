

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.regex.*;
import javax.swing.event.*;

/**
 *
 * @author Jules
 */
public class Vindu extends JFrame implements Serializable 
{
    
    private Kunderegister register;
    private JFrame f=new JFrame();
    private Kunde k;
    
    //RegEx
    public final static String regexNavn = "^[a-zæøåA-ZÆØÅ]{1,15}$";
    public final static String regexAdresse = "^[a-zæøåA-ZÆØÅ_0-9 -]{1,25}$";
    public final static String regexNr = "^[0-9]{1,10}$";
    public final static String regexRegår = "^[0-9]{4}$";
    
    private JPanel panel=new JPanel();
    
    private JPanel top=new JPanel();
    private JPanel vest=new JPanel();
    private JPanel v=new JPanel();
    private JPanel ø=new JPanel();
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
    //End of båtpanel
    
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
    //Skademelding
    private JPanel skadepanel=new JPanel();
    private JPanel topskade=new JPanel();
    
    private JLabel filter=new JLabel("Vis kunn: ");
    
    //Søk
    private JPanel søk =new JPanel();
    private JPanel søkVest =new JPanel();
    private JPanel søkCenter =new JPanel();
    private JLabel søklabel =new JLabel("Søk:");
    private JTextField søkefelt=new JTextField(20);
    private JButton søkButton=new JButton("Finn kunde");
    private JTextArea output2=new JTextArea(40,40);
    
    
    //skademeldings tabell
//    private Tabell modell = new Tabell();
//    private JTable tabell = new JTable((TableModel) modell);
//    
    
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
        skadepanel.setLayout(new BorderLayout());
        lytter = new Kommandolytter();
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JTabbedPane forsikringer=new JTabbedPane();

        tabbedPane.addTab("ny forsikring",null, panel, "Tegn forsikringer på kunde");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("ny kunde",null, kundepanel, "Legg inn ny kunde i kunderegisteret.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        tabbedPane.addTab("Søk",null, søk, "Søk blandt kunder og se diverse forsikringer som kunden har tegnet.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);

        tabbedPane.addTab("Skademeldinger",null, skadepanel, "Se, vurder og endre på skademeldinger som er blitt sendt inn.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_4);
        
        
        forsikringer.addTab("bil forsikring",null, bilpanel, "Does nothing");
        forsikringer.setMnemonicAt(0, KeyEvent.VK_1);

        forsikringer.addTab("båt forsikring",null, båtpanel, "Does nothing");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_2);
        //hus
        forsikringer.addTab("hus forsikring",null, huspanel, "Does nothing");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_3);

      output.setEditable(false);
      output.setPreferredSize(new Dimension(50,50));
      lagkunde.addActionListener(lytter);
      
      m2.add(fornavnlabel);
      m2.add(fornavnfield);
      m2.add (etternavnlabel);
      m2.add(etternavnfield);
      m2.add(adresselabel);
      m2.add(adressefield);
      m2.add(lagkunde);
      m2.add(output);
     
      ut.setEditable(false);
      
      topbutton.addActionListener(lytter);
      //v.add(knapp);
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
      
      //Skademeldings fane
//      topskade.add(filter);
//      skadepanel.add(topskade,BorderLayout.NORTH);
//      tabell.setRowHeight(100);
//      skadepanel.add(new JScrollPane(tabell), BorderLayout.CENTER);
//      tabell.setAutoCreateRowSorter(true);
//      
      
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
        bilbettext.setLineWrap(true);
        
    
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
        båtbettext.setLineWrap(true);
    }
    public void Forsikringer()
    {
        
    }
    public boolean match(String regex, String inn)
    {
        Pattern mønster = Pattern.compile(regex);
        Matcher match = mønster.matcher(inn);
        return match.matches();
    }
    /*
        Metoden har som oppgave å legge nye kunder inn i registeret, hvis dette går får vi tilbake melding om det.
        Hvis ikke får vi beskjed om feil input, i tillegg er det lagt til regex for å forhindre feil input.
    */
    public void LagKunde()
    {
        Boolean ok = true;
        try
        {
            String fornavn=fornavnfield.getText();
            if(!match(regexNavn,fornavn))
                ok = false;
            String etternavn = etternavnfield.getText();
            if(!match(regexNavn,etternavn))
                ok=false;
            String adresse = adressefield.getText();
            if(!match(regexAdresse, adresse))
                ok= false;
            Boolean ok2=register.nyKunde(fornavn,etternavn,adresse);
            if(!ok2)
                ok= false;
            if(ok)
                output.setText("Kunde er registert med kundenummer : " /*+ kundenr*/);
            else
                output.setText("");
        }
        catch(NumberFormatException | NullPointerException | PatternSyntaxException nfe)
        {
            output.setText("Feil i innput, prøv igjen");
        }
        /*String fornavn=fornavnfield.getText();
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
        }*/
        fornavnfield.setText("");
        etternavnfield.setText("");
        adressefield.setText("");
        
    }
    
    public void søkKunde()
    {
        Boolean ok = true;
        int kundeNr;
        try
        {
            String søk = søkefelt.getText();
            if(!match(regexNr,søk))
                ok = false;
            if(ok)
                kundeNr = Integer.parseInt(søk);
            else
            {
                output2.setText("Feil input, bruk kun nummer");
                søkefelt.setText("");
                return;
            }
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
        catch(NullPointerException | PatternSyntaxException npe)
        {
            søkefelt.setText("");
            output2.setText("Exception please doddodo");
        }
        
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
    public void sendSkademelding(int k, String m, String t, String v,BufferedImage b)
    {
        /*register.SendSkademelding(k, m, t, v,b);*/
    }
    
    
    public void LagBil()
    {
        int regår;
        int kjørelengde;
        int priskm = 1;
        int bonus;
        int bilbeløp;
        //Boolean ok= true;
        try
        {
            String regår2 = regårfield.getText();
            String kjørelengde2= kjørefield.getText();
            String bilbeløp2 = bilbeløpfield.getText();
            if(!match(regexRegår,regår2))
            {
                output.setText("Feil i registeringsår felt, kun tilatt med 4 nummer");
                output.append("\nRegistering ble ikke fulført\n");
                return;
            }

            if(!match(regexNr,kjørelengde2))
            {
                output.setText("Feil i kjørelengde felt, det er kun lov med nummer(maks 10)\n");
            }
            if(!match(regexNr,bilbeløp2))
            regår=Integer.parseInt(regår2);
            kjørelengde=Integer.parseInt(kjørelengde2);
            bonus=20;
            bilbeløp=Integer.parseInt(bilbeløp2);

            Bilforsikring bil=new Bilforsikring(eierfield.getText(), regfield.getText(),btfield.getText(),bmfield.getText()
                                                ,regår,kjørelengde, priskm,bonus, bilbeløp, kjørefield.getText());
            
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
        catch(NumberFormatException nfe)
        {
            
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
    
     class Tabell
    {
        public static final int ERSTATNINGSKOLONNE = 4;
        
        private String[] kolonnenavn =
        {
           "KundeID", "Skadetype", "Dato", "Utbetalt erstatning", "Skademelding", "Bilde"
        };
        private Object[][] tabellskader = register.get2dSkade();
                
        public String getColumnName( int kolonne )
        {
            return kolonnenavn[ kolonne];
        }
        public Class getColumnClass( int kolonne)
        {
            return tabellskader[ 0][ kolonne].getClass();
        }
        public int getColumnCount()
        {
            return tabellskader[ 0].length;
        }
        public int getRowCount()
        {
            return tabellskader.length;
        }
        public boolean istabellskaderEditable(int rad, int kolonne )
        {
            return kolonne == ERSTATNINGSKOLONNE;
        }
        public void setValueAt( Object nyVerdi, int rad, int kolonne )
        {
            tabellskader[ rad][ kolonne] = nyVerdi;
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
