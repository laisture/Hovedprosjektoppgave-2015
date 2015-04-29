package Vindu;

import javax.swing.*;
import java.awt.*;
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
   
     JFrame f=new JFrame();
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
    
   
    
    
    public Vindu()
    {
      super("Hallo");
      panel.setLayout(new BorderLayout());
      vest.setLayout(new BorderLayout());
      kundepanel.setLayout(new BorderLayout());
      
      
       
      ImageIcon icon = new ImageIcon(
            getClass().getResource("Ikon.png"));
      
      JTabbedPane tabbedPane = new JTabbedPane();

    
     tabbedPane.addTab("ny forsikring",null, panel, "Does nothing");
     tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
      
      tabbedPane.addTab("ny kunde",null, kundepanel, "Does nothing");
     tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
      
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
      
      
      
      
      
      v.add(knapp);
      ø.add(l);
      
      vest.add(v, BorderLayout.WEST);
      vest.add(ø, BorderLayout.EAST);
      
      panel.add(vest, BorderLayout.WEST);
     
      kundepanel.add(vest2, BorderLayout.WEST);
      kundepanel.add(m2, BorderLayout.CENTER);
              
      
      
      f.add(tabbedPane);
      f.pack();
      f.setVisible(true);
      //f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
         
    
}