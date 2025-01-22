/*Clase URL: Representa la URL con la que deseas interactuar.
Clase URLConnection: Permite establecer una conexión con la URL especificada y obtener sus datos.
Método openConnection(): Abre una conexión con la URL.
Lectura de datos: Utiliza BufferedReader para leer el flujo de entrada proporcionado por la conexión.
Excepciones: El bloque try-catch captura cualquier error durante la conexión o lectura.*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo1urlCon {
    public static void main(String[] args) {
        try {
            // Especifica la URL a conectar
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            
            // Abre la conexión a la URL
            URLConnection urlConnection = url.openConnection();
            
            // Configura la conexión (opcional)
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // Abre un flujo para leer el contenido de la URL
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            
            // Lee línea por línea
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            
            // Cierra el flujo
            in.close();
            
            // Imprime el contenido obtenido
            System.out.println("Contenido recibido:");
            System.out.println(content.toString());
        } catch (Exception e) {
            System.out.println("Error al conectar con la URL: " + e.getMessage());
        }
    }
}

