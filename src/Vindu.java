


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
    private JPanel panel=new JPanel();
    private JPanel kundepanel=new JPanel();
    private JPanel top;
    private JPanel vest=new JPanel();
    private JPanel v=new JPanel();
    private JPanel ø=new JPanel();
    private JButton knapp=new JButton("test!");
    private JPanel midt=new JPanel();
    
    
    
    private JPanel m2=new JPanel();
    private JPanel vest2=new JPanel();
    private JLabel fornavnlabel=new JLabel("Fornavn:");
    private JTextField fornavnfield=new JTextField(30);
    private JLabel etternavnlabel=new JLabel("Etternavn:");
    private JTextField etternavnfield=new JTextField(15);
    private JLabel adresselabel=new JLabel("Faktura adresse:");
    private JTextField adressefield=new JTextField(15);
    private JButton lagkunde=new JButton("registrer kunde");
    private JTextArea output=new JTextArea(40,40);
    private Kommandolytter lytter;
    //Søk
    private JPanel søk =new JPanel();
    private JPanel søkVest =new JPanel();
    private JPanel søkCenter =new JPanel();
    private JLabel søklabel =new JLabel("Søk:");
    private JTextField søkefelt=new JTextField(20);
    private JButton søkButton=new JButton("Finn kunde");
    private JTextArea output2=new JTextArea(40,40);
    
    public Vindu()
    {
      super("Hallo");
      panel.setLayout(new BorderLayout());
      vest.setLayout(new BorderLayout());
      kundepanel.setLayout(new BorderLayout());
      søk.setLayout(new BorderLayout());
       lytter = new Kommandolytter();
       
     
      
      JTabbedPane tabbedPane = new JTabbedPane();

    
     tabbedPane.addTab("ny forsikring",null, panel, "Does nothing");
     tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
      
      tabbedPane.addTab("ny kunde",null, kundepanel, "Does nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
     //Bil
     tabbedPane.addTab("Søk",null, søk, "Does nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);
      
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
      
      v.add(knapp);
      ø.add(l);
      
      vest.add(v, BorderLayout.WEST);
      vest.add(ø, BorderLayout.EAST);
      
      panel.add(vest, BorderLayout.WEST);
     
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
        }
        else
        {
            output2.setText("Finnes ingen kunder med dette kundenummeret");
        }
        søkefelt.setText("");
        
    }
    
    
   private class Kommandolytter implements ActionListener
  {
       
   
    @Override
    public void actionPerformed( ActionEvent e )
    {
        System.out.println("test");
      if ( e.getSource() == lagkunde )
        LagKunde();
      else if(e.getSource() == søkButton )
          søkKunde();
    }

        
  }  
}
