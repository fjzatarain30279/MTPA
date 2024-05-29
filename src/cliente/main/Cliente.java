/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente.main;
import cliente.modelo.PaqueteLogin;
import cliente.modelo.PaquetePartida;
import cliente.modelo.PaqueteUsr;
import cliente.vista.GestorVistas;
import java.net.Socket;

public class Cliente {
    
    private static GestorVistas gestor;
    private static PaquetePartida modeloPartida;
    private static PaqueteLogin modeloLogin;
    private static PaqueteUsr modeloUsr;
    private static Socket socketCliente;
  
    public static void main(String[] args) {
              
        gestor = new GestorVistas();
        modeloPartida = new PaquetePartida();
        modeloLogin = new PaqueteLogin();
        modeloUsr = new PaqueteUsr();
        gestor.mostrarVistaMenu();
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
    public static PaquetePartida getModeloPartida() {
        return modeloPartida;
    }
    public static PaqueteUsr getModeloUsr() {
        return modeloUsr;
    }
    public static PaqueteLogin getModeloLogin() {
        return modeloLogin;
    }
    
    public static void setSocket(Socket s){
        socketCliente = s;
    }
    
    public static Socket getSocket(){
        return socketCliente;
    }
    

}