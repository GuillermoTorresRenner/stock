/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Marca;
import model.Subcategoria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author guille
 */
public class ControladorStock {
    
    
    
    public void agregarCategoria(Categoria c){
        SessionFactory sf=NewHibernateUtil.getSessionFactory();
        Session session =sf.openSession();
        Transaction t=session.beginTransaction();
        session.save(c);
        t.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Categoria "+c.getCategoria() +" creada exitosamente");
        
    }
    
    
    public void agregarSubCategoria(Subcategoria sc){
        SessionFactory sf=NewHibernateUtil.getSessionFactory();
        Session session =sf.openSession();
        Transaction t=session.beginTransaction();
        session.save(sc);
        t.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Sub Categoria "+sc.getSubcategoria()+" creada exitosamente");
        
    }
    
    
    public void agregarMarca(Marca m){
        SessionFactory sf=NewHibernateUtil.getSessionFactory();
        Session session =sf.openSession();
        Transaction t=session.beginTransaction();
        session.save(m);
        t.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Marca "+m.getMarca()+" creada exitosamente");
        
    }
    
    public DefaultComboBoxModel dameComboCategorias(){
        DefaultComboBoxModel cb= new DefaultComboBoxModel();
        SessionFactory sf=NewHibernateUtil.getSessionFactory();
        Session session =sf.openSession();
        Transaction t=session.beginTransaction();
        Query q= session.createQuery("from Categoria");
        List <Categoria> l=q.list();
        
        for (Categoria c : l) {
            cb.addElement(c.getCategoria());
        }
        
        return cb;
    }
    
}
