package model;
// Generated 08-jul-2020 21:20:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Marca generated by hbm2java
 */
public class Marca  implements java.io.Serializable {


     private Integer id;
     private String marca;
     private Set items = new HashSet(0);

    public Marca() {
    }

	
    public Marca(String marca) {
        this.marca = marca;
    }
    public Marca(String marca, Set items) {
       this.marca = marca;
       this.items = items;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Set getItems() {
        return this.items;
    }
    
    public void setItems(Set items) {
        this.items = items;
    }




}


