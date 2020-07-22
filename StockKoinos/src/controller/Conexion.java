/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Config;

/**
 *
 * @author guille
 */
public class Conexion {
    private  Connection cnx = null;
    private Config config = new Config();
    private String url=config.getURL().trim();
    private String user=config.getUSER().trim();
    private String pass=config.getPASSWORD().trim();
    public Conexion() {
       
    }
    
    
    
    
    
   public Connection establecerConexion () {
     
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://"+url, user, pass);
         } catch (SQLException ex) {
             System.out.println(ex);
             JOptionPane.showMessageDialog(null, "No se puede establecer conexión con la base de datos, revise que XAMMP este corriendo");
         } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null, "No se puede establecer conexión con la base de datos, revise que XAMMP este corriendo");
         }
      
      return cnx;
   }
   public void cerrarConexion() {
     
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }
}
