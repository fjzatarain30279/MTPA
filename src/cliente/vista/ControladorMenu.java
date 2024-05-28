/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;

import cliente.main.Cliente;
import cliente.modelo.PaqueteLogin;

/**
 *
 * @author javier
 */
public class ControladorMenu {

    public static final int PUERTO = 2000;
    private VistaMenuInicial vista;
    private PaqueteLogin modelo;

    public ControladorMenu(VistaMenuInicial vista) {
        this.vista = vista;
        modelo = Cliente.getModeloLogin();

    }

    public void procesaEventoCrearUsuario() {
        String usr = "";
        String pwd = "";
        usr = vista.getUsr();
        pwd = vista.getPswd();
        if (usr.length() < 1) {
            vista.setErrMessage("Longitud muy pequeña");
        } else if (pwd.length() < 1) {
            vista.setErrMessage("Longitud password muy pequeña");
        } else {
            try {
                vista.setErrMessage("Creando cuenta en el servidor...");
                java.net.Socket miSocket = new java.net.Socket("localhost", PUERTO);
                java.io.PrintStream outred = new java.io.PrintStream(miSocket.getOutputStream());
                outred.println(usr + ";" + pwd); // envia al servidor
                //vista.setErrMessage("Envio correcto de datos...");
                Cliente.getGestorVistas().mostrarVistaUsuarios();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void procesaEventoIniciarSesion() {
        String usr = "";
        String pwd = "";
        usr = vista.getUsr();
        pwd = vista.getPswd();
        if (usr.length() < 1) {
            vista.setErrMessage("Longitud muy pequeña");
        } else if (pwd.length() < 1) {
            vista.setErrMessage("Longitud password muy pequeña");
        } else {
            try {
                vista.setErrMessage("Contactando con el servidor...");
                java.net.Socket miSocket = new java.net.Socket("localhost", PUERTO);
                java.io.PrintStream outred = new java.io.PrintStream(miSocket.getOutputStream());
                outred.println(usr.concat(pwd)); // envia al servidor
                //vista.setErrMessage("Envio correcto de datos...");
                Cliente.getGestorVistas().mostrarVistaUsuarios();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
