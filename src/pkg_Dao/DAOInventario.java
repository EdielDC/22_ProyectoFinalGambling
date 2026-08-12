/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Dao;
import pkg_Modelo.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author brand
 */
public class DAOInventario {
    private final String url = "jdbc:mysql://localhost:3306/gambling";
    private final String user = "root";
    private final String pass = "1234";

    public void guardarRecompensa(int idObjeto) throws SQLException {
        String sql = "INSERT INTO `inventarioUsuario` (`idObjeto`) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idObjeto);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Objeto> obtenerInventario() throws SQLException {
        ArrayList<Objeto> inventario = new ArrayList<>();
        
        String sql = "SELECT i.`idInventario`, c.`idObjeto`, c.`nombre`, c.`descripcion`, c.`rareza`, c.`tipoObjeto` " +
                     "FROM `inventarioUsuario` i " +
                     "INNER JOIN `objetoCatalogo` c ON i.`idObjeto` = c.`idObjeto`";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idInventario = rs.getInt("idInventario");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Rareza rareza = Rareza.valueOf(rs.getString("rareza").toUpperCase());
                String tipoObjeto = rs.getString("tipoObjeto");

                Objeto obj = null;
                if ("WEAPON".equalsIgnoreCase(tipoObjeto)) {
                    obj = new Arma(idInventario,nombre,descripcion, rareza);
                } else if ("POTION".equalsIgnoreCase(tipoObjeto)) {
                    obj = new Consumible(idInventario,nombre,descripcion, rareza);
                }

                if (obj != null) {
                    inventario.add(obj);
                }
            }
        }
        return inventario;
    }

    public void eliminarDelInventario(int idInventario) throws SQLException {
        String sql = "DELETE FROM `inventarioUsuario` WHERE `idInventario` = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idInventario);
            stmt.executeUpdate();
        }
    }
}
