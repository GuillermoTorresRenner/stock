/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ControladorStock {
    
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Conexion con;

    public ControladorStock() {
       con=new Conexion();
    }
    
    
    
    public void agregarCategoria(Categoria c){
        try {
            ps= con.establecerConexion().prepareStatement("Insert into categoria values (null,?)");
            ps.setString(1, c.getCategoria().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria "+c.getCategoria().toUpperCase() +" creada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "No se pudo crear la categoría "+c.getCategoria().toUpperCase());
        }
        
        try {
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void agregarSubCategoria(Subcategoria sc){
        try {
            ps= con.establecerConexion().prepareStatement("Insert into subcategoria values (null,?)");
            ps.setString(1, sc.getSubcategoria().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subcategoria "+sc.getSubcategoria().toUpperCase()+" creada exitosamente");
             con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "No se pudo crear la Subcategoría "+sc.getSubcategoria().toUpperCase());
        }
        
       
    }
    
     
      public void agregarMarca(Marca m){
        try {
            ps= con.establecerConexion().prepareStatement("Insert into marca values (null,?)");
            ps.setString(1, m.getMarca().toUpperCase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca "+m.getMarca() +" creada exitosamente");
            
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "No se pudo crear la Marca "+m.getMarca().toUpperCase());
        }
        
        
    }
    
    
    //falta crear metodo para insertar sub categoria y marcas
    
    public DefaultComboBoxModel dameComboMarcas(){
        DefaultComboBoxModel cb= new DefaultComboBoxModel();
        try {
            ps= con.establecerConexion().prepareStatement("SELECT marca from marca order by marca");
            rs=ps.executeQuery();
            cb.addElement("SELECCIONE UNA MARCA");
            while(rs.next()){
                cb.addElement(rs.getString("marca"));
            }
                    
             con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return cb;
    }
    
    
      
    public DefaultComboBoxModel dameComboSubCategorias(){
       DefaultComboBoxModel cb= new DefaultComboBoxModel();
        try {
            ps= con.establecerConexion().prepareStatement("SELECT subcategoria from subcategoria order by subcategoria");
            rs=ps.executeQuery();
            cb.addElement("SELECCIONE UNA SUBCATEGORIA");
            while(rs.next()){
                cb.addElement(rs.getString("subcategoria"));
            }
                    
             con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return cb;
    }
    
    
      public DefaultComboBoxModel dameComboCategorias(){
       DefaultComboBoxModel cb= new DefaultComboBoxModel();
        try {
            ps= con.establecerConexion().prepareStatement("SELECT categoria from categoria order by categoria");
            rs=ps.executeQuery();
            cb.addElement("SELECCIONE UNA CATEGORIA");
            while(rs.next()){
                cb.addElement(rs.getString("categoria"));
            }
                    
             con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return cb;
    }
      
      public String dameIdActual(){
          int id = 0;
          String ids = null;
       try {
            ps= con.establecerConexion().prepareStatement("SELECT MAX(id) +1 from item ");
            rs=ps.executeQuery();
           
            while(rs.next()){
               id=rs.getInt(id);
            }
            
            
             ids=String.valueOf(id);
          if(ids.length()<10){
              ids="000"+ids;
              
          }
          if (ids.length()> 9 && ids.length()<100 ){
            ids="00"+ids;
      }
         if (ids.length()> 99 && ids.length()<1000 ){
            ids="0"+ids;
      } 
                    
             con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorStock.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
        
        return ids;
    }
    
      
       public String dameIdCategoria(String cat){
      
        
        return null;
    }
}
