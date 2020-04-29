package co.edu.usbbog.abd.personapp.controller.persistence;

import co.edu.usbbog.abd.personapp.model.Producto;
import com.mysql.jdbc.ResultSetRow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Mostrar {

    static Connection conexion = null;
    private final ConexionMySQL mySQL;
    static Statement sentencia;
    static ResultSet resultado;

    public Mostrar() {
        this.mySQL = new ConexionMySQL("127.0.0.1", 3306, "persona_db", "persona_app", "password");
    }



    public boolean mostrarProducto() {
        String sql = "SELECT * FROM persona_db.vehiculo;";

        System.out.println(sql);
        if (this.mySQL.conectar()) {
            Connection con = this.mySQL.getCon();
            try {
                Statement stm = con.createStatement();
                stm.execute(sql);
                stm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean visualizarParqueadero(int idParqueadero) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {

            String query = "select * from parqueadero where id_parqueadero=";
            query += idParqueadero + ";";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Parqueadero{ " + "id: " + rs.getInt("id_parqueadero") + " nombre: " + rs.getString("nombre") + " ]");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean visualizarProducto(String nombre) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {

            String query = "select * from panaderia.productos where nombre=";
            query += "\"" + nombre + "\"" + ";";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Prducto[ " + "nombre: " + rs.getString("nombre") + " marca: " + rs.getString("marca") + " fecha: " + rs.getString("fecha_vencimiento") + " costo: " + rs.getInt("costo") + " cantidad: " + rs.getInt("cantidad") + " ]");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean visualizarGanancias() {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {

            String query = "select sum(costo) from panaderia.productos;";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("Los ingresos del dia son: " + rs.getInt("sum(costo)")+ " En ");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean visualizarNomCant() {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {

            String query = "select nombre, cantidad from panaderia.productos;";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("cantidad")+" " + rs.getString("nombre")+", ");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void conectar() {
        String ruta = "jdbc:mysql://localhost/persona_db";
        String user = "persona_app";
        String pass = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(ruta, user, pass);
            sentencia = conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }

}
