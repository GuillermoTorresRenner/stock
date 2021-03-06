package model;
// Generated 08-jul-2020 21:20:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer id;
     private String categoria;
     private Set items = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    public Categoria(String categoria, Set items) {
       this.categoria = categoria;
       this.items = items;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Set getItems() {
        return this.items;
    }
    
    public void setItems(Set items) {
        this.items = items;
    }




}


