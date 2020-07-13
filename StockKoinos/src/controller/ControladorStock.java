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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guille
 */
public class ControladorStock {
    private Conexion con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ControladorStock() {
        con= new Conexion();
    }
    
     public DefaultComboBoxModel dameComboUnidad() {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        try {
            ps = con.establecerConexion().prepareStatement("SELECT unidad from unidad order by unidad");
            rs = ps.executeQuery();
            cb.addElement("SELECCIONE UNA UNIDAD");
            while (rs.next()) {
                cb.addElement(rs.getString("unidad"));
            }

            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cb;
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

        return cb;
    }
    
     public DefaultTableModel buscaItemPorCodigo(){
         DefaultTableModel dtm = null;
        try {
            ps=con.establecerConexion().prepareStatement("");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return dtm;
     }
}
