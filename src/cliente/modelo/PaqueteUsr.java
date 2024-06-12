/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.modelo;

import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class PaqueteUsr {
    private ArrayList<String> listaUsuarios;

    public ArrayList<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public PaqueteUsr(){
        listaUsuarios = new ArrayList<String>();
    }
    
    
}
