/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Modelo;

/**
 *
 * @author brand
 */
public class ObjComun extends Objeto {
    String rareza;
    int probabilidad;
    public ObjComun(){
    super();
    }

    @Override
    public String rareza() {
        return "raro";
    }
        
}
