public class SumNumHilosR implements Runnable {

    //Variable acumula la suma 
    private static long totalSum = 0;
	private final int start;
    private final int end;
		
    // Clase que implementa Runnable para realizar la suma parcial
     SumNumHilosR(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            
            for (int i = start; i < end; i++) 
                totalSum=totalSum+ i;
            

        }
    

    public static void main(String[] args) {
        
						
			//Creación objetos clase
			SumNumHilosR h1 = new SumNumHilosR(1,10000);
        	SumNumHilosR h2 = new SumNumHilosR(10001,20000);
			SumNumHilosR h3 = new SumNumHilosR(20001,30000);
        
			//Creación hilos
			Thread hilo1 = new Thread(h1);
			Thread hilo2 = new Thread(h2);
			Thread hilo3 = new Thread(h3);
		
			hilo1.start();
		    hilo2.start();
			hilo3.start();
			
       System.out.println("La suma total es: " + totalSum);
    }
}
