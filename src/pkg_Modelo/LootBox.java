/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Modelo;
import java.util.ArrayList;
import java.util.Random;
import pkg_Excepcion.*;
/**
 *
 * @author brand
 */
public class LootBox {
    private final Random random = new Random();

    public Objeto abrirLootBox(ArrayList<Objeto> catalogo) throws LootBoxVaciaException {
        if (catalogo == null || catalogo.isEmpty()) {
            return null;
        }

        int pesoTotal = 0;
        for (Objeto obj : catalogo) {
            pesoTotal += obtenerRareza(obj.getRareza());
        }

        int numeroAleatorio = random.nextInt(pesoTotal);
        int acumulado = 0;

        for (Objeto obj : catalogo) {
            acumulado += obtenerRareza(obj.getRareza());
            if (numeroAleatorio < acumulado) {
                return obj;
            }   
        }
        return catalogo.get(0);
    }

    private int obtenerRareza(Rareza rareza) {
        return switch (rareza) {
            case COMMON -> 60;
            case RARE -> 25;
            case EPIC -> 10;
            case LEGENDARY -> 5;
        };
    }
}