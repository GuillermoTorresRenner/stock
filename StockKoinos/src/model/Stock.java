package model;
// Generated 07-jul-2020 19:12:15 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Stock generated by hbm2java
 */
public class Stock  implements java.io.Serializable {


     private Integer id;
     private Bodega bodega;
     private Caja caja;
     private Item item;
     private Lote lote;
     private Unidad unidad;
     private Date fechaIngreso;
     private double cantidad;

    public Stock() {
    }

    public Stock(Bodega bodega, Caja caja, Item item, Lote lote, Unidad unidad, Date fechaIngreso, double cantidad) {
       this.bodega = bodega;
       this.caja = caja;
       this.item = item;
       this.lote = lote;
       this.unidad = unidad;
       this.fechaIngreso = fechaIngreso;
       this.cantidad = cantidad;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Bodega getBodega() {
        return this.bodega;
    }
    
    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    public Caja getCaja() {
        return this.caja;
    }
    
    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    public Lote getLote() {
        return this.lote;
    }
    
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    public Unidad getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }




}


