/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Servidor.paquetes.PaquetePartida;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author javier
 */
public class LectorFicheros {
    
    public static HashMap<String,String> lecturaFichero(String linea){
       HashMap<String,String> listado = new HashMap();
       try (BufferedReader br = new BufferedReader(new FileReader(linea))) {
            String aux;
            while ((aux = br.readLine()) != null) {
                listado.put(aux.split(";")[0], aux.split(";")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       return listado;
    }
    
    public static ArrayList<PaquetePartida> lecturaPartidas(String linea){
        ArrayList<PaquetePartida> listaPartidas = new ArrayList();

        
        return listaPartidas;
    }
    
    public static ArrayList<String> lecturaPuntuaciones(String linea){
        ArrayList<String> ranking = new ArrayList();
        
        
        return ranking;
    }
}
