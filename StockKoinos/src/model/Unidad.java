package model;
// Generated 07-jul-2020 19:12:15 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Unidad generated by hbm2java
 */
public class Unidad  implements java.io.Serializable {


     private Integer id;
     private String unidad;
     private Double factorUnitario;
     private Set stocks = new HashSet(0);

    public Unidad() {
    }

	
    public Unidad(String unidad) {
        this.unidad = unidad;
    }
    public Unidad(String unidad, Double factorUnitario, Set stocks) {
       this.unidad = unidad;
       this.factorUnitario = factorUnitario;
       this.stocks = stocks;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public Double getFactorUnitario() {
        return this.factorUnitario;
    }
    
    public void setFactorUnitario(Double factorUnitario) {
        this.factorUnitario = factorUnitario;
    }
    public Set getStocks() {
        return this.stocks;
    }
    
    public void setStocks(Set stocks) {
        this.stocks = stocks;
    }




}

