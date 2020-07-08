
import controller.ControladorStock;
import model.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guille
 */
public class Main {
    public static void main(String[] args) {
        Categoria c= new Categoria("categoria a prueba de idiotas");
        ControladorStock cs= new ControladorStock();
        cs.agregarCategoria(c);
    }
}
