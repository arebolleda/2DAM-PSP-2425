public class SumarNumeros {

    private static long totalSum = 0;

    public static void main(String[] args) {
        
            
            for (int j = 1; j < 30000; j++) {
                totalSum += j;
            }

            
        

        System.out.println("La suma total es: " + totalSum);
    }
}
