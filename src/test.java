
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Kunderegister register= new Kunderegister();
        //SkademeldingVindu vinduetd = new SkademeldingVindu();
       // Boolean ok = register.k.totalKunde();
        EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                JFrame vindutest = new Tabell();
                vindutest.setVisible(true);
            }
        });
       
			
		
                            final Vindu frame= new Vindu();
                            
			
		
        
    }
    class Tabell
    {
        public static final int ERSTATNINGSKOLONNE = 0;
        
        private String[] kolonnenavn =
        {
           "KundeID", "Skadetype", "Dato", "Antallskader", "Erstatningskostnad", "Skademelding", "Bilde"
        };
        private Object[][] tabellskader =
        {
            {
                
            }
        }
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
    class TabellFrame extends JFrame
    {
        public TabellFrame(JTextField textField)
        {
            setTitle("Statistikk modell");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Tabell modell = new Tabell();
            JTable tabell = new JTable(modell);
            sjekkboks = new JCheckBox("");
            tabell.setRowHeight(100);
            textField  = new JTextField(7);
            Container c = getContentPane();
            c.add(new JScrollPane(tabell), BorderLayout.CENTER);
            tabell.setAutoCreateRowSorter(true);
            
        }
    }
    
}
