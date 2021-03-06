

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Filen inneholder vindu komponenter: tekstfelt, knapper, lyttemetoder, paneler og regex.
 * Filen inneholder også noen metoder for lagring av kunde, søke metoder for kunde, forsikring og skademelding.
 * Siste edit: 19.05.15
 * @author Julian, Joakim og Kristian.
 * Hensikten med klassen er å opprette vindu komponentene og noen metoder som blir brukt i vinduet og til tabell.
 * I lagres og leses data til fil liste.data.
 */
public class Vindu extends JFrame implements Serializable 
{
    
    private Kunderegister register;
    
    private JFrame f=new JFrame();
    private Kunde k;
    
    //RegEx
    public final static String regexFulltnavn = "^[a-zæøåA-ZÆØÅ ]{2,30}$";
    public final static String regexNavn = "^[a-zæøåA-ZÆØÅ]{1,15}$";
    public final static String regexAdresse = "^[a-zæøåA-ZÆØÅ_0-9 -]{1,25}$";
    public final static String regexNr = "^[0-9]{1,10}$";
    public final static String regexRegår = "^[0-9]{4}$";
    public final static String regexRegNr = "^[a-zæøåA-ZÆØÅ_0-9]{7}$";
    public final static String regexBetingelser = "^[a-zæøåA-ZÆØÅ_0-9 ,./]{10,500}$";
    public final static String regexMotorstyrke = "^[0-9]{1,4}$";
    //Slutt på Regex
    private JPanel panel=new JPanel();
    
    private JPanel top=new JPanel();
    private JPanel vest=new JPanel();
    private JPanel v=new JPanel();
    private JPanel ø=new JPanel();
    private JPanel midt=new JPanel();
    private JPanel mm=new JPanel();
    private JPanel mf=new JPanel();
    private JPanel p=new JPanel();
    
    //topsøk
    private JLabel toplabel=new JLabel("Finn kunde:");
    private JTextField topfield=new JTextField(20);
    private JButton topbutton=new JButton("finn");
    
    private JTextArea ut=new JTextArea(15,40);
    //Forsikringstabber
    private JPanel bilpanel=new JPanel();
    private JPanel båtpanel=new JPanel();
    private JPanel huspanel=new JPanel();
    private JPanel fritidpanel = new JPanel();
    private JPanel reisepanel = new JPanel();
    //login
    private JLabel utkunde=new JLabel("Du må søke etter en kunde før du kan tegne forsikring!");
    
    //bilpanel
    private JPanel bilpanel1=new JPanel();
    private JPanel bilpanel2=new JPanel();
    private JPanel bilpanel3=new JPanel();
    private JPanel bileierp=new JPanel();
    private JPanel bilregp=new JPanel();
    private JPanel biltp=new JPanel();
    private JPanel bilmp=new JPanel();
    private JPanel bilårp=new JPanel();
    private JPanel bilkjørep=new JPanel();
    private JPanel bilprisp=new JPanel();
    private JPanel bilpremie =new JPanel();
    private JPanel bilbeløpp=new JPanel();
    
    private JLabel eierlabel=new JLabel("Bil eier:");
    private JTextField eierfield=new JTextField(10);
    private JLabel reglabel=new JLabel("registreringsnummer:");
    private JTextField regfield=new JTextField(10);
    private JLabel btlabel=new JLabel("Bil type:");
    private JTextField btfield=new JTextField(10);
    private JLabel bmlabel=new JLabel("Bil merke:");
    private JTextField bmfield=new JTextField(10);
    private JLabel regårlabel=new JLabel("første registreringsår:");
    private JTextField regårfield=new JTextField(10);
    private JLabel kjørelabel= new JLabel("Kjørelengde per år (km): ");
    private JTextField kjørefield= new JTextField(5);
    private JLabel priskm= new JLabel("pris per km");
    private JTextField priskmfield=new JTextField(10);
    private JLabel bpremielabel= new JLabel("Forsikringspremie:");
    private JTextField bpremiefield=new JTextField(10);
    private JLabel bilbeløplabel=new JLabel("forsikringsbeløp:");
    private JTextField bilbeløpfield=new JTextField(10);
    
    private JTextArea bilbettext=new JTextArea(7,40);
    private JButton lagbil=new JButton("tegn bilforsikring");
    // End of bilpanel
    //båteier
    private JPanel båtpanel1=new JPanel();
    private JPanel båtpanel2=new JPanel();
    private JPanel båtpanel3=new JPanel();
    
    
    private JPanel båteierp=new JPanel();
    private JPanel båtregp=new JPanel();
    private JPanel båttp=new JPanel();
    private JPanel båtmp=new JPanel();
    private JPanel båtårp=new JPanel();
    private JPanel båtlengdep=new JPanel();
    private JPanel båtmotorp=new JPanel();
    private JPanel båthkp=new JPanel();
    private JPanel båtpremiep=new JPanel();
    private JPanel båtbeløpp=new JPanel();
    
    private JLabel båteierlabel=new JLabel("Båt eier:");
    private JTextField båteierfield=new JTextField(10);
    private JLabel båtreglabel=new JLabel("registreringsnummer:");
    private JTextField båtregfield=new JTextField(10);
    private JLabel båttlabel=new JLabel("Båt type:");
    private JTextField båttfield=new JTextField(10);
    private JLabel båtmlabel=new JLabel("Båt modell:");
    private JTextField båtmfield=new JTextField(10);
    private JLabel båtårlabel=new JLabel("første registreringsår:");
    private JTextField båtårfield=new JTextField(4);
    private JLabel lengdelabel= new JLabel("Båtlengde (fot):");
    private JTextField lengdefield= new JTextField(4);
    private JLabel motortlabel= new JLabel("Motortype:");
    private JTextField motortfield= new JTextField(10);
    private JLabel motorslabel=new JLabel("Motorstyrke (HK):");
    private JTextField motorsfield=new JTextField(10);
    private JLabel premielabel = new JLabel("Forsikringspremie:");
    private JTextField premiefield = new JTextField(10);
    private JLabel båtbeløplabel=new JLabel("Forsikringsbeløp:");
    private JTextField båtbeløpfield=new JTextField(10);
    private JLabel båtbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea båtbettext=new JTextArea(7,40);
    private JButton lagbåt=new JButton("tegn båtforsikring");
    //End of båtpanel
    
    //husforsikring
    private JPanel huspanel1=new JPanel();
    private JPanel huspanel2=new JPanel();
    private JPanel huspanel3=new JPanel();
    
