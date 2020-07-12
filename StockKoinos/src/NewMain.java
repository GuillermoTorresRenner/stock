
import controller.ControladorItem;

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
       controller.ControladorItem c= new ControladorItem();
        System.out.println( c.dameCodigo("CAT1", "SUBCAT2", "MARCA1"));
     
    }
}
