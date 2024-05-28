/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import cliente.main.Cliente;
import cliente.modelo.PaquetePartida;
/**
 *
 * @author javier
 */
public class ControladorMenu {
    
    public static final int PUERTO = 2000;
    private VistaMenuInicial vista;
    private PaquetePartida modelo;
    
    public ControladorMenu(VistaMenuInicial vista){
        this.vista = vista;
        modelo = Cliente.getModelo();
        
    }
    
    public void procesaEventoCrearUsuario(){
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
    
    
    public void procesaEventoIniciarSesion(){
       
    }
   
}
