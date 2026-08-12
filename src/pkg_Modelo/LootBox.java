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
            throw new LootBoxVaciaException("No hay objetos :b");
        }

        int probabilidadTotal = 0;
        for (Objeto obj : catalogo) {
            probabilidadTotal += obj.getRareza().getPorcent();
        }

        int numeroAleatorio = random.nextInt(probabilidadTotal);
        int acumulado = 0;

        for (Objeto obj : catalogo) {
            acumulado += obj.getRareza().getPorcent();
            if (numeroAleatorio < acumulado) {
                return obj;
            }
        }
        return catalogo.get(0);
    }
}