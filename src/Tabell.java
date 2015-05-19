
import java.io.Serializable;
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
public class Tabell extends AbstractTableModel implements Serializable
    {
     private Object[][] tabellskader;
    
     
     public Tabell(Object[][] t)
        {
            opprettTabell(t);
        }
     //Oppretter tabell objektet.
     public void opprettTabell(Object[][] t)
     {
         tabellskader=t;
     }
       public static final int ERSTATNINGSKOLONNE = 3;
       public static final int BILDEKOLONNE = 5;
        
        private String[] kolonnenavn =
        {
           "KundeID", "Skadetype", "Dato", "Utbetalt erstatning", "Skademelding","Bilder", "Sjekket", "Skadenr"
        };
        //Finner kolonne navnet.
        public String getColumnName( int kolonne )
        {
            return kolonnenavn[ kolonne];
        }
        //Henter kolonneklassen
        public Class getColumnClass(int column){
        Object value=this.getValueAt(0,column);
        
       return column == 6 ? Boolean.class : super.getColumnClass(column);
        //Get metoder.
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
        
        
     
        //Sjekker og gjør at tabell feltene er redigerbar.
        public boolean isCellEditable(int rad, int kolonne )
        {
            
            if(kolonne==3||kolonne==6)
            {
                return true;
            }
            return false;
        }
        
        public void setValueAt( Object nyVerdi, int rad, int kolonne )
        {
            tabellskader[ rad][ kolonne] = nyVerdi;
            LagreEndring(nyVerdi, rad, kolonne);
        }//Lagrer endringer gjort til tabellen.
       public void LagreEndring(Object n, int r, int k)
       {
           int sn=(int)getValueAt(r,7);
           for (int i=0; i<tabellskader.length;i++)
           {
               if (tabellskader[i][7]!=null &&(int)tabellskader[i][7]==sn)
               {
                   tabellskader[i][k]=n;
               }
           }
       }
       public Object[][] getTabellskader()
       {
           return tabellskader;
       }
}
