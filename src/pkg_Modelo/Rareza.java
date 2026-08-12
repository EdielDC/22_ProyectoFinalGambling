/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pkg_Modelo;

/**
 *
 * @author brand
 */
public enum Rareza {
    COMMON("Común", 65),
    RARE("Rara", 28),
    EPIC("Épica", 5),
    LEGENDARY("Legendaria", 2);
    private final String nombre;
    private final int porcent;
    
    Rareza(String nombre, int porcent) {
        this.porcent = porcent;
        this.nombre = nombre;
}

    public String getNombre() {
        return nombre;
    }

    public int getPorcent() {
        return porcent;
    }
    
}
