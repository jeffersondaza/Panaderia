package co.edu.usbbog.abd.personapp.model;

import java.util.Objects;

public class Producto {

    private String nombre;
    private String marca;
    private String fecha;
    private int costo;
    private int cantidad;

    public Producto(String nombre, String marca, String fecha, int costo, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.fecha = fecha;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.fecha);
        hash = 67 * hash + this.costo;
        hash = 67 * hash + this.cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", marca=" + marca + ", fecha=" + fecha + ", costo=" + costo + ", cantidad=" + cantidad + '}';
    }

}
