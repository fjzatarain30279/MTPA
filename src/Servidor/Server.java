/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Servidor;

import java.util.Scanner;

/**
 *ggi 
* @author javier
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ControladorServidor srv = new ControladorServidor();
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    opcion1();
                    System.out.println(srv.getListaUsuarios().keySet().toString());
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    opcion3();
                    break;
                case 4:
                    opcion4();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    srv.guardaDatos();
                    srv.setActive(false);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println(); // Línea en blanco para separar iteraciones del menú
        } while (opcion != 0);

        scanner.close();
    }
    public static void mostrarMenu() {
        System.out.println("=== Menú de Opciones ===");
        System.out.println("1. Obtener listado de usuarios registrados del servidor");
        System.out.println("2. Obtener listado de usuarios en linea");
        System.out.println("3. Obtener listado de las partidas del servidor");
        System.out.println("4. Obtener Informacion de una partida concreta");
        System.out.println("0. Salir");
    }

    public static void opcion1() {
        System.out.println("Has seleccionado la opción 1");
        
    }

    public static void opcion2() {
        System.out.println("Has seleccionado la opción 2");
        // Agrega aquí el código correspondiente a la opción 2
    }

    public static void opcion3() {
        System.out.println("Has seleccionado la opción 3");
        // Agrega aquí el código correspondiente a la opción 3
    }

    public static void opcion4() {
        System.out.println("Has seleccionado la opción 4");
        // Agrega aquí el código correspondiente a la opción 4
    }
    
}
