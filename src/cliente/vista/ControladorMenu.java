/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import cliente.main.Cliente;
import cliente.modelo.PaqueteDatos;
/**
 *
 * @author javier
 */
public class ControladorMenu {
    private VistaMenuInicial vista;
    private PaqueteDatos modelo;
    
    public ControladorMenu(VistaMenuInicial vista){
        this.vista = vista;
        modelo = Cliente.getModelo();
        
    }
    
    public void procesaEventoCrearUsuario(){
        
    }
    
    public void procesaEventoIniciarSesion(){
        
    }
   
}
