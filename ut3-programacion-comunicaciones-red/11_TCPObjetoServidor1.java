import java.io.*;
import java.net.*;

public class TCPObjetoServidor1 {
  public static void main(String[] arg) throws IOException,
						ClassNotFoundException {
   int numeroPuerto = 6000;// Puerto
   ServerSocket servidor =  new ServerSocket(numeroPuerto);
   System.out.println("Esperando al cliente.....");   
   Socket cliente = servidor.accept();
	
   // Se prepara un flujo de salida para objetos 		
   ObjectOutputStream outObjeto = new ObjectOutputStream(
				cliente.getOutputStream()); 	
   // Se prepara un objeto y se envia 
   Persona per = new Persona("Juan", 20);
   outObjeto.writeObject(per); //enviando objeto
   System.out.println("Envio: " + per.getNombre() +"*"+ per.getEdad());  

   // Se obtiene un stream para leer objetos
   ObjectInputStream inObjeto = new ObjectInputStream(
				cliente.getInputStream());
   Persona dato = (Persona) inObjeto.readObject();
   System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());
		
   // CERRAR STREAMS Y SOCKETS
   outObjeto.close();
   inObjeto.close();
   cliente.close();
   servidor.close();
  }
}//..
