
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
class Utgiftstabell extends AbstractTableModel
    {
     private Object[][] inntekter;
    
     
     public Utgiftstabell(Object[][] t)
        {
            inntekter=t;
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
        public int getColumnCount()
        {
            return inntekter[ 0].length;
        }
        public int getRowCount()
        {
            return inntekter.length;
        }
        public Object getValueAt(int rad, int kolonne)
    {
      return inntekter[ rad][ kolonne];
    }
        //Sjekker og gjør at tabell feltene er redigerbar.
        public boolean istabellskaderEditable(int rad, int kolonne )
        {
            return kolonne == ERSTATNINGSKOLONNE;
        }
        public void setValueAt( Object nyVerdi, int rad, int kolonne )
        {
            inntekter[ rad][ kolonne] = nyVerdi;
        }
        
}