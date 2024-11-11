public class HiloContador implements Runnable {
 
    //Atributos
    private int contador;
    private String nombre;
    private int limite;
 
    //Constructor
    public HiloContador(String nombre, int limite) {
        this.contador = 0;
        this.nombre = nombre;
        this.limite = limite;
    }
 
    
    public void run() {
 
        //Recorremos los numeros
        while (contador <= limite) {
            System.out.println("Hilo " + nombre + ": " + contador);
            contador++;
        }
 
        //fin de hilo
        System.out.println("Hilo " + nombre + " finalizado");
         
    }
    
    
    public static void main(String[] args) {
 
        //Creamos los objetos
        HiloContador c1 = new HiloContador("Contador 1", 40);
        HiloContador c2 = new HiloContador("Contador 2", 50);
        HiloContador c3 = new HiloContador("Contador 3", 20);
        HiloContador c4 = new HiloContador("Contador 4", 70);
 
        //Creamos los hilos
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
 
        //Iniciamos los hilos
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
	/*
        //Esperamos a que acaben los hilos
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
 	*/
        
        //Fin
        System.out.println("Fin del programa");
 
    }
 
}
