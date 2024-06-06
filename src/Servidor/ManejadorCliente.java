
package Servidor;

//--> El cliente que se conecta al servidor

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ManejadorCliente 
        extends Thread
{
    private Socket cliente; //--> Canal de Lectura y Escritura
    private OutputStream os;
    private InputStream is;
    
    
    public ManejadorCliente(Socket sck) throws Exception
    {
        cliente = sck;       
        os = cliente.getOutputStream();
        is = cliente.getInputStream();
        start();
    }
    public void run()
    {
        
        while (true)
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try{
                byte[] buffer = new byte[1024];
                int nb;
                do{
                    nb = is.read(buffer);
                    if (nb>0)
                        baos.write(buffer, 0, nb);
                }while (is.available()>0);
                //-->
                ControladorServidor.difusionMensaje(baos.toByteArray());
            }catch(Exception ex){
                
            }
        }
    }
    
    public void sendMessage(byte[] mensaje) throws Exception
    {
        System.out.println("Haciendo difusion...");
        os.write(mensaje);
    }
    
    
}