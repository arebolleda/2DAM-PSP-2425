//Clase que extiende Thread
// Variable contador que se incrementa de 5 en 5 en el método run()

//Método getContador() -> obtiene el valor de la variable contador

//Método pararHilo() -> para el hilo a través de una condición

class HiloPrioridad1 extends Thread {
    private int contador = 0;
    private boolean stopHilo= false; 
    
    public HiloPrioridad1(String nombre) {
          super(nombre);		
    }
    public int getContador()  {
           return contador;
    }  
    public void pararHilo()  {
            stopHilo = true;         
    }  
    public void run() {
      while (!stopHilo) {
          try {
                Thread.sleep(2);
              } catch (Exception e) { }
              contador=contador+5;      	
      } 
      System.out.println("Fin hilo  "+ this.getName());
      
    }//
    
   
    public static void main(String args[]) {    
      HiloPrioridad1 h1 = new HiloPrioridad1("Hilo1");
      HiloPrioridad1 h2 = new HiloPrioridad1("Hilo2");
      HiloPrioridad1 h3 = new HiloPrioridad1("Hilo3");	
        
      h1.setPriority(Thread.NORM_PRIORITY);
      h2.setPriority(Thread.MAX_PRIORITY);    
      h3.setPriority(Thread.MIN_PRIORITY);   
      
      h1.start();	
      h2.start();
      h3.start();  	
  
     try {
        Thread.sleep(10000);
      } catch (Exception e) { }
  
  
      h1.pararHilo() ;
      h2.pararHilo() ;
      h3.pararHilo() ;
      
      System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
      System.out.println("h1 (Prioridad Normal): " + h1.getContador());  	
      System.out.println("h3 (Prioridad Minima): " + h3.getContador());
  
    }
  }
