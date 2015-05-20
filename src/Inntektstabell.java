
import javax.swing.table.AbstractTableModel;

/**
 * Filen inneholder tabell over Forsikring og beløp.
 * Hensikten med klassen er å lage en tabell som inneholder forsikringstype og beløp.
 * Siste edit: 19.05.15
 * @author Joakim
 */
class Inntektstabell extends AbstractTableModel 
    {
     private Object[][] inntekter;
    
     
     public Inntektstabell(Object[][] t)
        {
            opprettTabell(t);
        }
     public void opprettTabell(Object[][] t)// oppretter inntekts tabell.
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
        //Henter kolonneklassen.
        public Class getColumnClass(int column){
        Object value=this.getValueAt(0,column);
        return (value==null?Object.class:value.getClass());
        }
        //Get metoder.
        public int getColumnCount()
        {
            return inntekter[ 0].length;
        }
        public int getRowCount()
        {
            return inntekter.length;
        }
        public Object getValueAt(int rad, int kolonne) //henter verdien til rad og kolonne.
    {
      return inntekter[ rad][ kolonne];
    }
    //Sjekker og gjør at tabell feltene er redigerbare.
        public boolean istabellskaderEditable(int rad, int kolonne )
        {
            return kolonne == ERSTATNINGSKOLONNE;
        }
        public void setValueAt( Object nyVerdi, int rad, int kolonne )//Forandrer verdien hvis rad eller kolonne har blitt forandret.
        {
            inntekter[ rad][ kolonne] = nyVerdi;
        }
        
}
