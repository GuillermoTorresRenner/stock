/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Item;
import model.Marca;
import model.Subcategoria;

/**
 *
 * @author guille
 */
public class ControladorItem {

    private ResultSet rs;
    private PreparedStatement ps;
    private Conexion con;

    public ControladorItem() {
        con = new Conexion();
    }

    public void agregarCategoria(Categoria c) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into categoria values (null,?)");
            ps.setString(1, c.getCategoria().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria " + c.getCategoria().toUpperCase() + " creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la categoría " + c.getCategoria().toUpperCase());
        }

        con.cerrarConexion();

    }

    public void agregarSubCategoria(Subcategoria sc) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into subcategoria values (null,?)");
            ps.setString(1, sc.getSubcategoria().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subcategoria " + sc.getSubcategoria().toUpperCase() + " creada exitosamente");
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la Subcategoría " + sc.getSubcategoria().toUpperCase());
        }

    }

    public void agregarMarca(Marca m) {
        try {
            ps = con.establecerConexion().prepareStatement("Insert into marca values (null,?)");
            ps.setString(1, m.getMarca().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca " + m.getMarca() + " creada exitosamente");

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo crear la Marca " + m.getMarca().toUpperCase());
        }

    }

    //falta crear metodo para insertar sub categoria y marcas
    public DefaultComboBoxModel dameComboMarcas() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT marca from marca order by marca");
            rs = ps.executeQuery();
            cb.addElement("SIN MARCA");
            while (rs.next()) {
                cb.addElement(rs.getString("marca"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cb;
    }

    public DefaultComboBoxModel dameComboSubCategorias() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT subcategoria from subcategoria order by subcategoria");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UNA SUBCATEGORIA");
            while (rs.next()) {
                cb.addElement(rs.getString("subcategoria"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cb;
    }

    public DefaultComboBoxModel dameComboCategorias() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT categoria from categoria order by categoria");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UNA CATEGORIA");
            while (rs.next()) {
                cb.addElement(rs.getString("categoria"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cb;
    }

    public String dameIdActual() {
        int id = 0;
        String ids = null;
        try {
            ps = con.establecerConexion().prepareStatement("SELECT MAX(id) +1 FROM item");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

            ids = String.valueOf(id);
            if (ids.length() < 10) {
                ids = "000" + ids;

            }
            if (ids.length() > 9 && ids.length() < 100) {
                ids = "00" + ids;
            }
            if (ids.length() > 99 && ids.length() < 1000) {
                ids = "0" + ids;
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ids;
    }

    private String dameIdCategoria(String cat) {
        int id = 0;
        String ids = null;
        try {
            ps = con.establecerConexion().prepareStatement("SELECT id from categoria where categoria=?");
            ps.setString(1, cat);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

            ids = String.valueOf(id);
            if (ids.length() < 10) {
                ids = "00" + ids;

            }
            if (ids.length() > 9 && ids.length() < 100) {
                ids = "0" + ids;
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ids;
    }

    private String dameIdSubCategoria(String subcat) {
        int id = 0;
        String ids = null;
        try {
            ps = con.establecerConexion().prepareStatement("SELECT id from subcategoria where subcategoria=?");
            ps.setString(1, subcat);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

            ids = String.valueOf(id);
            if (ids.length() < 10) {
                ids = "00" + ids;

            }
            if (ids.length() > 9 && ids.length() < 100) {
                ids = "0" + ids;
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ids;
    }

    private String dameIdMarca(String marca) {
        int id = 0;
        String ids = null;
        try {
            ps = con.establecerConexion().prepareStatement("SELECT id from marca where marca=?");
            ps.setString(1, marca);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

            ids = String.valueOf(id);
            if (ids.length() < 10) {
                ids = "00" + ids;

            }
            if (ids.length() > 9 && ids.length() < 100) {
                ids = "0" + ids;
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ids;
    }

    public String dameCodigo(String cat, String subcat, String marca) {
        String cod = null;

        return dameIdCategoria(cat) + dameIdSubCategoria(subcat) + dameIdMarca(marca) + dameIdActual();
    }

    public boolean guardarItem(Item item) {
        boolean e=false;
        try {
            ps = con.establecerConexion().prepareStatement("INSERT INTO item VALUES (null,?,?,?,?,?,?,?)");
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getCodigo());
            ps.setInt(3, item.getCategoria());
            ps.setInt(4, item.getSubcategoria());
            ps.setInt(5, item.getMarca());
            ps.setString(6, item.getModelo());
            ps.setString(7, item.getDescripcion());
           
            
            ps.executeUpdate();
            e=true;
            JOptionPane.showMessageDialog(null, "EL ÍTEM: "+ item.getNombre ()+ " SE GUARDÓ CORRECTAMENTE ");
            


        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR EL REGISTRO ");
        }
           return e;
    }
    
    

    public int dameIdCombo(int combo, String seleccionado) {
        int id = 0;
        String consulta = null;

        switch (combo) {
            case 1:
                consulta = "SELECT id from categoria where categoria=?";
                break;
            case 2:
                consulta = "SELECT id from subcategoria where subcategoria=?";
                break;

            case 3:
                consulta = "SELECT id from marca where marca=?";
                break;

        }

        try {
            ps = con.establecerConexion().prepareStatement(consulta);
            ps.setString(1, seleccionado);
            rs=ps.executeQuery();
            while (rs.next()) {
                id=rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return id;
    }

}
