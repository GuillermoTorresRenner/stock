
import controller.ControladorItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import model.CodigoBarras;
import sun.util.calendar.Gregorian;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guille
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CodigoBarras cb=new CodigoBarras();
       cb.dameArchivoCodigoBarras("0303456sahlashsalshsala",5,"preueba");
    }
}

