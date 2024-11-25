// Clase CuentaBancaria
// Definición de la cuenta con un saldo inicial y de las operaciones para ingresar dinero (método ingresarDinero) y sacar dinero (método sacarDinero) de la cuenta
class CuentaBancaria {
    int saldo = 1000;
    
    synchronized void sacarDinero (String nombre, int importe)
    {
        if (saldo >= importe) {
            System.out.println(nombre + " sacó de la cuenta " + importe +"€");
            saldo = saldo - importe;
            System.out.println("Saldo actual cuenta= "+saldo +"€");

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            
            System.out.println(nombre + " no puede sacar " + importe +"€ -> NO HAY SALDO SUFICIENTE");
            System.out.println("Saldo actual cuenta= "+saldo +"€");
            
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized void ingresarDinero (String nombre, int importe)
    {
        System.out.println(nombre + " ingresó en la cuenta "+ importe +"€");
        saldo = saldo + importe;
        System.out.println("Saldo actual cuenta= "+saldo +"€");
                
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


// Método - Método de retiro
// Llamada desde la clase ThreadWithdrawal
// utilizando el objeto de la clase Banca pasado
// desde el método main()
class HiloSacarDinero extends Thread {
    
    private CuentaBancaria cuenta;
    private String nombre;
    private int cantidad;
    
    // Constructor de esta clase
    HiloSacarDinero(CuentaBancaria micuenta, String nombre, int cantidad)
    {
        this.cuenta = micuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    // método run() para el hilo
    public void run() { 
        cuenta.sacarDinero(nombre,cantidad);
    }
}
// El método Deposit se llama desde la clase ThreadDeposit
// utilizando el objeto de la clase Banca
// pasado desde el método main
class HiloIngresarDinero extends Thread {
    private CuentaBancaria cuenta;
    private String nombre;
    private int cantidad;

    HiloIngresarDinero (CuentaBancaria micuenta, String nombre, int cantidad)
    {
        // La palabra clave "this" se refiere a la propia instancia actual
        this.cuenta = micuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    // método run() para el hilo
    public void run() { 
        cuenta.ingresarDinero(nombre,cantidad);
    }
}

// Clase Principal
public class HiloCajeroAutomatico {
    // Metodo Main
    public static void main(String[] args)
    {
        // Declarar un objeto de la clase Banca y pasar el objeto
        // junto con otros parámetros a la clase ThreadWithdrawal
        // y ThreadDeposit. Esto será necesario para llamar
        // a los métodos withdrawn y deposit
        // de esas clases
        // Creación de un objeto de la clase Banca
        CuentaBancaria micuenta= new CuentaBancaria();

        

        HiloIngresarDinero t1 = new HiloIngresarDinero(micuenta, "Padre", 200);
        HiloSacarDinero t2 = new HiloSacarDinero(micuenta, "Madre", 800);
        HiloIngresarDinero t3 = new HiloIngresarDinero(micuenta, "Hijo1", 300);
        HiloSacarDinero t4  = new HiloSacarDinero(micuenta, "Hijo2", 800);
        HiloSacarDinero t5  = new HiloSacarDinero(micuenta, "Abuelo", 600);
        // Cuando un programa llama al método start(),
        // se crea un nuevo hilo y
        // luego se ejecuta el método run()
        // Inicio de los hilos creados anteriormente
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

       
    }
}
