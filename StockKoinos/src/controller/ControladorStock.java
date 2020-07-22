/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bodega;
import model.Caja;
import model.Item;
import model.Lote;
import model.Stock;

/**
 *
 * @author guille
 */
public class ControladorStock {

    private Conexion con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String[] columnas = {"ID", "CÓDIGO", "NOMBRE", "CATEGORÍA", "SUBCATEGORIA", "MARCA", "MODELO"};

    public ControladorStock() {
        con = new Conexion();
    }

  

    public DefaultComboBoxModel dameComboBodegas() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT nombre from bodega order by nombre");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UNA BOEGA");
            while (rs.next()) {
                cb.addElement(rs.getString("nombre"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.cerrarConexion();
        return cb;
    }

    public DefaultComboBoxModel dameComboCaja() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT nombre from caja order by nombre");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UNA CAJA");
            while (rs.next()) {
                cb.addElement(rs.getString("nombre"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.cerrarConexion();
        return cb;
    }

    public DefaultComboBoxModel dameComboLote() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT nombre from lote order by nombre");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UN LOTE");
            while (rs.next()) {
                cb.addElement(rs.getString("nombre"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.cerrarConexion();
        return cb;
    }

    public DefaultTableModel buscaItemPor(int criterio,String parametro) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(columnas);
        Object[] vector = new Object[7];
        String consulta=null;
        switch(criterio){
            case 1:
                 consulta= "SELECT item.id,item.codigo,item.nombre,categoria.categoria,subcategoria.subcategoria,marca.marca ,item.modelo FROM item INNER JOIN categoria on categoria.id=item.categoria INNER JOIN subcategoria ON subcategoria.id =item.subcategoria INNER JOIN marca ON marca.id= item.marca WHERE item.codigo=?;";
            
                break;
                   case 2:
                        consulta="SELECT item.id,item.codigo,item.nombre,categoria.categoria,subcategoria.subcategoria,marca.marca ,item.modelo FROM item INNER JOIN categoria on categoria.id=item.categoria INNER JOIN subcategoria ON subcategoria.id =item.subcategoria INNER JOIN marca ON marca.id= item.marca WHERE item.nombre like ?;";
                break;
                   
            case 3:
                consulta="SELECT item.id,item.codigo,item.nombre,categoria.categoria,subcategoria.subcategoria,marca.marca ,item.modelo FROM item INNER JOIN categoria on categoria.id=item.categoria INNER JOIN subcategoria ON subcategoria.id =item.subcategoria INNER JOIN marca ON marca.id= item.marca WHERE categoria.categoria=?;";
              
                break;
                    
            case 4:
                consulta="SELECT item.id,item.codigo,item.nombre,categoria.categoria,subcategoria.subcategoria,marca.marca ,item.modelo FROM item INNER JOIN categoria on categoria.id=item.categoria INNER JOIN subcategoria ON subcategoria.id =item.subcategoria INNER JOIN marca ON marca.id= item.marca WHERE subcategoria.subcategoria=?;";
              
                break;
                    
            case 5:
                consulta="SELECT item.id,item.codigo,item.nombre,categoria.categoria,subcategoria.subcategoria,marca.marca ,item.modelo FROM item INNER JOIN categoria on categoria.id=item.categoria INNER JOIN subcategoria ON subcategoria.id =item.subcategoria INNER JOIN marca ON marca.id= item.marca WHERE marca.marca=?;";
              
                break;
                    
        }
        
        try {
            ps = con.establecerConexion().prepareStatement(consulta);
            ps.setString(1, parametro);
            rs = ps.executeQuery();

            while (rs.next()) {
                vector[0] = rs.getInt("id");
                vector[1] = rs.getString("codigo");
                vector[2] = rs.getString("nombre");
                vector[3] = rs.getString("categoria");
                vector[4] = rs.getString("subcategoria");
                vector[5] = rs.getString("marca");
                vector[6] = rs.getString("modelo");
                dtm.addRow(vector);

               
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.cerrarConexion();
        return dtm;
    }
    
    public boolean guardarStock(Stock s){
        boolean status=false;
        try {
            ps= con.establecerConexion().prepareCall("insert into stock values(null,?,?,?,?,?,?)");
            ps.setString(1, s.getFechaIngreso());
            ps.setInt(2,s.getItem());
            ps.setDouble(3, s.getCantidad());
            ps.setInt(4, s.getBodega());
            ps.setInt(5, s.getLote());
            ps.setInt(6, s.getCaja());
          
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guardado Exitoso");
            status =true;
                    } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido guardar en la base de datos");
        }
        con.cerrarConexion();
        return status;
    }
    
      public void agregarBodega(Bodega b) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into bodega values (null,?,'')");
            ps.setString(1, b.getNombre().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bodega " + b.getNombre().toUpperCase() + " creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la bodega " + b.getNombre().toUpperCase());
        }

        con.cerrarConexion();

    }
      
        public void agregarLote(Lote l) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into lote values (null,?,'')");
            ps.setString(1, l.getNombre().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lote " + l.getNombre().toUpperCase() + " creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la Lote " + l.getNombre().toUpperCase());
        }

        con.cerrarConexion();

    }
        
         public void agregarCaja(Caja c) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into caja values (null,?,'')");
            ps.setString(1, c.getNombre().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Caja " + c.getNombre().toUpperCase() + " creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la Caja " + c.getNombre().toUpperCase());
        }

        con.cerrarConexion();

    }
        
         public int  buscaridde (int i ,String nombre) {
             String consulta=null;
             int id=0;
             switch(i){
                 case 1:
                     consulta="SELECT id from unidad WHERE unidad=?";
                     break;
                 case 2:
                     consulta="SELECT id from bodega WHERE nombre=?";
                     break;
                 case 3:
                     consulta="SELECT id from lote WHERE nombre=?";
                     break;
                 case 4:
                     consulta="SELECT id from caja WHERE nombre=?";
                     break;
             }
        try {
            ps = con.establecerConexion().prepareStatement(consulta);
            ps.setString(1,nombre);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                id= rs.getInt("id");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
           
        }

        con.cerrarConexion();
        return id;
    }
        
        
    
    
}