    private JPanel hadressep=new JPanel();
    private JPanel hårp=new JPanel();
    private JPanel htypep=new JPanel();
    private JPanel hbyggmp=new JPanel();
    private JPanel hstandardp=new JPanel();
    private JPanel hkvadratp=new JPanel();
    private JPanel hbbeløpp=new JPanel();
    private JPanel hinnbeløpp=new JPanel();
    private JPanel hhusbeløpp=new JPanel();
    
    
    private JLabel hadresselabel=new JLabel("Husadresse");
    private JTextField hadressefield=new JTextField(10);
    private JLabel byggårlabel=new JLabel("Byggeår:");
    private JTextField byggårfield=new JTextField(10);
    private JLabel boligtypelabel=new JLabel("Bolig type:");
    private JTextField boligtypefield=new JTextField(10);
    private JLabel byggmlabel=new JLabel("Byggmateriale:");
    private JTextField byggmfield=new JTextField(10);
    private JLabel standardlabel=new JLabel("Standard:");
    private JTextField standardfield=new JTextField(4);
    private JLabel kvadratlabel= new JLabel("Antall kvadratmeter:");
    private JTextField kvadratfield= new JTextField(4);
    private JLabel byggbeløplabel= new JLabel("Forsikringsbeløp bygning:");
    private JTextField byggbeløpfield= new JTextField(140);
    private JLabel innbobeløplabel=new JLabel("Innboforsikrings beløp:");
    private JTextField innbofield=new JTextField(10);
    private JLabel husbeløplabel = new JLabel("Forsikringsbeløp:");
    private JTextField husbeløpfield = new JTextField(10);
    private JLabel husbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea husbettext=new JTextArea(7,40);
    private JButton laghus=new JButton("tegn husforsikring");
    //End of husforsikring
    //Fritidsboligforsikring
    private JPanel fritidpanel1=new JPanel();
    private JPanel fritidpanel2=new JPanel();
    private JPanel fritidpanel3=new JPanel();
    
    private JPanel fadressep=new JPanel();
    private JPanel fårp=new JPanel();
    private JPanel ftypep=new JPanel();
    private JPanel fbyggmp=new JPanel();
    private JPanel fstandardp=new JPanel();
    private JPanel fkvadratp=new JPanel();
    private JPanel fbbeløpp=new JPanel();
    private JPanel finnbeløpp=new JPanel();
    private JPanel futleiep=new JPanel();
    private JPanel fhusbeløpp=new JPanel();
    private JPanel fpremiep=new JPanel();
    
    private JLabel fAdresselabel=new JLabel("Fritidsbolig adresse:");
    private JTextField fAdressefield=new JTextField(10);
    private JLabel fByggårlabel=new JLabel("Byggeår:");
    private JTextField fByggårfield=new JTextField(10);
    private JLabel fBoligtypelabel=new JLabel("Bolig type:");
    private JTextField fboligtypefield=new JTextField(10);
    private JLabel fbyggmlabel=new JLabel("Byggmateriale:");
    private JTextField fbyggmfield=new JTextField(10);
    private JLabel fstandardlabel=new JLabel("Standard:");
    private JTextField fstandardfield=new JTextField(4);
    private JLabel fkvadratlabel= new JLabel("Antall kvadratmeter:");
    private JTextField fkvadratfield= new JTextField(4);
    private JLabel fbyggbeløplabel= new JLabel("Forsikringsbeløp bygning:");
    private JTextField fbyggbeløpfield= new JTextField(5);
    private JLabel fInnbobeløplabel=new JLabel("Innboforsikrings beløp:");
    private JTextField fInnbofield=new JTextField(6);
    private JLabel utleie = new JLabel("Utleie");
    private String[] utleievalg = {"Ja","Nei"};
    private JComboBox utleiefield = new JComboBox(utleievalg);
    private JLabel fPremielabel=new JLabel("Forsikringspremie:");
    private JTextField fPremiefield=new JTextField(10);
    private JLabel fHusbetingelser=new JLabel("Forsikringsbetingelser:");
    private JTextArea fHusbettext=new JTextArea(7,40);
    private JButton fLaghus=new JButton("tegn fritidsboligforsikring");
    //End of Fritidsboligforsikring
    
    //Reiseforsikring
    private JPanel reisepanel1=new JPanel();
    private JPanel reisepanel2=new JPanel();
    private JPanel reisepanel3=new JPanel();
    
    private JPanel rområdep=new JPanel();
    private JPanel rforsikringsump=new JPanel();
    private JPanel rpremiep=new JPanel();
    private JPanel rbeløpp=new JPanel();
    
    private JLabel områdelabel = new JLabel("Forsikringsområde");
    private JTextField områdefield = new JTextField(10);
    private JLabel rpremielabel = new JLabel("Forsikringspremie:");
    private JTextField rpremiefield = new JTextField(10);
    private JLabel rbeløplabel = new JLabel("Forsikringsbeløp");
    private JTextField rbeløpfield = new JTextField(10);
    private JLabel rbetingelserlabel = new JLabel("Forsikringsbetingelser:");
    private JTextArea rbetingelsertext = new JTextArea(10,40);
    private JButton lagreise = new JButton("tegn reiseforsikring");
    // End of reiseforsikring
    //andre tab
    private JPanel kundepanel=new JPanel();
    private JPanel m2=new JPanel();
    private JPanel k2=new JPanel();
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
    private JScrollPane fscroll=new JScrollPane();
    private JPanel søkNord=new JPanel();
    private JLabel søklabel =new JLabel("Søk:");
    private JTextField søkefelt=new JTextField(20);
    private JButton søkButton=new JButton("Finn kunde");
    private JTextArea output2=new JTextArea(20,40);
    private JList<String> forsikringsliste=new JList<>();
    private JButton deaktiver=new JButton ("Deaktiver forsikring");
    
    
    // Intekter og utgifter
    private JPanel innutpanel= new JPanel();
    private Inntektstabell inn;
    private JTable inntabell;
    private Utgiftstabell utgift;
    private JTable uttabell;
    private JPanel innpanel=new JPanel();
    private JPanel utpanel=new JPanel();
    private JPanel sumpanel=new JPanel();
    
