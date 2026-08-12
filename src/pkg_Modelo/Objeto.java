/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Modelo;

/**
 *
 * @author limao
 */
public abstract class Objeto {
    private int idObjeto;
    private  String nombre;
    private String descripcion;
    private Rareza rareza;

    public Objeto() {}

    public Objeto(int idObjeto, String nombre, String descripcion, Rareza rareza) {
        this.idObjeto = idObjeto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza=rareza;
    }

    public Rareza getRareza() {
        return rareza;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
