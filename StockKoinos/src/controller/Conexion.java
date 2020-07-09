/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guille
 */
public class Conexion {
    private  Connection cnx = null;
   public Connection establecerConexion () {
     
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "");
         } catch (SQLException ex) {
           
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      
      return cnx;
   }
   public void cerrarConexion() throws SQLException {
     
         cnx.close();
      
   }
}
