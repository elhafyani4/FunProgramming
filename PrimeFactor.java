import java.util.ArrayList;
import java.util.Arrays;


public class PrimeFactor {

  /**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		final long num = 600851475143L;
		long largestFact = 0;
		long[] factors = new long[2];
		
		
		
		
		int lastPrimeNum = 2;
		
		for(long i = 2; i*i < num ; i++){
			if(num%i == 0){
				factors[0] = i;
				factors[1] = num / i;
				
				for(int k = 0; k<2; k++){
					boolean isPrime = true;
					for (long j = 2; j*j < factors[k]; j++){
						if(factors[k]%j==0){
							isPrime = false;
							break;
						}
					}
					
					if(isPrime && factors[k] > largestFact){
						largestFact = factors[k];
					}
				}
				
				
			}
			
		}
		
		System.out.println(largestFact);
		
	}
	
	
	public static int getNextPrime(int start){
		boolean primeFound = false;
		while(!primeFound){
			start++;
			if(isPrime(start)){
				primeFound = true;
			}
		}
		return start;
	}
	
	
	public static boolean isPrime(int number){
        for(int i=2; i<number; i++){
           if(number%i == 0){
               return false; //number is divisible so its not prime
           }
        }
        return true; //number is prime now
    }

}