    //skademeldings tabell
    private Tabell modell;
    private JTable tabell;
    
    
    private Kommandolytter lytter;
    private TableModelListener endring;
    public Vindu()
    {
        super("Forsikringsvindu");
        // Leser kundedata fra fil
        lesFil();
        modell = new Tabell(register.get2dSkade());
        tabell = new JTable(modell);
        //Legger til museklikklyttere
        modell.addTableModelListener(endring);
        tabell.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        try{
            JTable target = (JTable)e.getSource();
            int row = target.getSelectedRow();
            int column = target.getSelectedColumn();
            int nummer=(int)tabell.getValueAt(row, 7);
            if (column==5) //Henter skademelding hvis kolonnen er lik 5.
            {
                Skademelding[] s=register.getSkademeldinger();

                for (int i=0; i<s.length;i++)
                {
                    if(s[i].getSkadenummer()==nummer)
                    {
                        JOptionPane.showMessageDialog(null,s[i].getBildet());

                    }

                }
            }
            if (column==4)
            {
                JOptionPane.showMessageDialog(null, target.getValueAt(row, column));
            }
            }
        catch(NullPointerException npe)
        {
        }
        }});
        //legger til inntektstabell, og utgiftstabell.
        inn=new Inntektstabell(register.get2dinn());
        inntabell=new JTable(inn);
        utgift=new Utgiftstabell(register.get2dut());
        uttabell=new JTable(utgift);
        
         
        
        panel.setLayout(new BorderLayout());
        vest.setLayout(new BorderLayout());
        kundepanel.setLayout(new BorderLayout());
        midt.setLayout(new BorderLayout());
        søk.setLayout(new BorderLayout());
        skadepanel.setLayout(new BorderLayout());
        lytter = new Kommandolytter();
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JTabbedPane forsikringer=new JTabbedPane();
        Icon bil = new ImageIcon(getClass().getResource("/Ikoner/bil.png"));
        Icon båt = new ImageIcon(getClass().getResource("/Ikoner/båt.png"));
        Icon hus = new ImageIcon(getClass().getResource("/Ikoner/hus.png"));
        Icon hytte = new ImageIcon(getClass().getResource("/Ikoner/hytte.png"));
        Icon reise = new ImageIcon(getClass().getResource("/Ikoner/reise.png"));

        //Legger til tabs.
        tabbedPane.addTab("ny forsikring",null, panel, "Tegn forsikringer på kunde");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tabbedPane.addTab("ny kunde",null, kundepanel, "Legg inn ny kunde i kunderegisteret.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        tabbedPane.addTab("Søk",null, søk, "Søk blandt kunder og se diverse forsikringer som kunden har tegnet.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);

        tabbedPane.addTab("Skademeldinger",null, skadepanel, "Se, vurder og endre på skademeldinger som er blitt sendt inn.");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_4);
       
        tabbedPane.addTab("Inntekter og Utgifter",null, innutpanel, "Alle inntekter og utgifter i selskapet");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_5);
     
       
        
        forsikringer.addTab("bil forsikring",bil, bilpanel, "Tegn Bilforsikring");
        forsikringer.setMnemonicAt(0, KeyEvent.VK_1);

        forsikringer.addTab("båt forsikring",båt, båtpanel, "Tegn Båtforsikring");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_2);
        //hus
        forsikringer.addTab("hus forsikring",hus, huspanel, "Tegn Husforsikring");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_3);
        //Fritidsbolig
        forsikringer.addTab("fritidsbolig forsikring",hytte, fritidpanel, "Tegn Fritidsboligforsikring");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_4);
        //Reiseforsikring
        forsikringer.addTab("reise forsikring",reise, reisepanel, "Tegn Reiseforsikring");
        forsikringer.setMnemonicAt(1, KeyEvent.VK_5);
      
      output.setEditable(false);
      output2.setEditable(false);
      output.setPreferredSize(new Dimension(50,50));
      lagkunde.addActionListener(lytter);
      
      
      m2.add(fornavnlabel);
      m2.add(fornavnfield);
      m2.add (etternavnlabel);
      m2.add(etternavnfield);
      m2.add(adresselabel);
      m2.add(adressefield);
      m2.add(lagkunde);
      k2.add(output);
     
      ut.setEditable(false);
      
      topbutton.addActionListener(lytter);
      //v.add(knapp);
      //ø.add(l);
      top.add(toplabel);
      top.add(topfield);
      top.add(topbutton);
      mm.add(ut);
      mm.setPreferredSize(new Dimension(50,50));
      mf.add(forsikringer);
      midt.add(top, BorderLayout.NORTH);
      midt.add(mm, BorderLayout.CENTER);
      midt.add(mf, BorderLayout.SOUTH);
      vest.add(v, BorderLayout.WEST);
      vest.add(ø, BorderLayout.EAST);
      Dimension d=new Dimension(1000,300);
      bilpanel.setPreferredSize(d);
      båtpanel.setPreferredSize(d);
      huspanel.setPreferredSize(d);
      fritidpanel.setPreferredSize(d);
      reisepanel.setPreferredSize(d);
      
      LagFaner();
      
    panel.add(vest, BorderLayout.WEST);
    panel.add(midt,BorderLayout.CENTER);
      
      kundepanel.add(vest2, BorderLayout.WEST);
      kundepanel.add(m2, BorderLayout.CENTER);
      kundepanel.add(k2,BorderLayout.SOUTH);


      //Søk-fane 
      
      
      
     søkVest.add(new JScrollPane(forsikringsliste));
     forsikringsliste.setVisibleRowCount( 4 );
     forsikringsliste.setFixedCellWidth( 200 );
     forsikringsliste.setFixedCellHeight(50);
     forsikringsliste.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
     forsikringsliste.setSelectedIndex(4);
     deaktiver.setVisible(false);
     
     forsikringsliste.addListSelectionListener( new ListSelectionListener() {
       public void valueChanged( ListSelectionEvent e) //Sjekker om det er gjort forandringer til forsikringslisten
      {
        if ( !e.getValueIsAdjusting() )
         {
           
           int i=forsikringsliste.getSelectedIndex();
           
            ArrayList<Forsikring> forsikringer=k.getForsikringer();
            
            output2.setText(forsikringer.get(i).toString());
            deaktiver.setVisible(true);
           
           
         }
       }
     });
     //Legger til søke felt og muselytter.
      deaktiver.addActionListener(lytter);
      søkVest.add(deaktiver);
      søkNord.add(søkefelt);
      søkNord.add(søkButton);
      søkCenter.add(new JScrollPane(output2));
      søk.add(søkVest,BorderLayout.WEST);
      søk.add(søkCenter,BorderLayout.CENTER);
      søk.add(søkNord, BorderLayout.NORTH);
      søkButton.addActionListener(lytter);
      
      
      //Skademeldings fane
      topskade.add(filter);
      skadepanel.add(topskade,BorderLayout.NORTH);
      tabell.setRowHeight(100);
      tabell.getColumnModel().getColumn(0).setMaxWidth(100);
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
      tabell.setDefaultRenderer(String.class, centerRenderer);     
      skadepanel.add(new JScrollPane(tabell), BorderLayout.CENTER);
      tabell.setAutoCreateRowSorter(true);
      
      
      innutpanel.setLayout(new BorderLayout());
      utpanel.setLayout(new BorderLayout());
      innpanel.setLayout(new BorderLayout());
      innutpanel.add(innpanel, BorderLayout.PAGE_START);
      innutpanel.add(utpanel, BorderLayout.CENTER);
      
      JLabel inntittell;
      JLabel uttittell;
     innpanel.add(inntittell= new JLabel("Inntektstabell"), BorderLayout.NORTH);
     innpanel.add(new JScrollPane(inntabell));
     innpanel.setPreferredSize(new Dimension(100,150));
     utpanel.add(uttittell= new JLabel("Utgiftstabell"), BorderLayout.NORTH);
     utpanel.add(new JScrollPane(uttabell));
     utpanel.setPreferredSize(new Dimension(100,150));
     Font font = inntittell.getFont();
    // same font but bold
    Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
     
     inntittell.setFont(boldFont);
     uttittell.setFont(boldFont);
      p.add(tabbedPane);
      
      f.add(p);
      
      f.pack();
      f.setVisible(true);
      f.setResizable(false);
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
    //Lager faner til de forskjellige forsikringene.
    public void LagFaner()
    {
        //bilpanel
        bilpanel.setLayout(new BorderLayout());
        bilpanel.add(bilpanel1, BorderLayout.NORTH);
        bilpanel1.setLayout(new GridLayout(2,4));
        bilpanel.add(bilpanel2, BorderLayout.CENTER);
       
        
        bilpanel1.add(bileierp);
        bilpanel1.add(bilregp);
        bilpanel1.add(biltp);
        bilpanel1.add(bilmp);
        
        bilpanel1.add(bilårp);
        bilpanel1.add(bilkjørep);
        bilpanel1.add(bilpremie);
        bilpanel1.add(bilbeløpp);
        
        
        bilpanel.add(bilpanel3, BorderLayout.SOUTH);
        
        bileierp.add(eierlabel);
        bileierp.add(eierfield);
        bilregp.add(reglabel);
        bilregp.add(regfield);
        biltp.add(btlabel);
        biltp.add(btfield);
        bilmp.add(bmlabel);
        bilmp.add(bmfield);
        bilårp.add(regårlabel);
        bilårp.add(regårfield);
        bilkjørep.add(kjørelabel);
        bilkjørep.add(kjørefield);
        bilpremie.add(bpremielabel);
        bilpremie.add(bpremiefield);
        bilbeløpp.add(bilbeløplabel);
        bilbeløpp.add(bilbeløpfield);
        
        bilpanel2.add(new JScrollPane(bilbettext));
        bilpanel3.add(lagbil);
        lagbil.addActionListener(lytter);
        bilbettext.setLineWrap(true);
        Border bilramme=BorderFactory.createLineBorder(Color.BLACK);
        Border biltittel=BorderFactory.createTitledBorder(bilramme, "Forsikringsbetingelser");
        bilbettext.setBorder(biltittel);
        
        
        //båtpanel
        båtpanel.setLayout(new BorderLayout());
        båtpanel.add(båtpanel1, BorderLayout.NORTH);
        båtpanel1.setLayout(new GridLayout(3,3));
        båtpanel.add(båtpanel2, BorderLayout.CENTER);
        
        båtpanel.add(båtpanel3, BorderLayout.SOUTH);
        
        båtpanel1.add(båteierp);
        båtpanel1.add(båtregp);
        båtpanel1.add(båttp);
        båtpanel1.add(båtmp);
        båtpanel1.add(båtårp);
        båtpanel1.add(båtlengdep);
        båtpanel1.add(båtmotorp);
        båtpanel1.add(båthkp);
        båtpanel1.add(båtpremiep);
        båtpanel1.add(båtbeløpp);
        
        
        båteierp.add(båteierlabel);
        båteierp.add(båteierfield);
        båtregp.add(båtreglabel);
        båtregp.add(båtregfield);
        båttp.add(båttlabel);
        båttp.add(båttfield);
        båtmp.add(båtmlabel);
        båtmp.add(båtmfield);
        båtårp.add(båtårlabel);
        båtårp.add(båtårfield);
        båtlengdep.add(lengdelabel);
        båtlengdep.add(lengdefield);
        båtmotorp.add(motortlabel);
        båtmotorp.add(motortfield);
        båthkp.add(motorslabel);
        båthkp.add(motorsfield);
        båtpremiep.add(premielabel);
        båtpremiep.add(premiefield);
        båtbeløpp.add(båtbeløplabel);
        båtbeløpp.add(båtbeløpfield);
        
        
        båtpanel2.add(new JScrollPane(båtbettext));
        båtpanel3.add(lagbåt);   
        
        lagbåt.addActionListener(lytter);
        båtbettext.setLineWrap(true);
        
        Border båtramme=BorderFactory.createLineBorder(Color.BLACK);
        Border båttittel=BorderFactory.createTitledBorder(bilramme, "Forsikringsbetingelser");
        båtbettext.setBorder(biltittel);
        båtpanel2.add(new JScrollPane(båtbettext));
        
        
        // Husforsikring
        huspanel.setLayout(new BorderLayout());
        huspanel.add(huspanel1, BorderLayout.NORTH);
        huspanel1.setLayout(new GridLayout(3,3));
        huspanel.add(huspanel2, BorderLayout.CENTER);
        huspanel.add(huspanel3, BorderLayout.SOUTH);
        
        
        hadressep.add(hadresselabel);
        hadressep.add(hadressefield);
        hårp.add(byggårlabel);
        hårp.add(byggårfield);
        htypep.add(boligtypelabel);
        htypep.add(boligtypefield);
        hbyggmp.add(byggmlabel);
        hbyggmp.add(byggmfield);
        hstandardp.add(standardlabel);
        hstandardp.add(standardfield);
        hkvadratp.add(kvadratlabel);
        hkvadratp.add(kvadratfield);
        hbbeløpp.add(byggbeløplabel);
        hbbeløpp.add(byggbeløpfield);
        hinnbeløpp.add(innbobeløplabel);
        hinnbeløpp.add(innbofield);
        
        huspanel1.add(hadressep);
        huspanel1.add(hårp);
        huspanel1.add(htypep);
        huspanel1.add(hbyggmp);
        huspanel1.add(hstandardp);
        huspanel1.add(hkvadratp);
        huspanel1.add(hbbeløpp);
        huspanel1.add(hinnbeløpp);
        
        huspanel2.add(new JScrollPane(husbettext));
        huspanel3.add(laghus);
        laghus.addActionListener(lytter);
        
        husbettext.setLineWrap(true);
        
        Border husramme=BorderFactory.createLineBorder(Color.BLACK);
        Border hustittel=BorderFactory.createTitledBorder(husramme, "Forsikringsbetingelser");
        husbettext.setBorder(hustittel);
        
        
        // End of husforsikring
        // Fritidsbolig forsikring
        fritidpanel.setLayout(new BorderLayout());
        fritidpanel.add(fritidpanel1, BorderLayout.NORTH);
        fritidpanel1.setLayout(new GridLayout(3,4));
        fritidpanel.add(fritidpanel2, BorderLayout.CENTER);
        fritidpanel.add(fritidpanel3, BorderLayout.SOUTH);

        fadressep.add(fAdresselabel);
        fadressep.add(fAdressefield);
        fårp.add(fByggårlabel);
        fårp.add(fByggårfield);
        ftypep.add(fBoligtypelabel);
        ftypep.add(fboligtypefield);
        fbyggmp.add(fbyggmlabel);
        fbyggmp.add(fbyggmfield);
        fstandardp.add(fstandardlabel);
        fstandardp.add(fstandardfield);
        fkvadratp.add(fkvadratlabel);
        fkvadratp.add(fkvadratfield);
        fbbeløpp.add(fbyggbeløplabel);
        fbbeløpp.add(fbyggbeløpfield);
        finnbeløpp.add(fInnbobeløplabel);
        finnbeløpp.add(fInnbofield);
        futleiep.add(utleie);
        futleiep.add(utleiefield);
        fpremiep.add(fPremielabel);
        fpremiep.add(fPremiefield);
        
        fritidpanel1.add(fadressep);
        fritidpanel1.add(fårp);
        fritidpanel1.add(ftypep);
        fritidpanel1.add(fbyggmp);
        fritidpanel1.add(fstandardp);
        fritidpanel1.add(fkvadratp);
        fritidpanel1.add(fbbeløpp);
        fritidpanel1.add(finnbeløpp);
        fritidpanel1.add(futleiep);
        fritidpanel1.add(fpremiep);
       
        utleiefield.setSelectedIndex(1);
     
        fritidpanel2.add(new JScrollPane(fHusbettext));
        fHusbettext.setLineWrap(true);
        
        fritidpanel3.add(fLaghus);
        fHusbettext.setBorder(hustittel);
        fLaghus.addActionListener(lytter);
        // End of fritidsbolig forsikring
        // ReiseForsikring
        reisepanel.setLayout(new BorderLayout());
        reisepanel.add(reisepanel1,BorderLayout.NORTH);
        reisepanel1.setLayout(new GridLayout(2,2));
        reisepanel.add(reisepanel2,BorderLayout.CENTER);
        reisepanel.add(reisepanel3,BorderLayout.SOUTH);
        
        rområdep.add(områdelabel);
        rområdep.add(områdefield);
        rpremiep.add(rpremielabel);
        rpremiep.add(rpremiefield);
        rbeløpp.add(rbeløplabel);
        rbeløpp.add(rbeløpfield);
        
        reisepanel1.add(rområdep);
        reisepanel1.add(rforsikringsump);
        reisepanel1.add(rpremiep);
        reisepanel1.add(rbeløpp);
        
        
        reisepanel2.add(new JScrollPane(rbetingelsertext));
        reisepanel3.add(lagreise);
        rbetingelsertext.setLineWrap(true);
        lagreise.addActionListener(lytter);
        rbetingelsertext.setBorder(hustittel);
        // End of Reiseforsikring
        
    }
    //Metode for å sjekke regex.
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
        try
        {
            String fornavn=fornavnfield.getText();
            if(!match(regexNavn,fornavn))
            {
                output.setText("Feil i fornavn felt, vennligst bruk kun bokstaver (maks 15 tegn)");
                output.append("\nVennligst prøv igjen");
                return;
            }
            String etternavn = etternavnfield.getText();
            if(!match(regexNavn,etternavn))
            {
                output.setText("Feil i etternavn felt, vennligst bruk kun bokstaver (maks 15 tegn)");
                output.append("\nVennligst prøv igjen");
                return;
            }
            String adresse = adressefield.getText();
            if(!match(regexAdresse, adresse))
            {
                output.setText("Feil i adresse felt, spesialtegn er ikke lov kun bokstaver og tall (maks 30 tegn)");
                output.append("\nVennligst prøv igjen");
                return;
            }
            int ok2 =register.nyKunde(fornavn,etternavn,adresse);
            if(ok2 > 0)
            {
                output.setText("Kunde er registert med kundenummer : "+ok2);
                fornavnfield.setText("");
                etternavnfield.setText("");
                adressefield.setText("");
            }
            else
                output.setText("Kunde kunne ikke opprettes, prøv igjen");
        }
        catch(NumberFormatException | NullPointerException nfe)
        {
            output.setText("Feil i innput, prøv igjen");
        }
        
    }
    public void finnForsikringer(Kunde k) //Finner forsikringer og forsikringstype
    {
        try
        {
        ArrayList<Forsikring> forsikringer=k.getForsikringer();
        String[] s=new String[forsikringer.size()];
        for (int i = 0; i < forsikringer.size(); i++) 
        {
		s[i]=(String)forsikringer.get(i).getType();   
        }
            forsikringsliste.setListData(s);
            forsikringsliste.setVisibleRowCount(6);
        }
        catch(ArrayIndexOutOfBoundsException inde)
        {
            
        }
       
    }
    public void søkKunde() //søker på kundens sitt kunde nr, og henter ut forsikringer.
    {
        try
        {
            String kundeNr2 = søkefelt.getText();
            if(match(regexNr,kundeNr2))
            {
                int kundeNr = Integer.parseInt(kundeNr2);
                Kunde kunden1 = register.finnKundeInt(kundeNr);

                if(kunden1 !=null)
                {

                    output2.setText(kunden1.toString());
                    k=kunden1;
                    finnForsikringer(k);
                }
                else
                {
                    output2.setText("Finnes ingen kunder med dette kundenummeret");
                }
                søkefelt.setText("");
                return;
            }
            else if(match(regexNavn,kundeNr2))
            {
                Kunde kunden1 = register.finnKundeString(kundeNr2);

                if(kunden1 !=null)
                {
                    output2.setText(kunden1.toString());
                    k=kunden1;
                    finnForsikringer(k);
                }
                else
                {
                    output2.setText("Finnes ingen kunder med dette etternavnet.");
                }
                søkefelt.setText("");
            }
            else
            {
                output2.setText("Vennligst fyll inn etternavn eller kundenummer.");
            }
        }
        catch(NullPointerException | NumberFormatException npe)
        {
            output2.setText("Det skjedde en feil, vennligst prøv igjen.");
        }
        
    }
    public void Bileier() //Foreslår at eierfeltet skal være likt kundenavn. mulig og endre tilbake.
    {
        if (k!=null)
        {
          eierfield.setText(k.getNavn());  
          båteierfield.setText(k.getNavn());  
        }
        
    }
    public void finnKunde() //Finner kunde ved å søke på kundens kundenummer og henter med kundens opplysninger.
    {
        try
        {
            String kundeNr2 = topfield.getText();
            if(match(regexNr,kundeNr2))
            {
                int kundeNr = Integer.parseInt(kundeNr2);
                Kunde kunden1 = register.finnKundeInt(kundeNr);

                if(kunden1 !=null)
                {
                    ut.setText(kunden1.AlttoString());
                    k=kunden1;
                    Bileier();
                }
                else
                {
                    ut.setText("Finnes ingen kunder med dette kundenummeret");
                }
                topfield.setText("");
                return;
            }
            else if(match(regexNavn,kundeNr2))
            {
                Kunde kunden1 = register.finnKundeString(kundeNr2);

                if(kunden1 !=null)
                {
                    ut.setText(kunden1.AlttoString());
                    k=kunden1;
                    Bileier();
                }
                else
                {
                    ut.setText("Finnes ingen kunder med dette navnet.");
                }
                topfield.setText("");
            }
            else
            {
                ut.setText("Vennligst fyll inn etternavn eller kundenummer.");
            }
        }
        catch(NullPointerException | NumberFormatException npe)
        {
            ut.setText("Fella ja");
        }    
    }
    public void sendSkademelding(int k, String m, String t, String v) //Sjekker om den registrerte skademelding er true, hvis
    {                                                                 //den er true så opprettes en tabell og sender med all informasjon fra skaderarrayet
        Boolean ok=register.SendSkademelding(k, m, t, v);             //og oppdaterer tabellen.
        if (ok)
        {
        modell.opprettTabell(register.get2dSkade());
        modell.fireTableDataChanged();
    
        }
    }
    public int getSkadenummer()
    {
        return register.getSkadenummer();
    }
    public void lagreEndring() //Lagrer endringer som er gjort i tabellskader.
    {
      Object [][]  a=modell.getTabellskader();
      
      register.Endring(a);
    }
    
    /*
        Metoden har som oppgave å legge til bilforsikring hos kunden.
        Først må en kunde bli funnet via søkefeltet, deretter kan informasjonen fylles ut og registeres.
        Relevant feilhåntering er lagt til via regex og try/catch blokker.
    */
    public void lagBil()
    {
        int regår;
        int kjørelengde;
        int priskm = 1;
        int bilbeløp;
        try
        {
            String bileier = eierfield.getText();
            String regNr = regfield.getText();
            String biltype = btfield.getText();
            String bilmerke= bmfield.getText();
            String regår2 = regårfield.getText();
            String kjørelengde2= kjørefield.getText();
            String premie2 = premiefield.getText();
            String bilbeløp2 = bilbeløpfield.getText();
            String betingelser = bilbettext.getText();
            if(!match(regexFulltnavn,bileier))
            {
                ut.setText("Feil i bileier felt, kun tilatt med bokstaver(maks 40 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexRegNr,regNr))
            {
                ut.setText("Feil i registreringsnummer felt, eksempel på riktig registeringsnummer: SK05345 (små bokstaver er tilatt)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNavn,biltype))
            {
                ut.setText("Feil i biltype felt, kun bokstaver tilatt \n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexAdresse,bilmerke))
            {
                ut.setText("Feil i bilmerke felt, prøv igjen\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexRegår,regår2))
            {
                ut.setText("Feil i registeringsår felt, kun tilatt med 4 nummer\n");
                ut.append("Registering ble ikke fulført");
                return;
            }

            if(!match(regexNr,kjørelengde2))
            {
                ut.setText("Feil i kjørelengde felt, det er kun lov med nummer(maks 10 tegn)\n");
                ut.append("\nRegistering ble ikke fulført");
                return;
            }
            if(!match(regexNr,premie2))
            {
                ut.setText("Feil i forsikringspremie felt, det er kun lov med nummer(maks 10 tegn)\n");
                ut.append("\nRegistering ble ikke fulført");
                return;
            }
            if(!match(regexNr,bilbeløp2))
            {
                ut.setText("Feil i forsikringsbeløp felt, kun nummer tilatt(maks 10 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexBetingelser,betingelser))
            {
                ut.setText("Feil i betingelser felt, minimum 10 tegn og maksimum 500(ingen spesial tegn er lov) \n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            
            
            regår=Integer.parseInt(regår2);
            kjørelengde=Integer.parseInt(kjørelengde2);
            int premie = Integer.parseInt(premie2);
            bilbeløp=Integer.parseInt(bilbeløp2);
            
            Bilforsikring bil=new Bilforsikring(bileier, regNr,biltype,bilmerke,regår,
                kjørelengde,priskm,premie, bilbeløp, betingelser);
            
            Boolean ok=register.lagForsikring(k, bil);
            if(ok)
            {
                eierfield.setText("");
                regfield.setText("");
                btfield.setText("");
                bmfield.setText("");
                bilbeløpfield.setText("");
                kjørefield.setText("");
                regårfield.setText("");
                premiefield.setText("");
                bilbettext.setText("");
                ut.setText("bilforsikring ble registert på kundenummer:" + k.getForsikringsnummer());
            }
        }
        catch(NullPointerException npe)
        {
            ut.setText("Vennligst finn en kunde via søkefeltet på toppen av siden."
                    + "\nFør du prøver å registere en bil forsikring");
        }
    }
    //Deaktiverer forsikring ved å sette den til false.
    public void deaktiverf()
    {
        int i=forsikringsliste.getSelectedIndex();

        ArrayList<Forsikring> forsikringer=k.getForsikringer();
        if(forsikringer.get(i).getGyldig())
        {
            forsikringer.get(i).setGyldig(false);
            k.oppdaterKunde(); 

            output2.setText(forsikringer.get(i).toString());
            JOptionPane.showMessageDialog(null,"Forsikringen er nå deaktivert!");
        }
        else
            JOptionPane.showMessageDialog(null,"Forsikringen er allerede deaktivert!");
    }
    /*
        Metoden prøver å henter data fra input feltene i båtforsikringsvinduet.
        Hvis dette går gjennom vil båtforsikringen bli lagret på kunden.
        NB Det er krav at kunden må søkt opp via søkefeltet på toppen av siden.
        Validering av input via regex og nødvendige try/catch blokker.
    */
    public void lagBåt()
    {
        
        try
        {
            String båteier = båteierfield.getText();
            String regnr = båtregfield.getText();
            String båttype = båttfield.getText();
            String båtmodell = båtmfield.getText();
            String år2 = båtårfield.getText();
            String lengde2 = lengdefield.getText();
                    
            String motortype = motortfield.getText();
            String motorstyrke2 = motorsfield.getText();
            String premie2 = premiefield.getText();
            String beløp2 = båtbeløpfield.getText();
            String betingelser = båtbettext.getText();
            
            if(!match(regexFulltnavn,båteier))
            {
                ut.setText("Feil i båteier felt, kun tillatt med bokstaver\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexAdresse,regnr))
            {
                ut.setText("Feil i registreringnummer felt, (maks 30 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNavn,båttype))
            {
                ut.setText("Feil i båttype felt, kun lov med bokstaver (maks 15 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexAdresse,båtmodell))
            {
                ut.setText("Feil i båtmodel felt, kun lov med bokstaver og tall(maks 30 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexRegår,år2))
            {
                ut.setText("Feil i registreringår felt, kun tillatt med 4 tall\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexMotorstyrke,lengde2))
            {
                ut.setText("Feil i båtlengde felt, kun tillatt med tall(maks 4 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexAdresse,motortype))
            {
                ut.setText("Feil i motortype felt, prøv igjen(maks 25 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexMotorstyrke,motorstyrke2))
            {
                ut.setText("Feil motorstyrke felt, kun tall er lov(maks 4 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,premie2))
            {
                ut.setText("Feil forsikringspremie felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,beløp2))
            {
                ut.setText("Feil forsikringbeløp felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexBetingelser,betingelser))
            {
                ut.setText("Feil forsikringbetingelser feltet, det skal være minimum 10 og maks 500 tegn(ingen spesial tegn er lov)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            int lengde = Integer.parseInt(lengde2);
            int år = Integer.parseInt(år2);
            int motorstyrke = Integer.parseInt(motorstyrke2);
            
            int premie = Integer.parseInt(premie2);
            int beløp = Integer.parseInt(beløp2);
            Båtforsikring båt = new Båtforsikring(båteier,regnr,båtmodell,lengde,år,
                                                  motortype,motorstyrke,premie,beløp,betingelser);
            Boolean ok=register.lagForsikring(k, båt);
            if(ok)
            {
                båteierfield.setText("");
                båtregfield.setText("");
                båttfield.setText("");
                båtmfield.setText("");
                båtårfield.setText("");
                lengdefield.setText("");
                motortfield.setText("");
                motorsfield.setText("");
                premiefield.setText("");
                båtbeløpfield.setText("");
                båtbettext.setText("");
                ut.setText("Båtforsikring er opprettet hos kundenummer"+k.getForsikringsnummer());
            }
            
        }
        catch(NullPointerException npe)
        {
            ut.setText("Vennligst finn kunde i søkefeltet på toppen av siden.");
        }
    }
    /*
        Metoden prøver å henter data fra input feltene i husforsikringsvinduet.
        Hvis dette går gjennom vil husforsikringen bli lagret på kunden.
        NB Det er krav at kunden må søkt opp via søkefeltet på toppen av siden.
        Validering av input via regex og nødvendige try/catch blokker.
    */
    public void lagHus()
    {
        
        try
        {
            String adresse = hadressefield.getText();
            String byggår2 = byggårfield.getText();
            String boligtype = boligtypefield.getText();
            String byggmat = byggmfield.getText();
            String standard = standardfield.getText();
            String kvadrat2 = kvadratfield.getText();
            String byggbeløp2 = byggbeløpfield.getText();
            String innbobeløp2 = innbofield.getText();
            String betingelser = husbettext.getText();
            
            
            if(!match(regexAdresse,adresse))
            {
                ut.setText("Feil adresse feltet, kun lov med bokstaver og tall(maks 30 tegn)n\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexRegår,byggår2))
            {
                ut.setText("Feil i byggår felt, kun tillatt med 4 tall\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNavn,boligtype))
            {
                ut.setText("Feil i boligtype felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNavn,byggmat))
            {
                ut.setText("Feil i byggmateriale felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNavn,standard))
            {
                ut.setText("Feil i standard felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexMotorstyrke,kvadrat2))
            {
                ut.setText("Feil i kvaddrat felt, kun tilatt med tall(maks 4 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNr,byggbeløp2))
            {
                ut.setText("Feil byggbeløp felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,innbobeløp2))
            {
                ut.setText("Feil innbobeløfelt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexBetingelser,betingelser))
            {
                ut.setText("Feil forsikringbetingelser feltet, det skal være minimum 10 og maks 500 tegn(ingen spesial tegn er lov)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            
            int byggår = Integer.parseInt(byggår2);
            int kvadrat = Integer.parseInt(kvadrat2);
            int byggbeløp = Integer.parseInt(byggbeløp2);
            int innbobeløp = Integer.parseInt(innbobeløp2);
            int forsbeløp = innbobeløp + byggbeløp;
            
            Husforsikring hus = new Husforsikring(adresse,byggår,boligtype,byggmat,kvadrat,standard,byggbeløp,innbobeløp,forsbeløp,betingelser);
            Boolean ok = register.lagForsikring(k,hus);
            if(ok)
            {
                hadressefield.setText("");
                byggårfield.setText("");
                boligtypefield.setText("");
                byggmfield.setText("");
                standardfield.setText("");
                kvadratfield.setText("");
                byggbeløpfield.setText("");
                innbofield.setText("");
                husbettext.setText("");
               ut.setText("Husforsikring er opprettet hos kundenummer"+k.getForsikringsnummer());
            }
        }
        catch(NullPointerException npe)
        {
            ut.setText("Vennligst finn kunde i søkefeltet på toppen av siden.");
        }
    }
    /*
        Metoden prøver å henter data fra input feltene i fritidsboligforsikrings vinduet.
        Hvis dette går gjennom vil fritidsboligforsikringen bli lagret på kunden.
        NB Det er krav at kunden må søkt opp via søkefeltet på toppen av siden.
        Validering av input via regex og nødvendige try/catch blokker.
    */
    public void lagFritidsbolig()
    {
        try
        {
            String adresse = fAdressefield.getText();
            String byggår2 = fByggårfield.getText();
            String boligtype = fboligtypefield.getText();
            String byggmat = fbyggmfield.getText();
            String standard = fstandardfield.getText();
            String kvadrat2 = fkvadratfield.getText();
            String byggbeløp2 = fbyggbeløpfield.getText();
            String innbo2 = fInnbofield.getText();
            String premie2 = fPremiefield.getText();
            String betingelser = fHusbettext.getText();
            
            if(!match(regexAdresse,adresse))
            {
                ut.setText("Feil adresse feltet, kun lov med bokstaver og tall(maks 30 tegn)n\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexRegår,byggår2))
            {
                ut.setText("Feil i byggår felt, kun tillatt med 4 tall\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNavn,boligtype))
            {
                ut.setText("Feil i boligtype felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNavn,byggmat))
            {
                ut.setText("Feil i byggmateriale felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNavn,standard))
            {
                ut.setText("Feil i standard felt, kun tilatt med bokstaver(maks 20 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexMotorstyrke,kvadrat2))
            {
                ut.setText("Feil i kvadrat felt, kun tilatt med tall(maks 4 tegn)\n");
                ut.append("Registering ble ikke fulført");
                return;
            }
            if(!match(regexNr,byggbeløp2))
            {
                ut.setText("Feil byggbeløp felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,innbo2))
            {
                ut.setText("Feil innbobeløpfelt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,premie2))
            {
                ut.setText("Feil forsikringspremie felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            // Mangler for forsikringsbeløp
            if(!match(regexBetingelser,betingelser))
            {
                ut.setText("Feil forsikringbetingelser feltet, det skal være minimum 10 og maks 500 tegn(ingen spesial tegn er lov)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            
            int byggår = Integer.parseInt(byggår2);
            int kvadrat = Integer.parseInt(kvadrat2);
            int byggbeløp = Integer.parseInt(byggbeløp2);
            int innbobeløp = Integer.parseInt(innbo2);
            int premie = Integer.parseInt(premie2);
            int beløp = (innbobeløp+byggbeløp);
            Boolean utleie;
            if(utleiefield.getSelectedIndex()==0)
                utleie=true;
            else
                utleie=false;
            
            Fritidsforsikring fritid = new Fritidsforsikring(adresse,byggår,boligtype,byggmat,standard,kvadrat,byggbeløp,innbobeløp,utleie,premie,beløp,betingelser);
            Boolean ok = register.lagForsikring(k,fritid);
            if(ok)
            {
                fAdressefield.setText("");
                fByggårfield.setText("");
                fboligtypefield.setText("");
                fbyggmfield.setText("");
                fstandardfield.setText("");
                fkvadratfield.setText("");
                fbyggbeløpfield.setText("");
                fInnbofield.setText("");
                fPremiefield.setText("");
                fHusbettext.setText("");
                ut.setText("Fritidsboligforsikring er opprettet hos kundenummer"+k.getForsikringsnummer());
            }
        }
        catch(NullPointerException npe)
        {
            ut.setText("Vennligst finn kunde i søkefeltet på toppen av siden.");
        }
    }
    /*
        Metoden prøver å henter data fra input feltene i reiseforsikrings vinduet.
        Hvis dette går gjennom vil reiseforsirkngen bli lagret på kunden.
        NB Det er krav at kunden må søkt opp via søkefeltet på toppen av siden.
        Validering av input via regex og nødvendige try/catch blokker.
    */
    public void lagReise()
    {
        try
        {
            String område = områdefield.getText();
            String forspremie2 = rpremiefield.getText();
            String forsbeløp2 = rbeløpfield.getText();
            String betingelser = rbetingelsertext.getText();
            
            if(!match(regexNavn,område))
            {
                ut.setText("Feil i område felt, kun tillatt med bokstaver\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,forspremie2))
            {
                ut.setText("Feil forsirkingspremie felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexNr,forsbeløp2))
            {
                ut.setText("Feil forsirkingbeløp felt, kun tall er lov(maks 10 tegn)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            if(!match(regexBetingelser,betingelser))
            {
                ut.setText("Feil forsikringbetingelser feltet, det skal være minimum 10 og maks 500 tegn(ingen spesial tegn er lov)\n");
                ut.append("Registrering ble ikke fullført");
                return;
            }
            int forspremie = Integer.parseInt(forspremie2);
            int forsbeløp = Integer.parseInt(forsbeløp2);
            
            Reiseforsikring reise = new Reiseforsikring(område,forspremie,forsbeløp,betingelser);
            Boolean ok = register.lagForsikring(k,reise);
            if(ok)
            {
                områdefield.setText("");
                rpremiefield.setText("");
                rbeløpfield.setText("");
                rbetingelsertext.setText("");
                ut.setText("Reiseforsikring er opprettet hos kundenummer"+k.getForsikringsnummer());
            }
        }
        catch(NullPointerException npe)
        {
            ut.setText("Vennligst finn kunde i søkefeltet på toppen av siden.");
        }
    }
    // Legger til lyttere for de forskjellige knappene.
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
            lagBil();
          else if(e.getSource()==lagbåt)
            lagBåt();
          else if(e.getSource()==laghus)
            lagHus();
          else if(e.getSource()==fLaghus)
            lagFritidsbolig();
          else if(e.getSource()==lagreise)
            lagReise();
          else if(e.getSource()==deaktiver)
            deaktiverf();
            
          inn.opprettTabell(register.get2dinn());
        }
    }
    
     
    //Viser melding om feil, hvis det oppstår en feil i programmet.
     private void visFeilmelding(String melding)
    {
      JOptionPane.showMessageDialog(this, melding,
              "Problem", JOptionPane.ERROR_MESSAGE);
    }
    /*
        Metoden blir kalt opp hver gang programmet starter og blir lagret i minne.
        Metoden har som ansvar for å lese filen liste.data, som skal inneholde all data om kundene i systemet.
        Hvis den er tom, eller andre feil, vil den automatisk bli opprettet første gang.
        I tillegg er det lagt til try/catch blokker for feilbehandling.
    */ 
    public void lesFil()
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream( "liste.data" )))
        {
            register = (Kunderegister) innfil.readObject();
            register.Start();
        }
        catch(ClassNotFoundException cnfe)
        {
            ut.setText(cnfe.getMessage());
            ut.append("\nOppretter tom liste.\n");
            register = new Kunderegister();
            register.Start();
        }
        catch(FileNotFoundException fne)
        {
            ut.setText("Finner ikke datafil. Oppretter tom liste.\n");
            register = new Kunderegister();
            register.Start();
        }
       catch(IOException ioe)
        {
            ut.setText("Innlesingsfeil. Oppretter tom liste.\n");
            register = new Kunderegister();
            register.Start();
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
             new FileOutputStream("liste.data")))
        {
            lagreEndring();
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

