
public class SummationPrimeNumber {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		long Sum = 2; 
		int primeNumHolder = 2;
		while(primeNumHolder<2000000){
			primeNumHolder =  getNextPrime(primeNumHolder);
			System.out.println("Prime Number: " + primeNumHolder);
			Sum += primeNumHolder;
			System.out.println("Sum : " + Sum);
		}
		
		System.out.println(Sum);
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
