/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Controlador;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import pkg_Dao.DAOInventario;
import pkg_Excepcion.*;
import pkg_Modelo.*;
import pkg_vista.GamblingVista;
/**
 *
 * @author brand
 */

public class Controlador {

    private GamblingVista vista;
    private DAOInventario daoInventario;
    private LootBox lootBox;

    public Controlador(GamblingVista vista) {
        this.vista = vista;
        this.daoInventario = new DAOInventario();
        this.lootBox = new LootBox();
        this.vista.tablaInventario.getSelectionModel().addListSelectionListener(e -> seleccionarObjeto());
        this.vista.btnAbrir.addActionListener(e -> abrirCofre());
        this.vista.btnEliminar.addActionListener(e -> eliminarDelInventario());

        consultarInventario();
    }

    public void abrirCofre() {
        try {
            ArrayList<Objeto> catalogo = daoInventario.obtenerCatalogo();
            Objeto premio = lootBox.abrirLootBox(catalogo);
            daoInventario.guardarRecompensa(premio.getIdObjeto());
            
            ImageIcon cofreAbierto = new ImageIcon(getClass().getResource("/imagenes/ChestA.png"));
            ImageIcon cofreCerrado = new ImageIcon(getClass().getResource("/imagenes/ChestC.png"));
            vista.lblChest.setIcon(cofreAbierto);
            Timer temporizador = new Timer(2000, e -> {
            vista.lblChest.setIcon(cofreCerrado);
            });
            temporizador.setRepeats(false);
            temporizador.start();
            
            JOptionPane.showMessageDialog(
                vista, 
                "¡Felicidades! Has obtenido: " + premio.getNombre() + " (" + premio.getRareza().getNombre() + ")", "Recompensa Obtenida", JOptionPane.INFORMATION_MESSAGE);
            consultarInventario();
        } catch (LootBoxVaciaException ex) {
            JOptionPane.showMessageDialog(vista, "Error en la LootBox: " + ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al abrir el cofre: " + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void consultarInventario() {
        try {
            ArrayList<Objeto> inventario = daoInventario.obtenerInventario();
            vista.cargarInventarioEnTabla(inventario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                vista, 
                "Error al consultar el inventario: " + ex.getMessage(), 
                "Error BD", 
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void seleccionarObjeto() {
        if (vista.tablaInventario.getSelectionModel().getValueIsAdjusting()) {
            return; 
        }
        int fila = vista.tablaInventario.getSelectedRow();
        if (fila >= 0) {
            try {
                ArrayList<Objeto> listaActual = daoInventario.obtenerInventario();
                if (fila < listaActual.size()) {
                    vista.nombreSeleccionado = listaActual.get(fila).getNombre();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                    vista, "Error al recuperar el nombre del objeto: " + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void eliminarDelInventario() {
        if (vista.nombreSeleccionado != null && !vista.nombreSeleccionado.isEmpty()) {
            try {
                ArrayList<Objeto> listaActual = daoInventario.obtenerInventario();
                for (Objeto obj : listaActual) {
                    if (obj.getNombre().equals(vista.nombreSeleccionado)) {
                        daoInventario.eliminarDelInventario(obj.getIdObjeto());
                        break;
                    }
                }
                vista.nombreSeleccionado = null;
                consultarInventario();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                    vista, 
                    "Error al eliminar el objeto: " + ex.getMessage(),"Error BD",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                vista,"Seleccione un objeto de la tabla para eliminar.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
}
        