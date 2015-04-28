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
    public Vindu()
    {
        super("Hallo i lukken");
        
        String[] a = {"hallo","hallo2","en til"};
        layout = new BorderLayout(5,5);
        c = getContentPane();
        c.setLayout(layout);
        //c.add();
       
        JList<String> v = new JList<>(a);
        v.setVisibleRowCount(2);
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
        c.add(v, BorderLayout.LINE_START);
        c.add( new JScrollPane(v));
    } //End of konstruktør
    /*
    public void actionPerformed(ActionEvent event)
    {
        
    }*/
    
} //End of class
