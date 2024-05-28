/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import cliente.main.Cliente;
import cliente.modelo.PaqueteUsr;

/**
 *
 * @author javier
 */
public class ControladorUsuarios {
    private VistaUsuarios vista;
    private PaqueteUsr modelo;
    public static final int PUERTO = 2000;

    public ControladorUsuarios(VistaUsuarios vista) {
        this.vista = vista;
        modelo = Cliente.getModeloUsr();

    }
    
    public void procesaEventoSeleccion(){
        
        try{
            java.net.Socket miSocket = new java.net.Socket("localhost", PUERTO);
                java.io.PrintStream outred = new java.io.PrintStream(miSocket.getOutputStream());
                outred.println(vista.getUsr()); // envia al servidor
                //vista.setErrMessage("Envio correcto de datos...");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
