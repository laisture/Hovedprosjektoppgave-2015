package Vindu;

import javax.swing.*;
import java.awt.*;
//import javax.swing.event.*;

/**
 *
 * @author Jules
 */
public class Vindu extends JFrame
{
    private BorderLayout layout;
    private Container c;
    //private JFrame f;
    public Vindu()
    {
        super("Hallo i lukken");
        
        //p = new JPanel();
        String[] a = {"hallo","hallo2","en til"};
        layout = new BorderLayout(5,5);
        //c = getContentPane();
        setLayout(layout);
        //f = new JFrame();
       
        JList<String> v = new JList<>(a);
        v.setVisibleRowCount(3);
        v.setFixedCellWidth(50);
        v.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        v.setSelectedIndex(4);
        /*v.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if( !e.getValueIsAdjusting() )
                {
                    String velger = v.getSelectedValue();
                    // get info
                }
            }
        });*/
        add(v, BorderLayout.LINE_START);
        add( new JScrollPane(v));
        setSize(300,400);
        add(new JTextArea(), BorderLayout.CENTER);
    } //End of konstruktør
    /*
    public void actionPerformed(ActionEvent event)
    {
        
    }*/
    
} //End of class
