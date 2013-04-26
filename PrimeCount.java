
public class PrimeCount {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1; 
		int primeNumHolder = 2;
		while(i<10001){
			primeNumHolder =  getNextPrime(primeNumHolder);
			i++;
		}
		
		System.out.println(primeNumHolder);
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
