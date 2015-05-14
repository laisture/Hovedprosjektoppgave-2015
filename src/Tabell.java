
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
class Tabell extends AbstractTableModel
    {
     private Object[][] tabellskader;
    
     
     public Tabell(Object[][] t)
        {
            tabellskader=t;
        }
       public static final int ERSTATNINGSKOLONNE = 3;
       public static final int BILDEKOLONNE = 5;
        
        private String[] kolonnenavn =
        {
           "KundeID", "Skadetype", "Dato", "Utbetalt erstatning", "Skademelding","Bilder", "Sjekket", "Skadenr"
        };
            
        public String getColumnName( int kolonne )
        {
            return kolonnenavn[ kolonne];
        }
        public Class getColumnClass(int column){
        Object value=this.getValueAt(0,column);
        return (value==null?Object.class:value.getClass());
        }
        public int getColumnCount()
        {
            return tabellskader[ 0].length;
        }
        public int getRowCount()
        {
            return tabellskader.length;
        }
        public Object getValueAt(int rad, int kolonne)
    {
      return tabellskader[ rad][ kolonne];
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
