/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Modelo;

/**
 *
 * @author brand
 */
public class Arma extends Objeto {
    private int daño;
    public Arma(int idObjeto, String nombre, String descripcion, Rareza rareza, int daño) {
        super(idObjeto, nombre, descripcion, rareza);
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    @Override
    public String obtenerInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
