/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.abd.personapp.controller.persistence;

import co.edu.usbbog.abd.personapp.model.Producto;
import java.util.List;

/**
 *
 * @author 305
 */
public interface ProductoDTO {
    public boolean registrarProducto(Producto persona);
    public boolean editar(Producto persona);
    public boolean eliminar(String nombre);
  
}
