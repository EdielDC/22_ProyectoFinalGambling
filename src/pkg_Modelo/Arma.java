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

    public Arma(int idObjeto, String nombre, Rareza rareza, String descripcion) {
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
        return "Elemento equipable";
    }
}
