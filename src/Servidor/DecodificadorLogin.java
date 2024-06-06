/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Servidor.paquetes.PaqueteLogin;

/**
 *
 * @author javier
 */
public class DecodificadorLogin implements Decodificador{
    
    @Override
    public PaqueteLogin decodificar(String linea){
        PaqueteLogin p = new PaqueteLogin();
        return p;
    }
}
