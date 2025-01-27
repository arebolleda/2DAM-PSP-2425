import java.io.*;
import java.net.*;

public class TCPServerSocket2 {
  public static void main(String[] arg) throws IOException {
	int numeroPuerto = 6666;// Puerto
	ServerSocket servidor = new ServerSocket(numeroPuerto);
	Socket clienteConectado = null;
	System.out.println("Esperando al cliente.....");
	clienteConectado = servidor.accept();

	// Creación flujo de entrada del cliente -> permite recuperar los mensajes que el cliente escribe en el socket
	InputStream entrada = null;
	entrada = clienteConectado.getInputStream();
	DataInputStream flujoEntrada = new DataInputStream(entrada);

	//Recibiendo datos del cliente ...
	System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readUTF());

	// Creación flujo de salida hacia cliente -> permite escribir mensajes queremos cliente reciba
	OutputStream salida = null;
	salida = clienteConectado.getOutputStream();
	DataOutputStream flujoSalida = new DataOutputStream(salida);

	//Enviando datos al cliente
	flujoSalida.writeUTF("Saludos al cliente del servidor");

	// Cierre streams y sockets
	entrada.close();
	flujoEntrada.close();

	salida.close();
	flujoSalida.close();
	
	clienteConectado.close();
	servidor.close();
  }// main
}// fin
