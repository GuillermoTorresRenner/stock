package model;
// Generated 08-jul-2020 21:20:38 by Hibernate Tools 4.3.1


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;

/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer id;
     private int categoria;
     private int marca;
     private int subcategoria;
     private String nombre;
     private String codigo;
     private String modelo;
     private String descripcion;
     private File foto;
     
     

    public Item() {
    }

    public Item(Integer id, int categoria, int marca, int subcategoria, String nombre, String codigo, String modelo, String descripcion, File foto) {
        this.id = id;
        this.categoria = categoria;
        this.marca = marca;
        this.subcategoria = subcategoria;
        this.nombre = nombre;
        this.codigo = codigo;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(int subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public File getFoto() { 
        return foto;
    }

    public void setFoto(File foto) {
        this.foto=foto;
        
    }

   





}


