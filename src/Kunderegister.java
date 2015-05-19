/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joakim
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Kunderegister implements Serializable  {
    
    LinkedList<Kunde> register =new LinkedList<>();
   
    
    
    public Kunderegister()
    {
        nyKunde("ola","nordmann","testgate 1");
       SendSkademelding(1,"Dette er en test", "bil", "test");
       
         
    }
    //Registerer ny kunde, og gir kunden og kunde sin skademelding idnummer.
    public void Start()
    {
        Kunde k=new Kunde("","","");
        Skademelding s= new Skademelding(k,"","","");
        int n=0;
        int i=register.size();
        for (int j=0;j<register.size();j++)
        {
           
           n+=register.get(j).getAntallSkader();
        }
        s.setNestenummer(n+1);
        k.setNestenummer(i+1);
    }
    public int getSkadenummer()//Henter antallskader kunden har registrert.
    {
        int n=0;
        
        for (int j=0;j<register.size();j++)
        {
           
           n+=register.get(j).getAntallSkader();
        }
        return (n);
    }
    //Henter kundens kundens forsikringsnummer, og sender med det, mens den legger til skademelding til kunden.
    public Boolean SendSkademelding(int k, String m, String t, String v)
    {
        
        Kunde kunde=finnKundeInt(k);
        Boolean ok=kunde.addSkademelding(kunde,m,t,v);
        return ok;
    }
    
     public Skademelding[] getSkademeldinger()
    {
        ArrayList<Skademelding> skademeldinger=new ArrayList();
        
        Skademelding[] kundeskade;
        for (Kunde kunde : register)
        {
            kundeskade=kunde.getSkademeldinger();
            for(int i=0; i<kundeskade.length;i++)
            {
                if(kundeskade[i]!=null)
                {
                    skademeldinger.add(kundeskade[i]);
                }
            }
        }
        Skademelding[] skade = new Skademelding[skademeldinger.size()];
        skade = skademeldinger.toArray(skade);
        return skade;
        
    }//Metoden finner skademeldingsnummer.
     public Skademelding finnSkademelding(int s)//Finner skademeldingsiden i skademeldingsarrayen.
     {
         Skademelding [] sm=getSkademeldinger();
         
         for (int i=0; i<sm.length;i++)
         {
             if (sm[i].getSkadenummer()==s)
             {
                 return sm[i];
             }
         }
         return null;
     }
     public int getPremie(String s)
     {
         int sum=0;
         ArrayList<Forsikring> f;
         for (Kunde kunde : register)
        {
            f=kunde.getForsikringer();
            
            for(Forsikring forsikring : f)
            {
                
                if(forsikring.getType().equals(s) && forsikring.getGyldig())
                {
                    sum+=forsikring.getPremie();
                    
                }
            }
        }
         return sum;
     }//Finner kundensskademelding og skadetype, får å hente ut takst.
     public int getErstatning(String s)
     {
         int sum=0;
        
         for (Kunde kunde : register)
        {
            sum+= kunde.Erstatning(s);
        }
         return sum;
     }
     //Legger til forsikringsobjekter i arrayet.
     public Object[][] get2dinn()
     {
         Object[][] inn =new Object[6][2];
         
         inn[0][0]="Bilforsikring";
         inn[1][0]="Båtforsikring";
         inn[2][0]="Husforsikring";
         inn[3][0]="Fritidsboligforsikring";
         inn[4][0]="Reiseforsikring";
         inn[5][0]="Sum";
         
         int bil=getPremie("bil");
         int båt=getPremie("båt");
         int hus=getPremie("hus");
         int fri=getPremie("fritid");
         int reise=getPremie("reise");
         
         inn[0][1]=bil;
         inn[1][1]=båt;
         inn[2][1]=hus;
         inn[3][1]=fri;
         inn[4][1]=reise;
         inn[5][1]=bil+båt+hus+fri+reise;
         return inn;
     }
     public Object[][] get2dut()
     {
         Object[][] ut =new Object[6][2];
         
         ut[0][0]="Bilforsikring";
         ut[1][0]="Båtforsikring";
         ut[2][0]="Husforsikring";
         ut[3][0]="Fritidsboligforsikring";
         ut[4][0]="Reiseforsikring";
         ut[5][0]="Sum";
         
         int bil=getErstatning("Bil");
         int båt=getErstatning("Båt");
         int hus=getErstatning("Hus");
         int fri=getErstatning("Fritid");
         int reise=getErstatning("Reise");
         
         ut[0][1]=bil;
         ut[1][1]=båt;
         ut[2][1]=hus;
         ut[3][1]=fri;
         ut[4][1]=reise;
         ut[5][1]=bil+båt+hus+fri+reise;
         return ut;
     }
         
     public void Endring (Object[][] a)
     {
         //Finner og endrer takst og skademelding hvis noe har blitt forandret eller lagt til.
         
         for (int i=0;i<a.length;i++)
         {
             if(a[i][7]!=null)
             {
                 Skademelding s=finnSkademelding((int)a[i][7]);
                 if(a[i][3].getClass().equals(String.class))
                 {
                     s.setTakst(Integer.parseInt((String)a[i][3]));
                 }
              
              s.setSjekket((Boolean)a[i][6]);
              
              for (Kunde k : register)
              {
                  if (k!=null && k.getForsikringsnummer()==(int)a[i][0])
                  {
                      k.setSkademelding(s);
                      
                  }
              }
             }
          
         }
     }
     //Henter all informasjon fra skader arrayet.
     public Object[][] get2dSkade()
     {
         
         Skademelding[] skader=getSkademeldinger();
         Object[][] s=new Object[skader.length][8];
         
         for (int i=1; i<skader.length;i++)
         {
             
             if(skader[i]!=null)
             {
                
                 
                 
                s[i][0]=skader[i].getKunde().getForsikringsnummer();
                s[i][1]=skader[i].getType();
                s[i][2]=skader[i].getDato();
                s[i][3]=skader[i].getTakst();
                s[i][4]=skader[i].getMelding();
                s[i][5]="Vis bildet!";
                s[i][6]=skader[i].getSjekket();
                s[i][7]=skader[i].getSkadenummer();
                
             }
         }
         
         return s;
     }
    public void settInn(Kunde ny)
    {
        register.add(ny);
        
    }//Registerer ny kunde.
    public Boolean nyKunde(String f, String e, String a)//Registrerer ny kunde.
    {
        Kunde b=new Kunde(f,e,a);
        settInn(b);
        if(b == null)
            return false;
        else
            return true;
    }
    public Kunde finnKundeInt(int k)//Finner kunde ved å forsikringsnummer.
    {
//       
        for (Kunde kunde : register)
        {
            if (kunde.getForsikringsnummer()==k)
            {    
                return kunde;
            }
        }
        return null;
    }
    public Boolean lagForsikring(Kunde k, Forsikring f)//Legger til ny forsikring.
    {
        Boolean ok=k.addForsikring(f);
        return ok;
    }
    
    public Kunde finnKundeString(String n)
    {
        /*Iterator<Kunde> iterator = register.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next().getEtternavn()==n || iterator.next().getFornavn()==n || iterator.next().getNavn()==n)
            {
                return (iterator.next());
            }
        }*/
        for (Kunde kunde : register)
        {
            if(kunde.getEtternavn().toLowerCase().equals(n.toLowerCase())/* || kunde.getNavn().toLowerCase().equals(n.toLowerCase())*/)
                return kunde;
        }
        return null;
    }
    
    
    public String toString()
    {
        String personer= "";
        Iterator<Kunde> iterator = register.iterator();
        while (iterator.hasNext())
        {
            personer+= iterator.next().toString() + "\n";
        }
        return personer;
    }
   
    // <Metorder for: Oppretting av kunder og forsikringer. >
    //<Metoder for søke gjennom kunder og forsikringer>
    
}
