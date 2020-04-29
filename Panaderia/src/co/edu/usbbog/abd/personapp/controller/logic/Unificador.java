/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.abd.personapp.controller.logic;


import co.edu.usbbog.abd.personapp.model.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author 304
 */
public class Unificador {
//    private ArrayList<Grafica> personas;
//
//    public Unificador() {
//        this.personas = new ArrayList<>();
//    }

    ArrayList<Producto> listaVehiculos = new ArrayList<Producto>();

    public void add(Producto o) {
        listaVehiculos.add(o);
    }
    


    public void delete(int o) {

        //listaGrafica.remove(o);
        try {
            
                listaVehiculos.remove(0);
                JOptionPane.showMessageDialog(null, "El elemento se eliminó prro");
            
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia, por favor ingresar un elemento antes de eliminar");
        }

    }

    public void clonacion(int o) {
        //listaGrafica.remove(o);
        listaVehiculos.clone();
    }

    public void modify(Producto o) {

        listaVehiculos.indexOf(o);

    }

    public void mostrar() {

        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println(listaVehiculos.get(i));
        }

    }

    public void ingresar(int a, int b) {
        int usuario = 123;
        int contrasena = 456;

        do {
            System.out.println("Intentando ingresar");
        } while ((a) != usuario && (b) != contrasena);

        System.out.println("Ingresado correctamente");

    }

    public void vaciar() {
        listaVehiculos.clear();
    }

    public void cantidad() {
        System.out.println("El tamaño de la lista es: "+listaVehiculos.size());
    }

    public void organizar() {
        //Collections.sort(listaVehiculos,Collections.reverseOrder());
        //JOptionPane.showMessageDialog(null, "Se a Organizado de atras hacia adelante.");
        
         for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println(listaVehiculos.get(i));
        }
    }

    public void validarVacio() {
        if(listaVehiculos.size()==0){
            JOptionPane.showMessageDialog(null, "El programa no cuenta con elementos, esta vacio");
        }else{
            JOptionPane.showMessageDialog(null, "El programa cuenta con elementos agregados, no esta vacio");
        }
        
    }

    public void actualizar() {

        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println(listaVehiculos.get(i));
        }

    }


    
    public void imprimir() {
        for (Producto persona : listaVehiculos) {
            System.out.println(persona.toString());
        }
    }
    

    
}
