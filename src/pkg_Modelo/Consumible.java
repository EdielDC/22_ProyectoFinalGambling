/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Modelo;

/**
 *
 * @author brand
 */
public class Consumible extends Objeto{
    private int curacion;
    public Consumible(int idObjeto, String nombre, Rareza rareza, String descripcion) {
        super(idObjeto, nombre, descripcion, rareza);
    }

    public int getCuracion() {
        return curacion;
    }

    public void setCuracion(int curacion) {
        this.curacion = curacion;
    }

    @Override
    public String obtenerInfo() {
        return "Elemento consumible";
    }
    
}
