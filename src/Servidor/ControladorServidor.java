package Servidor;

import java.io.IOException;
import Servidor.paquetes.PaqueteLogin;
import Servidor.paquetes.PaquetePartida;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorServidor
        implements Runnable {

    private ServerSocket servidor;
    HashMap<String, String> listaUsuarios = new HashMap<String, String>();
    private static ArrayList<ManejadorCliente> listaManejadores = new ArrayList<>();
    private static ArrayList<PaquetePartida> listaPartidas;
    private static ArrayList<String> ranking;
    private Thread t;
    private boolean active = true;

    public ControladorServidor() throws Exception {
        servidor = new ServerSocket(2000);
        t = new Thread(this, "ControladorServidor");
        t.start();
    }

    public void run() {
        try {
            startListeningUsers();
        } catch (Exception e) {
        }
    }

    public void startListeningUsers() throws Exception {
        setListaUsuarios(LectorFicheros.lecturaFichero("Usuarios.txt"));
        setRanking(LectorFicheros.lecturaPuntuaciones("Puntuaciones.txt"));
        while (isActive()) {
            System.out.println("Esperando clientes....");
            Socket sck = servidor.accept();
            System.out.println("Un cliente conectado...");
            Runnable sirviente = () -> {
                try {
                    java.io.BufferedReader inred = new java.io.BufferedReader(new java.io.InputStreamReader(sck.getInputStream()));
                    java.io.PrintStream outred = new java.io.PrintStream(sck.getOutputStream());
                    String linea;
                    DecodificadorLogin dec = new DecodificadorLogin();
                    PaqueteLogin p;
                    boolean correcto = false;
                    while (((linea = inred.readLine()) != null) && (correcto == false)) {
                        p = dec.decodificar(linea);
                        if (p.getComprobado() == -1) {
                            System.out.println("CREANDO USR");
                            if (compruebaLogin(p.getUsuario(), p.getPassword()) != 1) {
                                p.setComprobado(1);
                                outred.println(p.toString());
                                System.out.println("USR ya existente");

                            } else {
                                creaUsr(p.getUsuario(), p.getPassword());
                                p.setComprobado(3);
                                outred.println(p.toString());
                                correcto = true;
                                System.out.println("Creacion Correcta");

                            }
                        } else {
                            p.setComprobado(compruebaLogin(p.getUsuario(), p.getPassword()));
                            if (p.getComprobado() == 3) {
                                correcto = true;
                            }
                            System.out.println("Comprobacion de usuario y contraseña");

                            outred.println(p.toString());
                        }
                    }

                } catch (java.io.IOException ioe) {
                    System.err.println("Cerrando socket de cliente");
                    ioe.printStackTrace(System.err);
                }
            };
            Thread s = new Thread(sirviente, "Sirviente login");
            s.start();

        }
        System.out.println("Servidor.ControladorServidor.startListeningUsers()");

    }

    public static void difusionMensaje(byte[] mensaje) {
        for (ManejadorCliente unCliente : listaManejadores) {
            try {
                unCliente.sendMessage(mensaje);
            } catch (Exception e) {
                System.out.println("Err. Difusion: " + e.toString());
            }

        }
    }

    public synchronized void creaUsr(String usr, String pwd) {
        listaUsuarios.put(usr, pwd);
    }

    public int compruebaLogin(String usr, String pwd) {
        if (listaUsuarios.containsKey(usr) == false) {
            return 1;
        } else if (listaUsuarios.get(usr).equals(pwd) == false) {
            return 2;
        } else {
            return 3;
        }
    }

    public void guardaDatos() {
        LectorFicheros.guardaUsr("Usuarios.txt", listaUsuarios);
        LectorFicheros.guardaPuntuaciones("Puntuaciones.txt", ranking);
        LectorFicheros.guardaPartidas("Partidas.txt", listaPartidas);
    }

    public HashMap<String, String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashMap<String, String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public static ArrayList<ManejadorCliente> getListaManejadores() {
        return listaManejadores;
    }

    public static void setListaManejadores(ArrayList<ManejadorCliente> listaManejadores) {
        ControladorServidor.listaManejadores = listaManejadores;
    }

    public static ArrayList<PaquetePartida> getListaPartidas() {
        return listaPartidas;
    }

    public static void setListaPartidas(ArrayList<PaquetePartida> listaPartidas) {
        ControladorServidor.listaPartidas = listaPartidas;
    }

    public static ArrayList<String> getRanking() {
        return ranking;
    }

    public static void setRanking(ArrayList<String> ranking) {
        ControladorServidor.ranking = ranking;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) throws IOException {
        this.active = active;

    }

    public Thread getT() {
        return t;
    }

}
