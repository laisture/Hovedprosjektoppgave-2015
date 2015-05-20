
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Filen inneholder get og set metoder for oppretting av skademelding.
 * Hensikten med klassen er å lage konstruktører og metoder for oppretting av skademelding.
 * Siste edit: 19.05.15
 * @author Joakim
 */
public class Skademelding implements Serializable{
    
    private Kunde kunde;
    private String melding;
    private String dato;
    private String type;
    private String vitne;
    private int takst;
    private String datoopprettet;
    private BufferedImage bildet;
    private long opprettetlong;
    private int skadenummer;
    private static int nestenummer = 1;
    private boolean sjekket=false;
    
    public Skademelding (Kunde k, String s, String t,String v)
            
    {
        skadenummer=nestenummer++;
        kunde=k;
        melding=s;
        type=t;
        vitne=v;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date cal = new Date();
        datoopprettet= dateFormat.format(cal.getTime());
        opprettetlong = (long) (cal.getTime());
    }
    //Get og set metoder.
    public void setTakst(int i)
    {
        takst=i;
    }
    public void setSjekket(Boolean b)
    {
        sjekket=b;
    }
    public boolean getSjekket()
    {
        return sjekket;
    }
    public long getOpprettetlong()
    {
        return opprettetlong;
    }
    public Kunde getKunde()
    {
        return kunde;
    }
    public String getMelding()
    {
        return melding;
    }//Henter bildet som ble lagret med skademeldingen.
    public ImageIcon getBildet() 
    {
        ImageIcon ny;
       String bildefil = skadenummer+".png";
       
        URL kilde = Skademelding.class.getResource(bildefil);
        
        System.out.println(kilde);
         
            BufferedImage b;
        try {
            b = ImageIO.read(kilde);
        } catch (IOException ex) {
            b=null;
            
        }
            bildet=resize(b,200,200);
            ny=new ImageIcon(bildet);
        bildet=null;
        kilde=null;
        b=null;
        return(ny);
    }
    //skalerer bildet.
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
}  //Get og set metoder.
    public int getTakst()
    {
        return takst;
    }
    public String getType()
    {
        return type;
    }
    public String getDato()
    {
        return datoopprettet;
    }
    public void setNestenummer(int i)
    {
        nestenummer=i;
    }
    public int getSkadenummer()
    {
     return skadenummer;   
    }//Sjekker om kunden har forsikring.
    public Boolean harForsikring()
    {
       ArrayList f=kunde.getForsikringer();
       String forsikringKlasse="class "+type;
       String klasse;
       for(Object i : f)
        {
            klasse=i.getClass()+"";
                if(klasse.equals(forsikringKlasse))
                {
                    return true;
                    
                }
        }
       return false;
            
       
    }
}
