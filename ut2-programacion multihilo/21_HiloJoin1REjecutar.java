public class HiloJoin1REjecutar {
	public static void main(String[] args) {
		//Primer hilo
		HiloJoin1R	hilo1 = new HiloJoin1R(100,"+");
        HiloJoin1R	hilo2 = new HiloJoin1R(100,"-");;
        HiloJoin1R	hilo3 = new HiloJoin1R(1,"+");
        HiloJoin1R	hilo4 = new HiloJoin1R(1,"-");
		
        
        
        new Thread(hilo1).start();
        new Thread(hilo2).start();
        new Thread(hilo3).start();
        new Thread(hilo4).start();

       

        

	}
}//Hilo1REjecutar
