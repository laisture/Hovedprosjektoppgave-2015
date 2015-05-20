
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Filen inneholder tabellen for ugifter hos kundene, med metoder, for å hente informasjon og lagre informasjon på tabellen.
 * Hensikten med klassen er å opprette en tabell med forsikringstype og beløp, som kan bli brukt til selskapets utgifter.
 * Siste edit: 19.05.15
 * @author Joakim
 */
class Utgiftstabell extends AbstractTableModel
    {
     private Object[][] utgifter;
    
     
     public Utgiftstabell(Object[][] t)
        {
            utgifter=t;
        }
       public static final int ERSTATNINGSKOLONNE = 3;
        
        private String[] kolonnenavn =
        {
           "forsikringstype","beløp"
        };
        //Henter kolonnenavnet.
        public String getColumnName( int kolonne )
        {
            return kolonnenavn[ kolonne];
        }
        //Henter kolonneklassen
        public Class getColumnClass(int column){
        Object value=this.getValueAt(0,column);
        return (value==null?Object.class:value.getClass());
        }
        //Get metoder.
        public int getColumnCount()
        {
            return utgifter[ 0].length;
        }
        public int getRowCount()
        {
            return utgifter.length;
        }
        public Object getValueAt(int rad, int kolonne)
        {
            return utgifter[ rad][ kolonne];
        }
        //Sjekker og gjør at tabell feltene er redigerbar.
        public boolean istabellskaderEditable(int rad, int kolonne )
        {
            return kolonne == ERSTATNINGSKOLONNE;
        }
        //Forandrer verdiene til tabellens rad og kolonne.
        public void setValueAt( Object nyVerdi, int rad, int kolonne )
        {
            utgifter[ rad][ kolonne] = nyVerdi;
        }
        
}
