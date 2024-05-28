/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente.main;
import cliente.modelo.PaqueteDatos;
import cliente.vista.GestorVistas;
import cliente.vista.VistaMenuInicial;
import cliente.vista.VistaTablero;

public class Cliente {
    public static final int PUERTO = 2000;
    private static GestorVistas gestor;
    private static PaqueteDatos modelo;
  
    public static void main(String[] args) {
              
        gestor = new GestorVistas();
        modelo = new PaqueteDatos();
        gestor.mostrarVistaMenu();
        
     
        String linea = null;
        
        try{
            java.io.BufferedReader tec =
                    new java.io.BufferedReader(
                            new java.io.InputStreamReader(System.in));
            java.net.Socket miSocket = new java.net.Socket("localhost", PUERTO);
            java.io.BufferedReader inred =
                    new java.io.BufferedReader(
                            new java.io.InputStreamReader(miSocket.getInputStream()));
            java.io.PrintStream outred =
                    new java.io.PrintStream(miSocket.getOutputStream());
            while ((linea = tec.readLine()) != null) { // lee de teclado
                outred.println(linea); // envia al servidor
                        linea = inred.readLine(); // lee del servidor
                System.out.println("Recibido: "+linea); // eco local del servidor
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
/**
     * Metodo encargado de devolver el gestor de Vistas
     * @return gestor
     */
    public static GestorVistas getGestorVistas() {
        return gestor;
    }  
    /**
     * Metodo encargado de devolver el Modelo
     * @return modelo
     */
    public static PaqueteDatos getModelo() {
        return modelo;
    }
    /**
     * Metodo encargado de actualizar el modelo del Main
     * @param model 
     */
    public static void setModelo(PaqueteDatos model){
        Cliente.modelo = model;
    }

}