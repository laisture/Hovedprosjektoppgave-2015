
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
        Kunderegister register= new Kunderegister();
        SkademeldingVindu vinduetd = new SkademeldingVindu();
        Boolean ok = register.k.totalKunde();
        
       
			
		
                            final SkademeldingVindu skadevindu= new SkademeldingVindu();
                            
			
		
        
    }
   
   class TabellFrame extends JFrame
   {
       public TabellFrame()
       {
            setTitle("Statistikk modell");
           setSize(500, 500);
           JComboBox<Integer> utbetalt = new JComboBox<>();
           int min=0; int max=100000000;
           for(int i=min; i<=max; i++)
           {
               utbetalt.addItem(new Integer(i));
           }
           JTable tabell = new JTable();
           tabell.setAutoCreateRowSorter(true);
        TableCellEditor utbetalteditor = new DefaultCellEditor(utbetalt);
      //Installerer editoren for månekolonnen.
        TableColumnModel kolonnemodell = tabell.getColumnModel();
        TableColumn utbetaltkolonne =
        kolonnemodell.getColumn(Tabell.ERSTATNINGSKOLONNE);
        utbetaltkolonne.setCellEditor(utbetalteditor);
           
           
            
          
       }
    }
    
}
