/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import Servidor.DecodificadorUsr;
import cliente.main.Cliente;
import cliente.modelo.PaqueteUsr;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ListModel;

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
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void procesaEventoActualizar(){
        java.io.PrintStream o = null;
        DecodificadorUsr dec = new DecodificadorUsr();
        try {
            Socket miSocket = Cliente.getSocket();
            o = new java.io.PrintStream(miSocket.getOutputStream());
            o.println("SolicitudUsuarios");
            BufferedReader inred = new java.io.BufferedReader(new java.io.InputStreamReader(miSocket.getInputStream()));
            modelo.setListaUsuarios(dec.decodificar(inred.readLine()).getListaUsuarios());
            vista.actualizar(modelo.getListaUsuarios());
        } catch (IOException ex) {
            

        }
        
    }
}
