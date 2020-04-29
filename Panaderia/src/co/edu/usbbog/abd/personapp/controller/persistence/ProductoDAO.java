/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.abd.personapp.controller.persistence;

import co.edu.usbbog.abd.personapp.model.Producto;
import com.mysql.jdbc.ResultSetRow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 305
 */
public class ProductoDAO implements ProductoDTO {

    private final ConexionMySQL mySQL;

    public ProductoDAO() {
        this.mySQL = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "password");
    }

    public boolean registrarProducto(Producto producto) {

        if (producto != null) {
            String sql = "INSERT INTO panaderia.productos VALUES(";
            sql += "\"" +producto.getNombre() + "\""+ ", ";
            sql += "\"" +producto.getMarca() + "\""+ ", ";
            sql += "\"" + producto.getFecha() + "\"" + ", ";
            sql += producto.getCosto()  + ", ";
            sql += producto.getCantidad();

            sql += ");";
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
        } else {
            return false;
        }

    }

    public boolean actualizarProducto(Producto producto) {
        if (producto != null) {
            String sql = "UPDATE panaderia.productos SET marca=";
            sql += "\""+producto.getMarca() +"\""+ ", ";
            sql += "fecha_vencimiento= " + "\"" + producto.getFecha() + "\"" + ", ";
            sql += "costo= " + producto.getCosto() + ", ";
            sql += "cantidad= " + producto.getCantidad();
            sql += " WHERE nombre=";
            sql += "\""+producto.getNombre()+"\"";
            sql += ";";
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
        } else {
            return false;
        }
    }

    public boolean editar(Producto persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(String nombre) {
        String sql = "DELETE FROM panaderia.productos WHERE "
                + "nombre = " +"\""+ nombre + "\""+";";
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

 





}
